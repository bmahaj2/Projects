using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using BusinessTier;
using ZedGraph;

namespace StockMarketSimulator
{
    
    public partial class MainForm : Form
    {
        private BusinessTier.User loggedUser;
        private BusinessTier.BusinessLogic bLogic;
        private DataTable dt = null;
        public MainForm(BusinessTier.User usr, BusinessTier.BusinessLogic b)
        {
            InitializeComponent();
            this.loggedUser = usr;
            this.bLogic = b;
            this.mainFormLoadingCircle.Visible = false;
            this.mainFormLoadingCircle.Active = true;
            this.mainFormLoadingCircle.OuterCircleRadius = 42;
            this.mainFormLoadingCircle.InnerCircleRadius = 14;
            this.mainFormLoadingCircle.SpokeThickness = 4;
            this.mainFormLoadingCircle.NumberSpoke = 14;
            // this enforces the user to see the hotkeys
            mainFormMenuStrip.Renderer = new CustomMenuStripRenderer();
            this.KeyPreview = true;
            this.KeyDown += new KeyEventHandler(Form_KeyDown);
            this.Size = new Size(1002, 783);
            populateControls(this.zedPieControl);
            this.nameLabel.Text += " " + loggedUser.firstName.ToString() + " " + loggedUser.lastName.ToString();
            this.cashTextBox.Text = loggedUser.balance.ToString(String.Format("c"));
        }

        private async void populateControls(ZedGraphControl zgc)
        {
            /////////////Show the gridView control with verious columns////////////////////
            Double totalInvestment = 0.0;
            Double totalReturn = 0.0;
            this.mainFormLoadingCircle.Visible = true;
            dt = await Task.Run(() =>bLogic.getUserPurchaseTable(loggedUser.userName));
            if (dt.Rows.Count > 0)
            {
                dt.Columns.Add("Total Return", typeof(System.Double));
                dt.Columns.Add("Current Bid", typeof(System.Double));
                dt.Columns.Add("Current Ask", typeof(System.Double));
                List<Quote> quotes = new List<Quote>();

                foreach (DataRow dr in dt.Rows)
                {
                    quotes.Add(new Quote(dr["Symbol"].ToString()));

                }
                await Task.Run(() =>YahooStockEngine.Fetch(quotes));
                int i = 0;
                double currPrice = 0.0;
                foreach (DataRow dr in dt.Rows)
                {
                    if (quotes!= null && quotes[i] != null && quotes[i].Bid != null)
                    {
                        currPrice = (double)quotes[i].Bid;
                        currPrice *= System.Convert.ToDouble(dr["Total Stocks"].ToString());
                        dr["Current Bid"] = (double)quotes[i].Bid;
                    }
                    else
                    {
                        currPrice = System.Convert.ToDouble(dr["Total Investment"]);
                        dr["Current Bid"] = 0.0;
                    }
                    if (quotes != null && quotes[i] != null && quotes[i].Ask != null)
                    {
                        dr["Current Ask"] = (double)quotes[i].Ask;
                    }
                    else
                    {
                        currPrice = System.Convert.ToDouble(dr["Total Investment"]);
                        dr["Current Ask"] = 0.0;
                    }
                    totalReturn += currPrice;
                    totalInvestment += System.Convert.ToDouble(dr["Total Investment"]);
                    dr["Total Return"] = currPrice; //.ToString (String.Format("#.##"));
                    i++;
                }
                this.cashTextBox.Text = loggedUser.balance.ToString(String.Format("c"));
                this.returnTextBox.Text = totalReturn.ToString(String.Format("c"));
                this.investTextBox.Text = totalInvestment.ToString(String.Format("c"));
                double profitLoss = (totalReturn - totalInvestment);
                this.profitTextBox.Text = profitLoss.ToString();
                this.stockDataGridView.DataSource = dt;
                this.stockDataGridView.Columns["Total Return"].DefaultCellStyle.Format = "c";
                this.stockDataGridView.Columns["Current Bid"].DefaultCellStyle.Format = "c";
                this.stockDataGridView.Columns["Current Ask"].DefaultCellStyle.Format = "c";
                this.stockDataGridView.Columns["Total Investment"].DefaultCellStyle.Format = "c";
                this.stockDataGridView.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;

            } // end of  if (dt.Rows.Count > 0)
            else
            {
                this.cashTextBox.Text = loggedUser.balance.ToString(String.Format("c"));
                this.returnTextBox.Text = totalReturn.ToString(String.Format("c"));
                this.investTextBox.Text = totalInvestment.ToString(String.Format("c"));
                double profitLoss = (totalReturn - totalInvestment);
                this.profitTextBox.Text = profitLoss.ToString();
                this.stockDataGridView.DataSource = null;
            }
            /////////////Show the graph control with current selected row from the gridView////////////////////
            
            populateGraphControl();

            /////////////Show the Pie Chart control with all the stocks////////////////////

            zgc.GraphPane.CurveList.Clear();
            zgc.GraphPane.GraphObjList.Clear();
            GraphPane myPane = zgc.GraphPane;
            // Set the Titles
            myPane.Title.Text = "Total assets distribution for " +loggedUser.firstName +" "+loggedUser.lastName;
            double[] totReturn = new double[dt.Rows.Count];
            String[] companies = new String[dt.Rows.Count];
            int j = 0;
            foreach (DataRow dr in dt.Rows)
            {
                totReturn[j] = System.Convert.ToDouble(dr["Total Return"].ToString());
                companies[j] = dr["Name"].ToString();
                j++;
            }
            myPane.AddPieSlices(totReturn, companies);
            // Fill the axis background with a gradient
            myPane.Chart.Fill = new Fill(Color.LightGreen, Color.DeepSkyBlue, 45.0f);
            myPane.Fill = new Fill(Color.LightGreen);
            //myPane.Legend.Position = LegendPos.Bottom;
            myPane.Legend.IsVisible = false;
            foreach (var x in myPane.CurveList.OfType<PieItem>())
            {
                x.LabelType = PieLabelType.Name_Percent;
                x.Displacement = x.Value % 0.07;
            }
            zgc.IsShowPointValues = true;
            zgc.AxisChange();
            zgc.Invalidate();
            this.mainFormLoadingCircle.Visible = false;
            return;
        }

