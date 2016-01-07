namespace StockMarketSimulator
{
    partial class watchListForm
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
            this.components = new System.ComponentModel.Container();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle3 = new System.Windows.Forms.DataGridViewCellStyle();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle4 = new System.Windows.Forms.DataGridViewCellStyle();
            this.NamesRadioButton = new System.Windows.Forms.RadioButton();
            this.companyListBox = new System.Windows.Forms.ListBox();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.addToWatchlist = new System.Windows.Forms.Button();
            this.symbolRadioButton = new System.Windows.Forms.RadioButton();
            this.industriesComboBox = new System.Windows.Forms.ComboBox();
            this.watchlistDataGridView = new System.Windows.Forms.DataGridView();
            this.zg1 = new ZedGraph.ZedGraphControl();
            this.removeFromWatchlist = new System.Windows.Forms.Button();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.panel1 = new System.Windows.Forms.Panel();
            this.searchButton = new System.Windows.Forms.Button();
            this.searchTextBox = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.qtyNumericUpDown = new System.Windows.Forms.NumericUpDown();
            this.label4 = new System.Windows.Forms.Label();
            this.purchaseButton = new System.Windows.Forms.Button();
            this.groupBox2.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.watchlistDataGridView)).BeginInit();
            this.groupBox1.SuspendLayout();
            this.panel1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.qtyNumericUpDown)).BeginInit();
            this.SuspendLayout();
            // 
            // NamesRadioButton
            // 
            this.NamesRadioButton.AutoSize = true;
            this.NamesRadioButton.Checked = true;
            this.NamesRadioButton.Location = new System.Drawing.Point(39, 645);
            this.NamesRadioButton.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.NamesRadioButton.Name = "NamesRadioButton";
            this.NamesRadioButton.Size = new System.Drawing.Size(115, 33);
            this.NamesRadioButton.TabIndex = 8;
            this.NamesRadioButton.TabStop = true;
            this.NamesRadioButton.Text = "Names";
            this.NamesRadioButton.UseVisualStyleBackColor = true;
            this.NamesRadioButton.CheckedChanged += new System.EventHandler(this.NamesRadioButton_CheckedChanged);
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
            this.companyListBox.Size = new System.Drawing.Size(320, 526);
            this.companyListBox.TabIndex = 5;
            this.companyListBox.SelectedIndexChanged += new System.EventHandler(this.companyListBox_SelectedIndexChanged);
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.addToWatchlist);
            this.groupBox2.Controls.Add(this.symbolRadioButton);
            this.groupBox2.Controls.Add(this.NamesRadioButton);
            this.groupBox2.Controls.Add(this.industriesComboBox);
            this.groupBox2.Controls.Add(this.companyListBox);
            this.groupBox2.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.groupBox2.Location = new System.Drawing.Point(26, 236);
            this.groupBox2.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Padding = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.groupBox2.Size = new System.Drawing.Size(382, 740);
            this.groupBox2.TabIndex = 7;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "Companies";
            this.groupBox2.Enter += new System.EventHandler(this.groupBox2_Enter);
            // 
            // addToWatchlist
            // 
            this.addToWatchlist.BackColor = System.Drawing.Color.SkyBlue;
            this.addToWatchlist.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.addToWatchlist.Location = new System.Drawing.Point(75, 688);
            this.addToWatchlist.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.addToWatchlist.Name = "addToWatchlist";
            this.addToWatchlist.Size = new System.Drawing.Size(224, 48);
            this.addToWatchlist.TabIndex = 10;
            this.addToWatchlist.Text = "Add to Watchlist";
            this.addToWatchlist.UseVisualStyleBackColor = false;
            this.addToWatchlist.Click += new System.EventHandler(this.addToWatchlist_Click);
            // 
            // symbolRadioButton
            // 
            this.symbolRadioButton.AutoSize = true;
            this.symbolRadioButton.Location = new System.Drawing.Point(194, 645);
            this.symbolRadioButton.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.symbolRadioButton.Name = "symbolRadioButton";
            this.symbolRadioButton.Size = new System.Drawing.Size(131, 33);
            this.symbolRadioButton.TabIndex = 9;
            this.symbolRadioButton.Text = "Symbols";
            this.symbolRadioButton.UseVisualStyleBackColor = true;
            this.symbolRadioButton.CheckedChanged += new System.EventHandler(this.symbolRadioButton_CheckedChanged);
            // 
            // industriesComboBox
            // 
            this.industriesComboBox.BackColor = System.Drawing.Color.LightYellow;
            this.industriesComboBox.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.industriesComboBox.FormattingEnabled = true;
            this.industriesComboBox.Location = new System.Drawing.Point(26, 52);
            this.industriesComboBox.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.industriesComboBox.Name = "industriesComboBox";
            this.industriesComboBox.Size = new System.Drawing.Size(320, 37);
            this.industriesComboBox.TabIndex = 6;
            this.industriesComboBox.SelectedIndexChanged += new System.EventHandler(this.industriesComboBox_SelectedIndexChanged);
            // 
            // watchlistDataGridView
            // 
            this.watchlistDataGridView.AllowUserToAddRows = false;
            this.watchlistDataGridView.AllowUserToDeleteRows = false;
            dataGridViewCellStyle3.BackColor = System.Drawing.Color.Beige;
            this.watchlistDataGridView.AlternatingRowsDefaultCellStyle = dataGridViewCellStyle3;
            this.watchlistDataGridView.BackgroundColor = System.Drawing.Color.LightYellow;
            this.watchlistDataGridView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.watchlistDataGridView.Location = new System.Drawing.Point(30, 35);
            this.watchlistDataGridView.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.watchlistDataGridView.MultiSelect = false;
            this.watchlistDataGridView.Name = "watchlistDataGridView";
            this.watchlistDataGridView.ReadOnly = true;
            this.watchlistDataGridView.RowHeadersVisible = false;
            dataGridViewCellStyle4.BackColor = System.Drawing.Color.Bisque;
            dataGridViewCellStyle4.SelectionBackColor = System.Drawing.SystemColors.MenuHighlight;
            this.watchlistDataGridView.RowsDefaultCellStyle = dataGridViewCellStyle4;
            this.watchlistDataGridView.RowTemplate.Height = 28;
            this.watchlistDataGridView.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.watchlistDataGridView.Size = new System.Drawing.Size(717, 246);
            this.watchlistDataGridView.TabIndex = 3;
            this.watchlistDataGridView.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.watchlistDataGridView_CellContentClick);
            // 
            // zg1
            // 
            this.zg1.Location = new System.Drawing.Point(450, 414);
            this.zg1.Margin = new System.Windows.Forms.Padding(6, 8, 6, 8);
            this.zg1.Name = "zg1";
            this.zg1.ScrollGrace = 0D;
            this.zg1.ScrollMaxX = 0D;
            this.zg1.ScrollMaxY = 0D;
            this.zg1.ScrollMaxY2 = 0D;
            this.zg1.ScrollMinX = 0D;
            this.zg1.ScrollMinY = 0D;
            this.zg1.ScrollMinY2 = 0D;
            this.zg1.Size = new System.Drawing.Size(778, 568);
            this.zg1.TabIndex = 9;
            // 
            // removeFromWatchlist
            // 
            this.removeFromWatchlist.BackColor = System.Drawing.Color.SkyBlue;
            this.removeFromWatchlist.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.removeFromWatchlist.Location = new System.Drawing.Point(443, 311);
            this.removeFromWatchlist.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.removeFromWatchlist.Name = "removeFromWatchlist";
            this.removeFromWatchlist.Size = new System.Drawing.Size(304, 48);
            this.removeFromWatchlist.TabIndex = 11;
            this.removeFromWatchlist.Text = "Remove from watchlist";
            this.removeFromWatchlist.UseVisualStyleBackColor = false;
            this.removeFromWatchlist.Click += new System.EventHandler(this.removeFromWatchlist_Click);
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.qtyNumericUpDown);
            this.groupBox1.Controls.Add(this.removeFromWatchlist);
            this.groupBox1.Controls.Add(this.label4);
            this.groupBox1.Controls.Add(this.watchlistDataGridView);
            this.groupBox1.Controls.Add(this.purchaseButton);
            this.groupBox1.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.groupBox1.Location = new System.Drawing.Point(450, 17);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(778, 389);
            this.groupBox1.TabIndex = 7;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Watchlist";
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.Color.PaleTurquoise;
            this.panel1.Controls.Add(this.searchButton);
            this.panel1.Controls.Add(this.searchTextBox);
            this.panel1.Controls.Add(this.label2);
            this.panel1.Location = new System.Drawing.Point(26, 30);
            this.panel1.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(382, 168);
            this.panel1.TabIndex = 10;
            // 
            // searchButton
            // 
            this.searchButton.BackColor = System.Drawing.Color.SkyBlue;
            this.searchButton.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.searchButton.Location = new System.Drawing.Point(102, 111);
            this.searchButton.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.searchButton.Name = "searchButton";
            this.searchButton.Size = new System.Drawing.Size(153, 48);
            this.searchButton.TabIndex = 6;
            this.searchButton.Text = "Search";
            this.searchButton.UseVisualStyleBackColor = false;
            this.searchButton.Click += new System.EventHandler(this.searchButton_Click_1);
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
            this.label2.Location = new System.Drawing.Point(65, 32);
            this.label2.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(234, 29);
            this.label2.TabIndex = 4;
            this.label2.Text = "Search Companies";
            // 
            // qtyNumericUpDown
            // 
            this.qtyNumericUpDown.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.qtyNumericUpDown.Location = new System.Drawing.Point(94, 319);
            this.qtyNumericUpDown.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.qtyNumericUpDown.Minimum = new decimal(new int[] {
            1,
            0,
            0,
            0});
            this.qtyNumericUpDown.Name = "qtyNumericUpDown";
            this.qtyNumericUpDown.Size = new System.Drawing.Size(72, 33);
            this.qtyNumericUpDown.TabIndex = 14;
            this.qtyNumericUpDown.Value = new decimal(new int[] {
            1,
            0,
            0,
            0});
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label4.Location = new System.Drawing.Point(25, 319);
            this.label4.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(61, 29);
            this.label4.TabIndex = 13;
            this.label4.Text = "Qty :";
            // 
            // purchaseButton
            // 
            this.purchaseButton.BackColor = System.Drawing.Color.SkyBlue;
            this.purchaseButton.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.purchaseButton.Location = new System.Drawing.Point(194, 311);
            this.purchaseButton.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.purchaseButton.Name = "purchaseButton";
            this.purchaseButton.Size = new System.Drawing.Size(224, 48);
            this.purchaseButton.TabIndex = 12;
            this.purchaseButton.Text = "Purchase Stocks";
            this.purchaseButton.UseVisualStyleBackColor = false;
            this.purchaseButton.Click += new System.EventHandler(this.purchaseButton_Click);
            // 
            // watchListForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.LightGreen;
            this.ClientSize = new System.Drawing.Size(1258, 995);
            this.Controls.Add(this.panel1);
            this.Controls.Add(this.zg1);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.groupBox1);
            this.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.Name = "watchListForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Watch List Form";
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.watchlistDataGridView)).EndInit();
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.qtyNumericUpDown)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.RadioButton NamesRadioButton;
        private System.Windows.Forms.ListBox companyListBox;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.RadioButton symbolRadioButton;
        private System.Windows.Forms.ComboBox industriesComboBox;
        private System.Windows.Forms.Button addToWatchlist;
        private System.Windows.Forms.DataGridView watchlistDataGridView;
        private ZedGraph.ZedGraphControl zg1;
        private System.Windows.Forms.Button removeFromWatchlist;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Button searchButton;
        private System.Windows.Forms.TextBox searchTextBox;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.NumericUpDown qtyNumericUpDown;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Button purchaseButton;
    }
}