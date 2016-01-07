namespace StockMarketSimulator
{
    partial class PurchaseForm
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
            this.cashTextBox = new System.Windows.Forms.TextBox();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.nameLabel = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.panel1 = new System.Windows.Forms.Panel();
            this.searchButton = new System.Windows.Forms.Button();
            this.searchTextBox = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.companyListBox = new System.Windows.Forms.ListBox();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.symbolRadioButton = new System.Windows.Forms.RadioButton();
            this.NamesRadioButton = new System.Windows.Forms.RadioButton();
            this.label3 = new System.Windows.Forms.Label();
            this.industriesComboBox = new System.Windows.Forms.ComboBox();
            this.detailListBox = new System.Windows.Forms.ListBox();
            this.graphButton = new System.Windows.Forms.Button();
            this.purchaseButton = new System.Windows.Forms.Button();
            this.label4 = new System.Windows.Forms.Label();
            this.qtyNumericUpDown = new System.Windows.Forms.NumericUpDown();
            this.groupBox1.SuspendLayout();
            this.panel1.SuspendLayout();
            this.groupBox2.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.qtyNumericUpDown)).BeginInit();
            this.SuspendLayout();
            // 
            // cashTextBox
            // 
            this.cashTextBox.BackColor = System.Drawing.Color.LightYellow;
            this.cashTextBox.Enabled = false;
            this.cashTextBox.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.cashTextBox.Location = new System.Drawing.Point(198, 97);
            this.cashTextBox.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.cashTextBox.Name = "cashTextBox";
            this.cashTextBox.ReadOnly = true;
            this.cashTextBox.Size = new System.Drawing.Size(163, 35);
            this.cashTextBox.TabIndex = 2;
            this.cashTextBox.TabStop = false;
            // 
            // groupBox1
            // 
            this.groupBox1.BackColor = System.Drawing.Color.LightGreen;
            this.groupBox1.Controls.Add(this.nameLabel);
            this.groupBox1.Controls.Add(this.label1);
            this.groupBox1.Controls.Add(this.cashTextBox);
            this.groupBox1.Location = new System.Drawing.Point(836, 58);
            this.groupBox1.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Padding = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.groupBox1.Size = new System.Drawing.Size(388, 166);
            this.groupBox1.TabIndex = 3;
            this.groupBox1.TabStop = false;
            // 
            // nameLabel
            // 
            this.nameLabel.AutoSize = true;
            this.nameLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.nameLabel.Location = new System.Drawing.Point(21, 43);
            this.nameLabel.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.nameLabel.Name = "nameLabel";
            this.nameLabel.Size = new System.Drawing.Size(122, 29);
            this.nameLabel.TabIndex = 4;
            this.nameLabel.Text = "Welcome";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(21, 102);
            this.label1.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(166, 29);
            this.label1.TabIndex = 3;
            this.label1.Text = "Cash on hand:";
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.Color.PaleTurquoise;
            this.panel1.Controls.Add(this.searchButton);
            this.panel1.Controls.Add(this.searchTextBox);
            this.panel1.Controls.Add(this.label2);
            this.panel1.Location = new System.Drawing.Point(20, 58);
            this.panel1.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(366, 186);
            this.panel1.TabIndex = 4;
            // 
            // searchButton
            // 
            this.searchButton.BackColor = System.Drawing.Color.SkyBlue;
            this.searchButton.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.searchButton.Location = new System.Drawing.Point(102, 118);
            this.searchButton.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.searchButton.Name = "searchButton";
            this.searchButton.Size = new System.Drawing.Size(153, 48);
            this.searchButton.TabIndex = 6;
            this.searchButton.Text = "Search";
            this.searchButton.UseVisualStyleBackColor = false;
            this.searchButton.Click += new System.EventHandler(this.searchButton_Click);
            // 
            // searchTextBox
            // 
            this.searchTextBox.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.searchTextBox.Location = new System.Drawing.Point(26, 66);
            this.searchTextBox.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.searchTextBox.Name = "searchTextBox";
            this.searchTextBox.Size = new System.Drawing.Size(313, 35);
            this.searchTextBox.TabIndex = 5;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(57, 17);
            this.label2.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(234, 29);
            this.label2.TabIndex = 4;
            this.label2.Text = "Search Companies";
            // 
            // companyListBox
            // 
            this.companyListBox.BackColor = System.Drawing.Color.LightYellow;
            this.companyListBox.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.companyListBox.FormattingEnabled = true;
            this.companyListBox.HorizontalScrollbar = true;
            this.companyListBox.ItemHeight = 29;
            this.companyListBox.Location = new System.Drawing.Point(26, 109);
            this.companyListBox.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.companyListBox.Name = "companyListBox";
            this.companyListBox.Size = new System.Drawing.Size(364, 410);
            this.companyListBox.TabIndex = 5;
            this.companyListBox.SelectedIndexChanged += new System.EventHandler(this.companyListBox_SelectedIndexChanged);
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.symbolRadioButton);
            this.groupBox2.Controls.Add(this.NamesRadioButton);
            this.groupBox2.Controls.Add(this.label3);
            this.groupBox2.Controls.Add(this.industriesComboBox);
            this.groupBox2.Controls.Add(this.companyListBox);
            this.groupBox2.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.groupBox2.Location = new System.Drawing.Point(20, 254);
            this.groupBox2.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Padding = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.groupBox2.Size = new System.Drawing.Size(429, 622);
            this.groupBox2.TabIndex = 6;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "Companies";
            // 
            // symbolRadioButton
            // 
            this.symbolRadioButton.AutoSize = true;
            this.symbolRadioButton.Location = new System.Drawing.Point(274, 571);
            this.symbolRadioButton.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.symbolRadioButton.Name = "symbolRadioButton";
            this.symbolRadioButton.Size = new System.Drawing.Size(131, 33);
            this.symbolRadioButton.TabIndex = 9;
            this.symbolRadioButton.Text = "Symbols";
            this.symbolRadioButton.UseVisualStyleBackColor = true;
            this.symbolRadioButton.CheckedChanged += new System.EventHandler(this.symbolRadioButton_CheckedChanged);
            // 
            // NamesRadioButton
            // 
            this.NamesRadioButton.AutoSize = true;
            this.NamesRadioButton.Checked = true;
            this.NamesRadioButton.Location = new System.Drawing.Point(150, 571);
            this.NamesRadioButton.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.NamesRadioButton.Name = "NamesRadioButton";
            this.NamesRadioButton.Size = new System.Drawing.Size(115, 33);
            this.NamesRadioButton.TabIndex = 8;
            this.NamesRadioButton.TabStop = true;
            this.NamesRadioButton.Text = "Names";
            this.NamesRadioButton.UseVisualStyleBackColor = true;
            this.NamesRadioButton.CheckedChanged += new System.EventHandler(this.NamesRadioButton_CheckedChanged);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.Location = new System.Drawing.Point(20, 571);
            this.label3.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(123, 29);
            this.label3.TabIndex = 7;
            this.label3.Text = "Display by";
            // 
            // industriesComboBox
            // 
            this.industriesComboBox.BackColor = System.Drawing.Color.LightYellow;
            this.industriesComboBox.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.industriesComboBox.FormattingEnabled = true;
            this.industriesComboBox.Location = new System.Drawing.Point(26, 52);
            this.industriesComboBox.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.industriesComboBox.Name = "industriesComboBox";
            this.industriesComboBox.Size = new System.Drawing.Size(364, 37);
            this.industriesComboBox.TabIndex = 6;
            this.industriesComboBox.SelectedIndexChanged += new System.EventHandler(this.industriesComboBox_SelectedIndexChanged);
            // 
            // detailListBox
            // 
            this.detailListBox.BackColor = System.Drawing.Color.LightYellow;
            this.detailListBox.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.detailListBox.FormattingEnabled = true;
            this.detailListBox.HorizontalScrollbar = true;
            this.detailListBox.ItemHeight = 29;
            this.detailListBox.Location = new System.Drawing.Point(495, 302);
            this.detailListBox.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.detailListBox.Name = "detailListBox";
            this.detailListBox.Size = new System.Drawing.Size(727, 468);
            this.detailListBox.TabIndex = 7;
            // 
            // graphButton
            // 
            this.graphButton.BackColor = System.Drawing.Color.SkyBlue;
            this.graphButton.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.graphButton.Location = new System.Drawing.Point(921, 828);
            this.graphButton.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.graphButton.Name = "graphButton";
            this.graphButton.Size = new System.Drawing.Size(303, 48);
            this.graphButton.TabIndex = 8;
            this.graphButton.Text = "Display historical graph";
            this.graphButton.UseVisualStyleBackColor = false;
            this.graphButton.Click += new System.EventHandler(this.graphButton_Click);
            // 
            // purchaseButton
            // 
            this.purchaseButton.BackColor = System.Drawing.Color.SkyBlue;
            this.purchaseButton.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.purchaseButton.Location = new System.Drawing.Point(663, 828);
            this.purchaseButton.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.purchaseButton.Name = "purchaseButton";
            this.purchaseButton.Size = new System.Drawing.Size(224, 48);
            this.purchaseButton.TabIndex = 9;
            this.purchaseButton.Text = "Purchase Stocks";
            this.purchaseButton.UseVisualStyleBackColor = false;
            this.purchaseButton.Click += new System.EventHandler(this.purchaseButton_Click);
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label4.Location = new System.Drawing.Point(490, 837);
            this.label4.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(61, 29);
            this.label4.TabIndex = 10;
            this.label4.Text = "Qty :";
            this.label4.Click += new System.EventHandler(this.label4_Click);
            // 
            // qtyNumericUpDown
            // 
            this.qtyNumericUpDown.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.qtyNumericUpDown.Location = new System.Drawing.Point(558, 834);
            this.qtyNumericUpDown.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.qtyNumericUpDown.Minimum = new decimal(new int[] {
            1,
            0,
            0,
            0});
            this.qtyNumericUpDown.Name = "qtyNumericUpDown";
            this.qtyNumericUpDown.Size = new System.Drawing.Size(72, 33);
            this.qtyNumericUpDown.TabIndex = 11;
            this.qtyNumericUpDown.Value = new decimal(new int[] {
            1,
            0,
            0,
            0});
            this.qtyNumericUpDown.ValueChanged += new System.EventHandler(this.qtyNumericUpDown_ValueChanged);
            // 
            // PurchaseForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.LightGreen;
            this.ClientSize = new System.Drawing.Size(1276, 892);
            this.Controls.Add(this.qtyNumericUpDown);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.purchaseButton);
            this.Controls.Add(this.graphButton);
            this.Controls.Add(this.detailListBox);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.panel1);
            this.Controls.Add(this.groupBox1);
            this.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.Name = "PurchaseForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Stock Market Simulator Purchase Form";
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.qtyNumericUpDown)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox cashTextBox;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.Label nameLabel;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Button searchButton;
        private System.Windows.Forms.TextBox searchTextBox;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.ListBox companyListBox;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.ComboBox industriesComboBox;
        private System.Windows.Forms.RadioButton symbolRadioButton;
        private System.Windows.Forms.RadioButton NamesRadioButton;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.ListBox detailListBox;
        private System.Windows.Forms.Button graphButton;
        private System.Windows.Forms.Button purchaseButton;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.NumericUpDown qtyNumericUpDown;
    }
}