        private async void populateGraphControl()
        {
            // Get a reference to the GraphPane instance in the ZedGraphControl
            GraphPane myPane = zg1.GraphPane;
            if (stockDataGridView.SelectedRows.Count <= 0)
            {
                zg1.GraphPane.CurveList.Clear();
                zg1.GraphPane.GraphObjList.Clear();
                // Set the titles and axis labels
                myPane.Title.Text = "Historical Graph ";
                myPane.XAxis.Title.Text = "Time, Days";
                myPane.YAxis.Title.Text = "Daily Close Value";
                myPane.XAxis.MajorGrid.IsVisible = false;
                
                // Fill the axis background with a gradient
                myPane.Chart.Fill = new Fill(Color.LightYellow, Color.DeepSkyBlue, 45.0f);
                myPane.Fill = new Fill(Color.LightGreen);
                // Enable scrollbars if needed
                zg1.IsShowHScrollBar = true;
                zg1.IsShowVScrollBar = true;
                zg1.IsAutoScrollRange = true;
                zg1.IsScrollY2 = true;
                // OPTIONAL: Show tooltips when the mouse hovers over a point
                zg1.IsShowPointValues = true;
                // Tell ZedGraph to calculate the axis ranges
                // Note that you MUST call this after enabling IsAutoScrollRange, since AxisChange() sets
                // up the proper scrolling parameters
                zg1.AxisChange();
                // Make sure the Graph gets redrawn
                zg1.Invalidate();
                return;
            }
            String name = stockDataGridView.SelectedRows[0].Cells["Name"].Value.ToString();
            String symbol = stockDataGridView.SelectedRows[0].Cells["Symbol"].Value.ToString();
            zg1.GraphPane.CurveList.Clear();
            zg1.GraphPane.GraphObjList.Clear();

            // Set the titles and axis labels
            myPane.Title.Text = "Historical Graph of " + name;
            myPane.XAxis.Title.Text = "Time, Days";
            myPane.YAxis.Title.Text = "Daily Close Value";

            // Make up some data points based on the Sine function
            PointPairList list = new PointPairList();
            this.mainFormLoadingCircle.Visible = true;
            //loadingCircle.Visible = true;
            List<HistoricalStock> data = await Task.Run(() => HistoricalStockDownloader.DownloadData(symbol, DateTime.Now.Year));
            this.mainFormLoadingCircle.Visible = false;

            foreach (var i in data)
            {
                if (i.Date.Year >= (DateTime.Now.Year))
                {
                    double x = (double)new XDate(i.Date);
                    double y = i.Close;
                    list.Add(x, y);
                }
            }
            // loadingCircle.Visible = false;
            // Generate a red curve
            LineItem myCurve = myPane.AddCurve(symbol,
                list, Color.Red, SymbolType.None);
            // Fill the symbols with white
            myCurve.Symbol.Fill = new Fill(Color.White);

            // Show the x axis grid
            myPane.XAxis.MajorGrid.IsVisible = true;
            // Set the XAxis to date type
            myPane.XAxis.Type = AxisType.Date;

            // Make the Y axis scale red
            myPane.YAxis.Scale.FontSpec.FontColor = Color.Red;
            myPane.YAxis.Title.FontSpec.FontColor = Color.Red;
            // turn off the opposite tics so the Y tics don't show up on the Y2 axis
            // Don't display the Y zero line
            myPane.YAxis.MajorGrid.IsZeroLine = false;
            // Align the Y axis labels so they are flush to the axis
            myPane.YAxis.Scale.Align = AlignP.Inside;
            // Fill the axis background with a gradient
            myPane.Chart.Fill = new Fill(Color.LightYellow, Color.DeepSkyBlue, 45.0f);
            myPane.Fill = new Fill(Color.LightGreen);
            // Enable scrollbars if needed
            zg1.IsShowHScrollBar = true;
            zg1.IsShowVScrollBar = true;
            zg1.IsAutoScrollRange = true;
            zg1.IsScrollY2 = true;
            // OPTIONAL: Show tooltips when the mouse hovers over a point
            zg1.IsShowPointValues = true;
            // Tell ZedGraph to calculate the axis ranges
            // Note that you MUST call this after enabling IsAutoScrollRange, since AxisChange() sets
            // up the proper scrolling parameters
            zg1.AxisChange();
            // Make sure the Graph gets redrawn
            zg1.Invalidate();
        }

