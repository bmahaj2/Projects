using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using ZedGraph;
using BusinessTier;

namespace StockMarketSimulator
{
    public partial class HistoryGraphForm : Form
    {
        private string symbol = string.Empty;
        private string name = string.Empty;
        public HistoryGraphForm(string sym, string nm)
        {
            InitializeComponent();
            this.symbol = sym;
            this.name = nm;
            loadingCircle.Active = true;
            loadingCircle.OuterCircleRadius = 30;
            loadingCircle.InnerCircleRadius = 14;
            loadingCircle.SpokeThickness = 3;
            loadingCircle.NumberSpoke = 14;
        }

        private async void HistoryGraphForm_Load(object sender, EventArgs e)
        {
            // Get a reference to the GraphPane instance in the ZedGraphControl
            GraphPane myPane = zg1.GraphPane;

            //foreach (HistoricalStock stock in data)
            //{
            //    MessageBox.Show(string.Format("Date={0} High={1} Low={2} Open={3} Close{4}", stock.Date, stock.High, stock.Low, stock.Open, stock.Close));
            //}

            // Set the titles and axis labels
            myPane.Title.Text = "Historical Graph of " + name;
            myPane.XAxis.Title.Text = "Time, Days";
            myPane.YAxis.Title.Text = "Daily Close Value";

            // Make up some data points based on the Sine function
            PointPairList list = new PointPairList();

            loadingCircle.Visible = true;
            List<HistoricalStock> data = await Task.Run(() => HistoricalStockDownloader.DownloadData(symbol, DateTime.Now.Year - 5));
            //MessageBox.Show((DateTime.Now.Year - 5).ToString());

            foreach (var i in data)
            {
                if (i.Date.Year >= (DateTime.Now.Year - 5))
                {
                    double x = (double)new XDate(i.Date);
                    double y = i.Close;
                    list.Add(x, y);
                }
            }
            loadingCircle.Visible = false;
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

            // OPTIONAL: Handle the Zoom Event
            zg1.ZoomEvent += new ZedGraphControl.ZoomEventHandler(MyZoomEvent);

            // Size the control to fit the window
            SetSize();

            // Tell ZedGraph to calculate the axis ranges
            // Note that you MUST call this after enabling IsAutoScrollRange, since AxisChange() sets
            // up the proper scrolling parameters
            zg1.AxisChange();
            // Make sure the Graph gets redrawn
            zg1.Invalidate();
        }

        /// <summary>
        /// On resize action, resize the ZedGraphControl to fill most of the Form, with a small
        /// margin around the outside
        /// </summary>
        private void HistoryGraphForm_Resize(object sender, EventArgs e)
        {
            SetSize();
        }

        private void SetSize()
        {
            zg1.Location = new Point(10, 10);
            // Leave a small margin around the outside of the control
            zg1.Size = new Size(this.ClientRectangle.Width - 20,
                    this.ClientRectangle.Height - 20);
        }




        // Respond to a Zoom Event
        private void MyZoomEvent(ZedGraphControl control, ZoomState oldState,
                    ZoomState newState)
        {
            // Here we get notification everytime the user zooms
        }

    }
}
