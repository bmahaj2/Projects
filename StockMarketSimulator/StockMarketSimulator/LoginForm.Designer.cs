namespace StockMarketSimulator
{
    partial class LoginForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.signInButton = new System.Windows.Forms.Button();
            this.registerButton = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.userNameTextBox = new System.Windows.Forms.TextBox();
            this.PasswordTextBox = new System.Windows.Forms.TextBox();
            this.moreInformationButton = new System.Windows.Forms.Button();
            this.loginFormLoadingCircle = new MRG.Controls.UI.LoadingCircle();
            this.recoverPasswordButton = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // signInButton
            // 
            this.signInButton.BackColor = System.Drawing.Color.SkyBlue;
            this.signInButton.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.signInButton.Location = new System.Drawing.Point(270, 169);
            this.signInButton.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.signInButton.Name = "signInButton";
            this.signInButton.Size = new System.Drawing.Size(102, 31);
            this.signInButton.TabIndex = 2;
            this.signInButton.Text = "Sign In";
            this.signInButton.UseVisualStyleBackColor = false;
            this.signInButton.Click += new System.EventHandler(this.signInButton_Click);
            // 
            // registerButton
            // 
            this.registerButton.BackColor = System.Drawing.Color.SkyBlue;
            this.registerButton.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.registerButton.Location = new System.Drawing.Point(62, 169);
            this.registerButton.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.registerButton.Name = "registerButton";
            this.registerButton.Size = new System.Drawing.Size(102, 31);
            this.registerButton.TabIndex = 4;
            this.registerButton.Text = "Register";
            this.registerButton.UseVisualStyleBackColor = false;
            this.registerButton.Click += new System.EventHandler(this.registerButton_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(30, 32);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(93, 20);
            this.label1.TabIndex = 2;
            this.label1.Text = "User Name:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(30, 110);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(82, 20);
            this.label2.TabIndex = 3;
            this.label2.Text = "Password:";
            // 
            // userNameTextBox
            // 
            this.userNameTextBox.BackColor = System.Drawing.Color.LightYellow;
            this.userNameTextBox.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.userNameTextBox.Location = new System.Drawing.Point(129, 34);
            this.userNameTextBox.Name = "userNameTextBox";
            this.userNameTextBox.Size = new System.Drawing.Size(269, 26);
            this.userNameTextBox.TabIndex = 0;
            this.userNameTextBox.Enter += new System.EventHandler(this.TextBox_GotFocus);
            this.userNameTextBox.KeyDown += new System.Windows.Forms.KeyEventHandler(this.TextBox_KeyDown);
            // 
            // PasswordTextBox
            // 
            this.PasswordTextBox.BackColor = System.Drawing.Color.LightYellow;
            this.PasswordTextBox.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.PasswordTextBox.Location = new System.Drawing.Point(129, 110);
            this.PasswordTextBox.Name = "PasswordTextBox";
            this.PasswordTextBox.PasswordChar = '•';
            this.PasswordTextBox.Size = new System.Drawing.Size(269, 26);
            this.PasswordTextBox.TabIndex = 1;
            this.PasswordTextBox.Enter += new System.EventHandler(this.TextBox_GotFocus);
            this.PasswordTextBox.KeyDown += new System.Windows.Forms.KeyEventHandler(this.TextBox_KeyDown);
            // 
            // moreInformationButton
            // 
            this.moreInformationButton.BackColor = System.Drawing.Color.SkyBlue;
            this.moreInformationButton.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.moreInformationButton.Location = new System.Drawing.Point(241, 238);
            this.moreInformationButton.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.moreInformationButton.Name = "moreInformationButton";
            this.moreInformationButton.Size = new System.Drawing.Size(157, 32);
            this.moreInformationButton.TabIndex = 3;
            this.moreInformationButton.Text = "More Information";
            this.moreInformationButton.UseVisualStyleBackColor = false;
            this.moreInformationButton.Click += new System.EventHandler(this.moreInformationButton_Click);
            // 
            // loginFormLoadingCircle
            // 
            this.loginFormLoadingCircle.Active = false;
            this.loginFormLoadingCircle.Color = System.Drawing.Color.DodgerBlue;
            this.loginFormLoadingCircle.InnerCircleRadius = 5;
            this.loginFormLoadingCircle.Location = new System.Drawing.Point(174, 151);
            this.loginFormLoadingCircle.Name = "loginFormLoadingCircle";
            this.loginFormLoadingCircle.NumberSpoke = 12;
            this.loginFormLoadingCircle.OuterCircleRadius = 11;
            this.loginFormLoadingCircle.RotationSpeed = 100;
            this.loginFormLoadingCircle.Size = new System.Drawing.Size(85, 70);
            this.loginFormLoadingCircle.SpokeThickness = 2;
            this.loginFormLoadingCircle.StylePreset = MRG.Controls.UI.LoadingCircle.StylePresets.MacOSX;
            this.loginFormLoadingCircle.TabIndex = 5;
            this.loginFormLoadingCircle.Text = "loginFormLoadingCircle";
            // 
            // recoverPasswordButton
            // 
            this.recoverPasswordButton.BackColor = System.Drawing.Color.SkyBlue;
            this.recoverPasswordButton.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.recoverPasswordButton.Location = new System.Drawing.Point(34, 238);
            this.recoverPasswordButton.Margin = new System.Windows.Forms.Padding(2);
            this.recoverPasswordButton.Name = "recoverPasswordButton";
            this.recoverPasswordButton.Size = new System.Drawing.Size(157, 32);
            this.recoverPasswordButton.TabIndex = 6;
            this.recoverPasswordButton.Text = "Recover Password";
            this.recoverPasswordButton.UseVisualStyleBackColor = false;
            this.recoverPasswordButton.Click += new System.EventHandler(this.recoverPasswordButton_Click);
            // 
            // LoginForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.LightGreen;
            this.ClientSize = new System.Drawing.Size(439, 294);
            this.Controls.Add(this.recoverPasswordButton);
            this.Controls.Add(this.loginFormLoadingCircle);
            this.Controls.Add(this.moreInformationButton);
            this.Controls.Add(this.PasswordTextBox);
            this.Controls.Add(this.userNameTextBox);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.registerButton);
            this.Controls.Add(this.signInButton);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.MaximizeBox = false;
            this.Name = "LoginForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Stock Market Simulator Login Form";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button signInButton;
        private System.Windows.Forms.Button registerButton;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox userNameTextBox;
        private System.Windows.Forms.TextBox PasswordTextBox;
        private System.Windows.Forms.Button moreInformationButton;
        private MRG.Controls.UI.LoadingCircle loginFormLoadingCircle;
        private System.Windows.Forms.Button recoverPasswordButton;
    }
}

