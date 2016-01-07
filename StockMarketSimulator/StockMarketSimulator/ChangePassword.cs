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
    public partial class ChangePassword : Form
    {
        private string userName;
        private BusinessTier.BusinessLogic bLogic;
        public ChangePassword(string usr, BusinessTier.BusinessLogic b)
        {
            InitializeComponent();
            this.userName = usr;
            this.bLogic = b;
        }
         private void loginform_FormClosed(object sender, FormClosedEventArgs e)
        {
            // this part will contain anything require before we close the application

            // close the application
            Application.Exit();
        }
        private async  void btnChangePassword_Click(object sender, EventArgs e)
        {
            if (this.txtNewPassword.Text.Trim() == String.Empty)
            {
                MessageBox.Show("Please enter your new password.",
                                "Empty Password text box",
                                MessageBoxButtons.OK, MessageBoxIcon.Warning);
                this.txtNewPassword.SelectAll();
                this.txtNewPassword.Focus();
                return;
            }
            if (this.txtConfirmPassword.Text.Trim() == String.Empty)
            {
                MessageBox.Show("Please enter  password to confirm new password.",
                                "Empty Confirm Password text box",
                                MessageBoxButtons.OK, MessageBoxIcon.Warning);
                this.txtConfirmPassword.SelectAll();
                this.txtConfirmPassword.Focus();
                return;
            }
            if(txtNewPassword.Text == txtConfirmPassword.Text)
            {
                bool result;
                DialogResult dr = new DialogResult();

                string newpass= txtNewPassword.Text;
               result = await Task.Run(() => bLogic.updatePassword(userName,newpass));
                if(result == true)
                {
                    dr= MessageBox.Show("Your Password has been Reset. Click OK to go to Login Page.",
                                "Password Reset",
                                MessageBoxButtons.OK, MessageBoxIcon.Warning);
                    this.txtConfirmPassword.SelectAll();
                    if (dr== DialogResult.OK)
                    {
                        LoginForm loginform = new LoginForm();
                        loginform.FormClosed += new FormClosedEventHandler(loginform_FormClosed);
                        loginform.Show();
                        this.Hide();
                    }
                  }
            }
            else
            {
                MessageBox.Show("Please enter same password to confirm new password.",
                                "Empty Confirm Password text box",
                                MessageBoxButtons.OK, MessageBoxIcon.Warning);
                this.txtConfirmPassword.SelectAll();
                this.txtConfirmPassword.Focus();
                return;

            }
        }

        private void ChangePassword_Load(object sender, EventArgs e)
        {

        }

        private void answerLabel_Click(object sender, EventArgs e)
        {

        }


        }
    
}
