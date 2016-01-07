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
    public partial class watchListForm : Form
    {
        private BusinessTier.User loggedUser;
        private BusinessTier.BusinessLogic bLogic;

        private List<BusinessTier.Stock> stock;

        private int searchFlag = 0;

        private string watchlistGridSelectedSymbol = null;
        private double current_price = 0.0;
        private int stockId;
        

        public watchListForm(BusinessTier.User usr, BusinessTier.BusinessLogic b)
        {
            InitializeComponent();
           
            this.loggedUser = usr;
            this.bLogic = b;
            searchAutocomplete();

            if (bLogic.isWatchlistEmpty(loggedUser.id))
            {
                watchlistDataGridView.Rows.Clear();
                
                removeFromWatchlist.Enabled = false;
            }
            else
            {
                populateWatchListTable();
                removeFromWatchlist.Enabled = true;
                //populateGraph();
            }
            industriesComboBox.ValueMember = "Industry";
            industriesComboBox.DisplayMember = "Industry";
            industriesComboBox.DataSource = bLogic.populateIndustryDropDown();


        }



        private void industriesComboBox_SelectionChangeCommitted(object sender, EventArgs e)
        {

        }


        private void industriesComboBox_SelectedIndexChanged(object sender, EventArgs e)
        {
            if(searchFlag != 1)
            {
             this.searchTextBox.Clear();
            }
            Object selectedValue = industriesComboBox.SelectedValue;
            //MessageBox.Show(industriesComboBox.SelectedValue.ToString());
            //bLogic.populateCompanyListWithStockName(industriesComboBox.SelectedValue.ToString());
            if (NamesRadioButton.Checked.ToString().Equals("True"))
            {
                companyListBox.DataSource = null;
                companyListBox.DisplayMember = "Name";
                companyListBox.ValueMember = "Symbol";
                companyListBox.DataSource = bLogic.populateCompanyListWithStockName(industriesComboBox.SelectedValue.ToString());
                // DataTable dt = bLogic.populateCompanyListWithStockName(industriesComboBox.SelectedValue.ToString());
                //companyListBox.Items.Clear();
                //companyListBox.Items.AddRange(dt.ToArray());
                //companyListBox.SelectionMode = SelectionMode.None;
            }
            else
            {
                companyListBox.DataSource = null;
                companyListBox.DisplayMember = "Symbol";
                companyListBox.ValueMember = "Symbol";
                companyListBox.DataSource = bLogic.populateCompanyListWithStockSymbol(industriesComboBox.SelectedValue.ToString());
                // companyListBox.SelectionMode = SelectionMode.None;
                //companyListBox.DataSource = null;
                //companyListBox.DataSource = bLogic.populateCompanyListWithStockSymbol(industriesComboBox.SelectedValue.ToString());
            }

            //companyListBox.DataSource = bLogic.populateCompanyListWithStockSymbol(industriesComboBox.SelectedValue.ToString());
       }

       
        
        
        private void companyListBox_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void NamesRadioButton_CheckedChanged(object sender, EventArgs e)
        {
            if (searchFlag != 1)
            {
                this.searchTextBox.Clear();
            }
            //companyListBox.SelectedIndexChanged -= new EventHandler(this.companyListBox_SelectedIndexChanged);
            companyListBox.DataSource = null;
            companyListBox.DisplayMember = "Name";
            companyListBox.ValueMember = "Symbol";
            companyListBox.DataSource = bLogic.populateCompanyListWithStockName(industriesComboBox.SelectedValue.ToString());
            //companyListBox.ClearSelected();
            //companyListBox.SelectionMode = SelectionMode.None;
            //companyListBox.SelectedIndexChanged += new EventHandler(this.companyListBox_SelectedIndexChanged);
   


        }

        private void symbolRadioButton_CheckedChanged(object sender, EventArgs e)
        {
            if (searchFlag != 1)
            {
                this.searchTextBox.Clear();
            }
            //companyListBox.SelectedIndexChanged -= new EventHandler(this.companyListBox_SelectedIndexChanged);
            companyListBox.DataSource = null;
            companyListBox.DisplayMember = "Symbol";
            companyListBox.ValueMember = "Symbol";
            companyListBox.DataSource = bLogic.populateCompanyListWithStockSymbol(industriesComboBox.SelectedValue.ToString());
            //companyListBox.ClearSelected();
            //companyListBox.SelectionMode = SelectionMode.None;
            //companyListBox.SelectedIndexChanged += new EventHandler(this.companyListBox_SelectedIndexChanged);
       


        }

        private void addToWatchlist_Click(object sender, EventArgs e)
        {
            stock = null;
            stock = bLogic.GetStockInfo(companyListBox.SelectedValue.ToString());
                           

               bool flag = bLogic.CheckWatchlist(loggedUser.id);
                if(flag.Equals(true))
                {
                    bool flag1 = bLogic.AddToWatchlist(loggedUser.id,stock[0].symbol);
                    if(flag1.Equals(false))
                    {
                        MessageBox.Show("This stock already exists in the watchlist");
                    }

                    populateWatchListTable();
                   // populateGraph();

                    if(removeFromWatchlist.Enabled ==  false)
                    {
                        removeFromWatchlist.Enabled = true;
                    }
                }
                else
                {
                    MessageBox.Show("cannot add more than 5 stocks");
                }

        }

        private async void populateWatchListTable()
        {
            DataTable dt = null;


            dt = bLogic.getWatchlistStock(loggedUser.id);
            if (dt.Rows.Count > 0)
            {
                dt.Columns.Add("Current Ask", typeof(System.Double));
                dt.Columns.Add("Current Bid", typeof(System.Double));
                List<Quote> quotes = new List<Quote>();

                foreach (DataRow dr in dt.Rows)
                {
                    quotes.Add(new Quote(dr["Symbol"].ToString()));

                }
                await Task.Run(() => YahooStockEngine.Fetch(quotes));
                //YahooStockEngine.Fetch(quotes);
                int i = 0;
                foreach (DataRow dr in dt.Rows)
                {

                    dr["Current Ask"] = (quotes[i] != null)? ((quotes[i].Ask != null) ? (double)quotes[i].Ask : 0.0): 0.0;
                    dr["Current Bid"] = (quotes[i] != null) ? ((quotes[i].Bid != null) ? (double)quotes[i].Bid : 0.0) : 0.0;
                    i++;
                }

                this.watchlistDataGridView.DataSource = dt;
                this.watchlistDataGridView.Columns["Current Ask"].DefaultCellStyle.Format = "c";
                this.watchlistDataGridView.Columns["Current Bid"].DefaultCellStyle.Format = "c";
                this.watchlistDataGridView.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;
                this.watchlistDataGridView.AutoSizeRowsMode = DataGridViewAutoSizeRowsMode.AllCellsExceptHeaders;
                this.watchlistDataGridView.AutoResizeColumns();


                populateGraph();

            }





        }

        private void button1_Click(object sender, EventArgs e)
        {

        }

        private void removeFromWatchlist_Click(object sender, EventArgs e)
        {
               if (watchlistDataGridView.SelectedCells.Count > 0)
                {
                    int selectedrowindex = watchlistDataGridView.SelectedCells[0].RowIndex;

                    DataGridViewRow selectedRow = watchlistDataGridView.Rows[selectedrowindex];

                    string symbol = Convert.ToString(selectedRow.Cells["Symbol"].Value);
                    

                    bLogic.RemoveFromWatchlist(loggedUser.id, symbol);

                    if (bLogic.isWatchlistEmpty(loggedUser.id))
                    {
                        
                        removeFromWatchlist.Enabled = false;
                        watchlistDataGridView.DataSource = null;
                        zg1.GraphPane.CurveList.Clear();
                        zg1.GraphPane.GraphObjList.Clear();
                        GraphPane myPane = zg1.GraphPane;
                        zg1.AxisChange();
                        zg1.Invalidate();
                    }
                    else
                    {
                        populateWatchListTable();
                        //populateGraph();
                    }
                    

                
            }
        }

        private void groupBox2_Enter(object sender, EventArgs e)
        {
            
        }

        private void watchlistDataGridView_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

            if (watchlistDataGridView.SelectedCells.Count > 0)
            {
                int selectedrowindex = watchlistDataGridView.SelectedCells[0].RowIndex;

                DataGridViewRow selectedRow = watchlistDataGridView.Rows[selectedrowindex];

                watchlistGridSelectedSymbol = Convert.ToString(selectedRow.Cells["Symbol"].Value);

                current_price = System.Convert.ToDouble(selectedRow.Cells["Current Ask"].Value);
                //MessageBox.Show(current_price.ToString());
               // string current_price = Convert.ToString(selectedRow.Cells["Symbol"].Value);
               // MessageBox.Show(watchlistGridSelectedSymbol);

                stock = null;
                stock = bLogic.GetStockInfo(watchlistGridSelectedSymbol);

                stockId = stock[0].id;

            }



          }

        
        private async void populateGraph()
        {

            List<String> symbolList = new List<string>();
            PointPairList list1 = new PointPairList();
            PointPairList list2 = new PointPairList();
            PointPairList list3 = new PointPairList();
            PointPairList list4 = new PointPairList();
            PointPairList list5 = new PointPairList();


            LineItem curve1 = new LineItem("curve1");
            LineItem curve2 = new LineItem("curve1");
            LineItem curve3 = new LineItem("curve1");
            LineItem curve4 = new LineItem("curve1");
            LineItem curve5 = new LineItem("curve1");


            List<Color> colorList = new List<Color>() { Color.Red, Color.Green, Color.Blue, Color.Yellow, Color.Pink };
            List<PointPairList> pointpairList = new List<PointPairList>() { list1, list2, list3, list4, list5 };
            List<LineItem> lineItem = new List<LineItem>() { curve1, curve2, curve3, curve4, curve5 };



            foreach (DataGridViewRow item in watchlistDataGridView.Rows)
            {
                symbolList.Add(item.Cells["Symbol"].Value.ToString());

            }

            double x = 0;
            // double y = 0 ;
            List<double> y = new List<double>() { 0.0, 0.0, 0.0, 0.0, 0.0 };


            zg1.GraphPane.CurveList.Clear();
            zg1.GraphPane.GraphObjList.Clear();
            // Get a reference to the GraphPane instance in the ZedGraphControl
            GraphPane myPane = zg1.GraphPane;

            // Set the titles and axis labels
            //myPane.Title.Text = "Historical Graph of " + name;
            myPane.XAxis.Title.Text = "Time, Days";
            myPane.YAxis.Title.Text = "Daily Close Value";



            //loadingCircle.Visible = true;

            for (int i = 0; i < symbolList.Count; i++)
            {
                //MessageBox.Show(symbolList[i]);


                // Make up some data points based on the Sine function
                // PointPairList list = new PointPairList();
                //pointpairList[i] = new PointPairList();
                List<HistoricalStock> data = await Task.Run(() => HistoricalStockDownloader.DownloadData(symbolList[i], DateTime.Now.Year));
                //List<HistoricalStock> data = HistoricalStockDownloader.DownloadData(symbolList[i], DateTime.Now.Year);
                //MessageBox.Show((DateTime.Now.Year - 5).ToString());



                foreach (var j in data)
                {

                    if (j.Date.Year >= (DateTime.Now.Year))
                    {
                        x = (double)new XDate(j.Date);
                        y[i] = j.Close;
                        pointpairList[i].Add(x, y[i]);
                    }
                }


                //pointpairList[i].Add(x, y[i]);
                // loadingCircle.Visible = false;
                // Generate a red curve

                //LineItem myCurve = myPane.AddCurve(symbolList[i],
                //    pointpairList[i], colorList[i], SymbolType.None);


                lineItem[i] = myPane.AddCurve(symbolList[i],
                  pointpairList[i], colorList[i], SymbolType.None);

                // Fill the symbols with white
                //myCurve.Symbol.Fill = new Fill(Color.White);


                lineItem[i].Symbol.Fill = new Fill(Color.White);


                // Show the x axis grid
                myPane.XAxis.MajorGrid.IsVisible = true;
                // Set the XAxis to date type
                myPane.XAxis.Type = AxisType.Date;

                // Make the Y axis scale red
                myPane.YAxis.Scale.FontSpec.FontColor = Color.Red;
                myPane.YAxis.Title.FontSpec.FontColor = Color.Red;
                // turn off the opposite tics so the Y tics don't show up on the Y2 axis
                //myPane.YAxis.MajorTic.IsOpposite = false;
                //myPane.YAxis.MinorTic.IsOpposite = false;
                // Don't display the Y zero line
                myPane.YAxis.MajorGrid.IsZeroLine = false;
                // Align the Y axis labels so they are flush to the axis
                myPane.YAxis.Scale.Align = AlignP.Inside;


                // Fill the axis background with a gradient
                myPane.Chart.Fill = new Fill(Color.LightYellow, Color.LightGreen, 45.0f);

                //// Add a text box with instructions
                //TextObj text = new TextObj(
                //    "Zoom: left mouse & drag\nPan: middle mouse & drag\nContext Menu: right mouse",
                //    0.05f, 0.95f, CoordType.ChartFraction, AlignH.Left, AlignV.Bottom);
                //text.FontSpec.StringAlignment = StringAlignment.Near;
                //myPane.GraphObjList.Add(text);

                // Enable scrollbars if needed
                zg1.IsShowHScrollBar = true;
                zg1.IsShowVScrollBar = true;
                zg1.IsAutoScrollRange = true;
                zg1.IsScrollY2 = true;

                // OPTIONAL: Show tooltips when the mouse hovers over a point
                zg1.IsShowPointValues = true;


                //myPane.YAxis.Scale.Min = 0;
                //myPane.YAxis.Scale.Max = 30;
                //myPane.YAxis.Scale.MajorStep = 1;

                myPane.XAxis.Scale.Format = "yyyy";
                myPane.XAxis.Scale.MajorUnit = DateUnit.Year;
                myPane.XAxis.Scale.MinorUnit = DateUnit.Year;
                // myPane.XAxis.Scale.Min = new XDate(DateTime.Now.Year - 5.0);
                //myPane.XAxis.Scale.Max = new XDate(DateTime.Now.Year + 0.0);


                // Tell ZedGraph to calculate the axis ranges
                // Note that you MUST call this after enabling IsAutoScrollRange, since AxisChange() sets
                // up the proper scrolling parameters
                zg1.AxisChange();
                // Make sure the Graph gets redrawn
                zg1.Invalidate();


            }






        }



        private async void searchButton_Click_1(object sender, EventArgs e)
        {
            searchFlag = 1;
            string searchString = this.searchTextBox.Text;
            this.industriesComboBox.Text = "All";

            if (searchString == "")
            {
                MessageBox.Show("Please input a search string in the search box");
                return;
            }

            companyListBox.DataSource = null;
            if (NamesRadioButton.Checked)
            {
                companyListBox.DisplayMember = "Name";
            }
            else
            {
                companyListBox.DisplayMember = "Symbol";
            }
            companyListBox.ValueMember = "Symbol";
            companyListBox.DataSource = await Task.Run(() => bLogic.getSearchResults(searchString));

            searchFlag = 0;
        }

        private async void searchAutocomplete()
        {
            var source = new AutoCompleteStringCollection();

            DataTable dt = await Task.Run(() => bLogic.searchAutocomplete());
            for (int i=0;i<dt.Rows.Count ;i++)
             {
                source.Add(dt.Rows[i][0].ToString());
             }
            searchTextBox.AutoCompleteCustomSource = source;
            searchTextBox.AutoCompleteMode = AutoCompleteMode.Suggest;
            searchTextBox.AutoCompleteSource = AutoCompleteSource.CustomSource;

        }

        private void purchaseButton_Click(object sender, EventArgs e)
        {
            if (watchlistDataGridView.SelectedCells.Count > 0)
            {
                int selectedrowindex = watchlistDataGridView.SelectedCells[0].RowIndex;

                DataGridViewRow selectedRow = watchlistDataGridView.Rows[selectedrowindex];

                watchlistGridSelectedSymbol = Convert.ToString(selectedRow.Cells["Symbol"].Value);

                current_price = System.Convert.ToDouble(selectedRow.Cells["Current Ask"].Value);

                stock = null;
                stock = bLogic.GetStockInfo(watchlistGridSelectedSymbol);
                stockId = stock[0].id;

            }
            else
            {
                MessageBox.Show("Sorry, nothing selected to purchase.\n", "None selected to purchase", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }

            double newBalance = 0.0;
            double cost_of_purchase = 0.0;

            int selectedQty = System.Convert.ToInt32(this.qtyNumericUpDown.Value.ToString());

            cost_of_purchase = selectedQty * current_price;


            if (cost_of_purchase == 0.0)
            {
                MessageBox.Show("Sorry, we couldn't obtain current bid price.\n please try again later.\n", "Couldn't retreive bid pricing", MessageBoxButtons.OK, MessageBoxIcon.Warning);
            }
            else if (cost_of_purchase > loggedUser.balance)
            {
                MessageBox.Show("Sorry, you don't have sufficient funds to purchase the stocks.\n", "Insufficient funds", MessageBoxButtons.OK, MessageBoxIcon.Warning);
            }
            else
            {

                newBalance = this.loggedUser.balance - cost_of_purchase;
                bool result;
                DialogResult dialogRes = MessageBox.Show("You are about to purchase " + selectedQty + " stock from " + stock[0].name + "\nIt will cost you "+cost_of_purchase.ToString()+"\nYour new balance will be " + newBalance.ToString(),
                   "Confirmation for purchase", MessageBoxButtons.OKCancel, MessageBoxIcon.Question);
                DateTime today = DateTime.Today;
                if (dialogRes == DialogResult.Cancel)
                {
                    return;
                }

                result = bLogic.UpdateBalance(newBalance, loggedUser.userName, loggedUser.id, stockId, current_price, today, selectedQty, "Bought");

                if (result == true)
                {
                    //cashTextBox.Text = newBalance.ToString();
                    this.loggedUser.balance = newBalance;

                }
                qtyNumericUpDown.Value = 1;
            }
            return;



        }


    }
}
