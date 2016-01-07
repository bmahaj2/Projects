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
    public partial class RecoverForm : Form
    {
        private String question;
        private String userName;
        private BusinessTier.BusinessLogic bLogic;
        public RecoverForm(String question, String usr, BusinessTier.BusinessLogic b)
        {
            InitializeComponent();
            this.question = question;
            this.userName = usr;
            this.bLogic = b;
            this.questionLabel.Text += " " + question.ToString();
        }
        private void changepass_FormClosed(object sender, FormClosedEventArgs e)
        {
            // this part will contain anything require before we close the application

            // close the application
            Application.Exit();
        }

        private void signInButton_Click(object sender, EventArgs e)
        {
            if (this.answerTextBox.Text.Trim() == String.Empty)
            {
                MessageBox.Show("Please enter your answer before you can recover your password.",
                                "Empty Answer text box",
                                MessageBoxButtons.OK, MessageBoxIcon.Warning);
                this.answerTextBox.SelectAll();
                this.answerTextBox.Focus();
                return;
            }
            String ans = this.answerTextBox.Text.Trim();
            String pass = bLogic.getPasswordByQuestion(userName, ans);
            if (pass == String.Empty)
            {
                MessageBox.Show("Please enter valid answer. Your answer did not match the data base.",
                                "Invalid Answer",
                                MessageBoxButtons.OK, MessageBoxIcon.Warning);
                this.answerTextBox.SelectAll();
                this.answerTextBox.Focus();
                return;

            }
            else
            {
                //this.PassLabel.Text = " " + pass;
                ChangePassword changepass = new ChangePassword(userName,bLogic);
                changepass.FormClosed += new FormClosedEventHandler(changepass_FormClosed);
                changepass.Show();
                this.Hide();
            }
        }

        private void RecoverForm_FormClosed(object sender, FormClosedEventArgs e)
        {

        }
    }
}
