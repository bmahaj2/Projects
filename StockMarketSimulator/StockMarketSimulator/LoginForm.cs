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
    public partial class LoginForm : Form
    {
        private BusinessTier.User loggedUser;
        private BusinessTier.BusinessLogic bLogic; 
        public LoginForm()
        {
            InitializeComponent();
            loginFormLoadingCircle.Visible = false;
            loginFormLoadingCircle.Active = true;
            loginFormLoadingCircle.OuterCircleRadius = 30;
            loginFormLoadingCircle.InnerCircleRadius = 14;
            loginFormLoadingCircle.SpokeThickness = 3;
            loginFormLoadingCircle.NumberSpoke = 14;
            bLogic = new BusinessLogic("stockMarketDB.mdf");
        }

        // method select and highlight on tab to next textbox
        private void TextBox_GotFocus(object sender, EventArgs e)
        {
            (sender as TextBox).SelectAll();
        }


        // user can press enter to move to the next text box
        // if enter was hit from password Textbox, invoke signIn event
        // user may use up or down keys to navigate controls
        private void TextBox_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Enter || e.KeyCode == Keys.Return
                ||e.KeyCode==Keys.Down||e.KeyCode==Keys.Up)
            {
                // at password text box user can press enter to login
                if (sender.Equals(this.PasswordTextBox) && e.KeyCode != Keys.Down && e.KeyCode != Keys.Up)
                {
                    e.Handled = true;
                    e.SuppressKeyPress = true;
                    signInButton_Click(sender, e);

                }
                else if (e.KeyCode == Keys.Up)
                {
                    e.Handled = true;
                    e.SuppressKeyPress = true;
                    this.SelectNextControl((Control)sender, false, true, true, true);
                }
                else
                {
                    e.Handled = true;
                    e.SuppressKeyPress = true;
                    this.SelectNextControl((Control)sender, true, true, true, true);
                }
            }
        }

        // this is the method block executes when main form is closed
        private void mainForm_FormClosed(object sender, FormClosedEventArgs e)
        {
            // this part will contain anything require before we close the application

            // close the application
            Application.Exit();
        }

        // this code is for test purpose
        // this will be deleted once the login sql part is ready
        async Task PutTaskDelay()
        {
            await Task.Delay(3000);
        }

        private async void signInButton_Click(object sender, EventArgs e)
        {
            string userName = this.userNameTextBox.Text.Trim();
            string userPassword = this.PasswordTextBox.Text.Trim();
            if (userName == string.Empty)
            {
                MessageBox.Show("User Name field cannot be empty.\n\nPlease enter user name.",
                                "Empty User Name text box",
                                MessageBoxButtons.OK, MessageBoxIcon.Warning);
                this.userNameTextBox.SelectAll();
                this.userNameTextBox.Focus();
                return;
            }
            else if (userPassword == string.Empty)
            {
                MessageBox.Show("Password field cannot be empty.\n\nPlease enter password.",
                                "Empty Password text box",
                                MessageBoxButtons.OK, MessageBoxIcon.Warning);
                this.PasswordTextBox.SelectAll();
                this.PasswordTextBox.Focus();
                return;
            }

            loggedUser = new BusinessTier.User(userName, userPassword);

            // check if password matches

            loginFormLoadingCircle.Visible = true;
            //await PutTaskDelay();
            bool result;
            try
            {
                result = await Task.Run(() => bLogic.validateUser(loggedUser));
            }
            catch(Exception ex)
            {
                MessageBox.Show(ex.ToString());
                return;
            }
            loginFormLoadingCircle.Visible = false;
            if (result == true)
            {
                MainForm mainForm = new MainForm(loggedUser, bLogic);

                // creating event handler to catch the main form closed event
                // this will fire when mainForm closed
                mainForm.FormClosed += new FormClosedEventHandler(mainForm_FormClosed);
                //showing the main form
                mainForm.Show();
                //hiding the current form
                this.Hide();
            }
            else
            {
                MessageBox.Show("User Name or Password did not match our records.\nPlease try again.",
                                "Invalid User",
                                MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        // click action for more information
        private void moreInformationButton_Click(object sender, EventArgs e)
        {
            // fire up another window with lots of information
           
            MoreInfo moreinfoForm = new MoreInfo();
            moreinfoForm.FormClosed += new FormClosedEventHandler(event_FormClosed);
            moreinfoForm.Show();
            this.Hide();
          
        }

        private void event_FormClosed(object sender, FormClosedEventArgs e)
        {
            this.Show();
        }

        // click action for register button
        private void registerButton_Click(object sender, EventArgs e)
        {
            // fire up dialog window to get require information
            NewUserForm newUserForm = new NewUserForm();
            newUserForm.FormClosed += new FormClosedEventHandler(event_FormClosed);
            newUserForm.Show();
            this.Hide();
        }

        private async void recoverPasswordButton_Click(object sender, EventArgs e)
        {
            string userName = this.userNameTextBox.Text.Trim();
            if (userName == string.Empty)
            {
                MessageBox.Show("Please enter your user name to recover your password.",
                                "Empty User Name text box",
                                MessageBoxButtons.OK, MessageBoxIcon.Warning);
                this.userNameTextBox.SelectAll();
                this.userNameTextBox.Focus();
                return;
            }
            loginFormLoadingCircle.Visible = true;
            string question = await Task.Run(() => bLogic.getSecurityQuestion(userName));
            loginFormLoadingCircle.Visible = false;
            if (question == String.Empty)
            {
                MessageBox.Show("Invalid UserName, Please enter valid user name",
                                "Invalid User Name",
                                MessageBoxButtons.OK, MessageBoxIcon.Warning);
                this.userNameTextBox.SelectAll();
                this.userNameTextBox.Focus();
                return;
            }
            RecoverForm recoverForm = new RecoverForm(question, userName,bLogic);
            recoverForm.FormClosed += new FormClosedEventHandler(event_FormClosed);
            recoverForm.Show();
            this.Hide();
        }
    }
}
