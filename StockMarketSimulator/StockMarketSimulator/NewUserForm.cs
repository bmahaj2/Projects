using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace StockMarketSimulator
{
    public partial class NewUserForm : Form
    {
        private BusinessTier.BusinessLogic bLogic; 
       
        
        public NewUserForm()
        {
            InitializeComponent();
            loadingCircle.Visible = false;
            loadingCircle.Active = true;
            loadingCircle.OuterCircleRadius = 30;
            loadingCircle.InnerCircleRadius = 14;
            loadingCircle.SpokeThickness = 3;
            loadingCircle.NumberSpoke = 14;
            label15.ForeColor = System.Drawing.Color.Red;
            label16.ForeColor = System.Drawing.Color.Red;
            label17.ForeColor = System.Drawing.Color.Red;
            label18.ForeColor = System.Drawing.Color.Red;
            label19.ForeColor = System.Drawing.Color.Red;
            label20.ForeColor = System.Drawing.Color.Red;
            label21.ForeColor = System.Drawing.Color.Red;
            label22.ForeColor = System.Drawing.Color.Red;

            bLogic = new BusinessTier.BusinessLogic("stockMarketDB.mdf");

            SecurityQuestionComboBox.DataSource = null;
            SecurityQuestionComboBox.ValueMember = "ID";
            SecurityQuestionComboBox.DisplayMember = "Question";
            SecurityQuestionComboBox.DataSource = bLogic.populateSecurityQuestionDropDown();


            //try
            //{
            //    SecurityQuestionComboBox.DataSource = bLogic.populateSecurityQuestionDropDown();
            //}
            //catch(Exception ex)
            //{
            //    MessageBox.Show(ex.ToString());
            //}



        
        }

        private async void submitButton_Click(object sender, EventArgs e)
        {

            if (txtUserName.Text.Trim().ToString() == string.Empty)
            {
                label6.Text = "*Enter Username";
                this.txtUserName.Focus();
                return;
            }

            if (txtPassword.Text.Trim().ToString() == string.Empty)
            {

                label9.Text = "*Enter Password";
                this.txtPassword.Focus();
                return;
            }

            if (txtFirstName.Text.Trim().ToString() == string.Empty)
            {
                label8.Text = "*Enter FirstName";
                this.txtFirstName.Focus();
                return;
            }

            if (txtLastName.Text.Trim().ToString() == string.Empty)
            {
                label7.Text = "*Enter LastName";
                this.txtLastName.Focus();
                return;
            }

            if (txtEmail.Text.Trim().ToString() == string.Empty)
            {

                label10.Text = "*Enter Email id";
                this.txtEmail.Focus();
                return;
            }

            if (txtAnswer.Text.Trim().ToString() == string.Empty)
            {

                label14.Text = "*Enter Security Answer";
                this.txtEmail.Focus();
                return;
            }



                string userName = txtUserName.Text.Trim().ToString();
                string userPassword = txtPassword.Text.Trim().ToString();
                string firstName = txtFirstName.Text.Trim().ToString();
                string lastName = txtLastName.Text.Trim().ToString();
                string email = txtEmail.Text.Trim().ToString();

                //MessageBox.Show(SecurityQuestionComboBox.SelectedValue.ToString());

                int questionid = System.Convert.ToInt32(SecurityQuestionComboBox.SelectedValue.ToString());
                String answer = txtAnswer.Text.Trim().ToString();

                bool result;
                loadingCircle.Visible = true;
                result = await Task.Run(() => bLogic.createUser(userName, userPassword, firstName, lastName, email, questionid, answer));
                loadingCircle.Visible = false;
                if (result == true)
                {
                    DialogResult = MessageBox.Show("New username has been created for you.\nPleae login with your new username and password.",
                        "New User Creation", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    this.Close();
                }
                else
                {
                    MessageBox.Show("This username already exists.\n Please try differnt username.\n", "Existing User", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    this.txtUserName.Focus();
                }
                return;
            }
        

        
      /*   private void SecurityQuestionComboBox_SelectedIndexChanged(object sender, EventArgs e)
        {
            Object selectedValue = SecurityQuestionComboBox.SelectedValue;
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
        */

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            txtUserName.Text = "";
            txtPassword.Text = "";
            txtFirstName.Text = "";
            txtLastName.Text = "";
            txtEmail.Text = "";
            txtAnswer.Text = "";
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void label11_Click(object sender, EventArgs e)
        {

        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void label12_Click(object sender, EventArgs e)
        {

        }

        private void NewUserForm_Load(object sender, EventArgs e)
        {

        }

        private void loadingCircle_Click(object sender, EventArgs e)
        {
        
        }

        private void SecurityQuestionComboBox_SelectedIndexChanged(object sender, EventArgs e)
        {
            Object selectedValue = SecurityQuestionComboBox.SelectedValue;
            //MessageBox.Show("User Name field cannot be empty.\n\nPlease enter user name.",
            //                   "Empty User Name text box",
            //                   MessageBoxButtons.OK, MessageBoxIcon.Warning);

        
        }

        private void txtAnswer_TextChanged(object sender, EventArgs e)
        {

        }

        private void label13_Click(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void label15_Click(object sender, EventArgs e)
        {

        }

    }
}