        private void stockDataGridView_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            populateGraphControl();
        }

        // Hot keys handler
        void Form_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.Control && e.KeyCode == Keys.X)       // Ctrl-X exit
            {
                e.SuppressKeyPress = true;  // Stops bing! Also sets handled which stop event bubbling
                exitMainFormMenuStrip_click(sender, e);
            }
            else if (e.Control && e.KeyCode == Keys.F)
            {
                e.SuppressKeyPress = true;
                //fileToolStripMenuItem.
            }
        }

        private void exitMainFormMenuStrip_click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void purchase_FormClosed(object sender, FormClosedEventArgs e)
        {
            this.Show();
            populateControls(this.zedPieControl);
        }

        private void purchaseToolStripMenuItem_Click(object sender, EventArgs e)
        {
            PurchaseForm purchaseForm = new PurchaseForm(loggedUser, bLogic);
            purchaseForm.FormClosed += new FormClosedEventHandler(purchase_FormClosed);
            purchaseForm.Show();
            this.Hide();
        }

        private void sellToolStripMenuItem_Click(object sender, EventArgs e)
        {
            watchListForm watchForm = new watchListForm(loggedUser, bLogic);
            watchForm.FormClosed += new FormClosedEventHandler(purchase_FormClosed);
            watchForm.Show();
            this.Hide();
        }


        private void sellButton_Click(object sender, EventArgs e)
        {
            double newBalance = 0.0;
            double bid = System.Convert.ToDouble(stockDataGridView.SelectedRows[0].Cells["Current Bid"].Value.ToString());
            string symbol = stockDataGridView.SelectedRows[0].Cells["Symbol"].Value.ToString();
            string name = stockDataGridView.SelectedRows[0].Cells["Name"].Value.ToString();

            int selectedQty = System.Convert.ToInt32(this.qtyNumericUpDown.Value.ToString());
            if (selectedQty > System.Convert.ToInt32(stockDataGridView.SelectedRows[0].Cells["Total Stocks"].Value.ToString()))
            {
                MessageBox.Show("Sorry, you selected too much Qty to sell.\n", "Invalid QTY", MessageBoxButtons.OK, MessageBoxIcon.Warning);
            }
            else if (bid <= 0.00)
            {
                MessageBox.Show("Sorry, invalid bid price to sell.\n", "Invalid Bid price", MessageBoxButtons.OK, MessageBoxIcon.Warning);
            }
            else
            {
               
                newBalance = this.loggedUser.balance + (bid*selectedQty);
                bool result;
                DialogResult dialogRes = MessageBox.Show("You are about to sell " + selectedQty + " stock from " + name +"\nYour new balance will be " + newBalance.ToString(),
                   "Confirmation for purchase", MessageBoxButtons.OKCancel, MessageBoxIcon.Question);
                DateTime today = DateTime.Today;
                if (dialogRes == DialogResult.Cancel)
                {
                    return;
                }
                int stockID = bLogic.GetStockID(symbol);
                //MessageBox.Show("Arguments-> newBalance "+newBalance+" loggedID "+loggedUser.id+" stockID "+stockID);
                result = bLogic.UpdateBalance(newBalance, loggedUser.userName, loggedUser.id, stockID, bid, today, selectedQty, "Sold");
                if (result == true)
                {
                    cashTextBox.Text = newBalance.ToString();
                    this.loggedUser.balance = newBalance;

                }
                qtyNumericUpDown.Value = 1;
            }
            populateControls(this.zedPieControl);
            return;
        }

        private void historyToolStripMenuItem_Click(object sender, EventArgs e)
        {
            HistoryStatementForm historyForm = new HistoryStatementForm(loggedUser, bLogic);
            historyForm.FormClosed += new FormClosedEventHandler(purchase_FormClosed);
            historyForm.Show();
            this.Hide();
        }

        private void currencyTextBox_TextChanged(object sender, EventArgs e)
        {
            try
            {
                double value;
                // Convert the text to a Double and determine if it is a negative number.
                if ((value = double.Parse(profitTextBox.Text)) < 0)
                {
                    // If the number is negative, display it in Red.
                    profitTextBox.Enabled = true;
                    profitTextBox.Text = String.Format(System.Globalization.CultureInfo.CreateSpecificCulture("en-US"), "{0:C2}", value);
                    profitTextBox.ForeColor = Color.DarkRed;
                }
                else
                {
                    // If the number is not negative, display it in Black.
                    profitTextBox.Text = String.Format(System.Globalization.CultureInfo.CreateSpecificCulture("en-US"), "{0:C2}", value);
                    profitTextBox.ForeColor = Color.DarkGreen;
                }
            }
            catch
            {
                // If there is an error, display the text using the system colors.
                profitTextBox.ForeColor = SystemColors.ControlText;
            }
        }


    }

    class CustomMenuStripRenderer : ToolStripProfessionalRenderer
    {
        public CustomMenuStripRenderer() : base() { }
        public CustomMenuStripRenderer(ProfessionalColorTable table) : base(table) { }

        protected override void OnRenderItemText(ToolStripItemTextRenderEventArgs e)
        {
            e.TextFormat &= ~TextFormatFlags.HidePrefix;
            base.OnRenderItemText(e);
        }
    }
}
