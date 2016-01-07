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

namespace StockMarketSimulator
{
    public partial class PurchaseForm : Form
    {
        private BusinessTier.User loggedUser;
        private BusinessTier.BusinessLogic bLogic;
        private List<BusinessTier.Stock> stock;
        private double current_price;
        private int stockId;

        private int searchFlag = 0;

        public PurchaseForm(BusinessTier.User usr, BusinessTier.BusinessLogic b)
        {
            InitializeComponent();
            this.loggedUser = usr;
            this.bLogic = b;
            this.nameLabel.Text += " " + loggedUser.firstName.ToString() +" "+ loggedUser.lastName.ToString();
            this.cashTextBox.Text = loggedUser.balance.ToString();
            this.Size = new Size(851, 620);

            searchAutocomplete();
            industriesComboBox.ValueMember = "Industry";
            industriesComboBox.DisplayMember = "Industry";
            industriesComboBox.DataSource = bLogic.populateIndustryDropDown();

        }


 
        private void companyListBox_SelectedIndexChanged(object sender, EventArgs e)
        {

            if (companyListBox.SelectedIndex == -1)
            {

            }
            else
            {

                this.detailListBox.Items.Clear();
                stock = bLogic.GetStockInfo(companyListBox.SelectedValue.ToString());

                detailListBox.Items.Add("Symbol: " + stock[0].symbol);
                detailListBox.Items.Add("Name: " + stock[0].name);
                if (stock[0].ipoYear == 0)
                {
                    detailListBox.Items.Add("IPOYear: N/A");
                }
                else
                {
                    detailListBox.Items.Add("IPOYear: " + stock[0].ipoYear);
                }

                stockId = stock[0].id;
               // detailListBox.Items.Add("ID: " + stock[0].id);
                detailListBox.Items.Add("Sector: " + stock[0].sector);
                detailListBox.Items.Add("Industry: " + stock[0].industry);
                
                
                 List<Quote> quote = new List<Quote>();
                quote.Add(new Quote(stock[0].symbol));
                YahooStockEngine.Fetch(quote);
                foreach (var q in quote)
                {
                    if (q.Ask != null)
                    {
                        stock[0].currentPrice = (double)q.Ask;
                        detailListBox.Items.Add("Current Ask Price: " + stock[0].currentPrice);
                        current_price = System.Convert.ToDouble(q.Ask);
                    }
                    else
                    {
                        stock[0].currentPrice = 0.0;
                        current_price = 0.0;
                        detailListBox.Items.Add("Current Ask Price: Not available");
                    }
                    if (q.Bid != null)
                    {
                        detailListBox.Items.Add("Current bid: " + q.Bid);
                    }
                    else
                    {
                        detailListBox.Items.Add("Current bid: Not available");
                    }
                  detailListBox.Items.Add("Last Trade Price: " + q.LastTradePrice.ToString());
                  detailListBox.Items.Add("Change in percent: "+q.ChangeInPercent.ToString());
                  detailListBox.Items.Add("Last update time: " + q.LastUpdate.ToString());
                  detailListBox.Items.Add("Earnings for share: " + q.EarningsShare);
                  
                  
                }
            }
               // MessageBox.Show(companyListBox.SelectedValue.ToString());
         }

        private void industriesComboBox_SelectedIndexChanged(object sender, EventArgs e)
        {

            if (searchFlag != 1)
            {
                this.searchTextBox.Clear();
            }

            Object selectedValue = industriesComboBox.SelectedValue;
            //searchTextBox.Clear();
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

        private void graphButton_Click(object sender, EventArgs e)
        {
            HistoryGraphForm graph = new HistoryGraphForm(stock[0].symbol, stock[0].name);
            graph.Show();
        }

        private void purchaseButton_Click(object sender, EventArgs e)
        {


            double newBalance = 0.0;
            double cost_of_purchase = 0.0;

            int selectedQty = System.Convert.ToInt32(this.qtyNumericUpDown.Value.ToString());
            
            //MessageBox.Show("Current qty: " + selectedQty.ToString());
            
            cost_of_purchase = selectedQty * current_price;
           // MessageBox.Show("current_price" + current_price);
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
              //  MessageBox.Show("newbalance " + newBalance);
               // MessageBox.Show("loggedUser.balance " + this.loggedUser.balance);
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
                    cashTextBox.Text = newBalance.ToString();
                    this.loggedUser.balance = newBalance;
                    
                }
                qtyNumericUpDown.Value = 1;
            }
            return;
         }

        private void searchButton_Click(object sender, EventArgs e)
        {
          searchFlag = 1;
          string searchString = this.searchTextBox.Text;
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
          companyListBox.DataSource = bLogic.getSearchResults(searchString);

          searchFlag = 0;

        }




        private async void searchAutocomplete()
        {
            var source = new AutoCompleteStringCollection();

            DataTable dt = await Task.Run(() => bLogic.searchAutocomplete());
            for (int i = 0; i < dt.Rows.Count; i++)
            {
                source.Add(dt.Rows[i][0].ToString());
            }
            searchTextBox.AutoCompleteCustomSource = source;
            searchTextBox.AutoCompleteMode = AutoCompleteMode.Suggest;
            searchTextBox.AutoCompleteSource = AutoCompleteSource.CustomSource;

        }

        private void label4_Click(object sender, EventArgs e)
        {

        }

        private void qtyNumericUpDown_ValueChanged(object sender, EventArgs e)
        {

        }



    }
}
