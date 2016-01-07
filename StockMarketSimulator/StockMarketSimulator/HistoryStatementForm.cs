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
    public partial class HistoryStatementForm : Form
    {
        private BusinessTier.User loggedUser;
        private BusinessTier.BusinessLogic bLogic;
        private DataTable dt = null;
        public HistoryStatementForm(BusinessTier.User usr, BusinessTier.BusinessLogic b)
        {
            InitializeComponent();
            this.loggedUser = usr;
            this.bLogic = b;
            displayHistoryStatementGrid();
        }
        
        private void displayHistoryStatementGrid()
        {
            dt = bLogic.getUserPurchaseHistory(loggedUser.userName);
            if (dt.Rows.Count > 0)
            {
                this.historyDataGridView.DataSource = dt;
                //this.historyDataGridView.Columns["Transaction Price"].DefaultCellStyle.Format = "c";
                //this.historyDataGridView.Columns["Transaction Type"].DefaultCellStyle.Format = "c";
                //this.historyDataGridView.Columns["Num. of Stocks"].DefaultCellStyle.Format = "c";
                //this.historyDataGridView.Columns["Transaction Date"].DefaultCellStyle.Format = "c";
                this.historyDataGridView.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;

            } // end of  if (dt.Rows.Count > 0)
        }

    }
}
