namespace StockMarketSimulator
{
    partial class MainForm
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
      System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle1 = new System.Windows.Forms.DataGridViewCellStyle();
      System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle2 = new System.Windows.Forms.DataGridViewCellStyle();
      this.mainFormMenuStrip = new System.Windows.Forms.MenuStrip();
      this.fileToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
      this.placeHolderToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
      this.placeHolderToolStripMenuItem1 = new System.Windows.Forms.ToolStripMenuItem();
      this.exitToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
      this.transactionToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
      this.purchaseToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
      this.sellToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
      this.historyToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
      this.zedPieControl = new ZedGraph.ZedGraphControl();
      this.zg1 = new ZedGraph.ZedGraphControl();
      this.stockDataGridView = new System.Windows.Forms.DataGridView();
      this.nameLabel = new System.Windows.Forms.Label();
      this.label1 = new System.Windows.Forms.Label();
      this.cashTextBox = new System.Windows.Forms.TextBox();
      this.qtyNumericUpDown = new System.Windows.Forms.NumericUpDown();
      this.label4 = new System.Windows.Forms.Label();
      this.sellButton = new System.Windows.Forms.Button();
      this.label2 = new System.Windows.Forms.Label();
      this.investTextBox = new System.Windows.Forms.TextBox();
      this.label3 = new System.Windows.Forms.Label();
      this.returnTextBox = new System.Windows.Forms.TextBox();
      this.mainFormLoadingCircle = new MRG.Controls.UI.LoadingCircle();
      this.profitLabel = new System.Windows.Forms.Label();
      this.profitTextBox = new System.Windows.Forms.TextBox();
      this.mainFormMenuStrip.SuspendLayout();
      ((System.ComponentModel.ISupportInitialize)(this.stockDataGridView)).BeginInit();
      ((System.ComponentModel.ISupportInitialize)(this.qtyNumericUpDown)).BeginInit();
      this.SuspendLayout();
      // 
      // mainFormMenuStrip
      // 
      this.mainFormMenuStrip.BackColor = System.Drawing.Color.LightSkyBlue;
      this.mainFormMenuStrip.ImageScalingSize = new System.Drawing.Size(24, 24);
      this.mainFormMenuStrip.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.fileToolStripMenuItem,
            this.transactionToolStripMenuItem});
      this.mainFormMenuStrip.Location = new System.Drawing.Point(0, 0);
      this.mainFormMenuStrip.Name = "mainFormMenuStrip";
      this.mainFormMenuStrip.Padding = new System.Windows.Forms.Padding(9, 3, 0, 3);
      this.mainFormMenuStrip.Size = new System.Drawing.Size(1276, 35);
      this.mainFormMenuStrip.TabIndex = 0;
      this.mainFormMenuStrip.Text = "Main Menu";
      // 
      // fileToolStripMenuItem
      // 
      this.fileToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.placeHolderToolStripMenuItem,
            this.placeHolderToolStripMenuItem1,
            this.exitToolStripMenuItem});
      this.fileToolStripMenuItem.Name = "fileToolStripMenuItem";
      this.fileToolStripMenuItem.Size = new System.Drawing.Size(50, 29);
      this.fileToolStripMenuItem.Text = "&File";
      // 
      // placeHolderToolStripMenuItem
      // 
      this.placeHolderToolStripMenuItem.Name = "placeHolderToolStripMenuItem";
      this.placeHolderToolStripMenuItem.Size = new System.Drawing.Size(179, 30);
      this.placeHolderToolStripMenuItem.Text = "placeHolder";
      // 
      // placeHolderToolStripMenuItem1
      // 
      this.placeHolderToolStripMenuItem1.Name = "placeHolderToolStripMenuItem1";
      this.placeHolderToolStripMenuItem1.Size = new System.Drawing.Size(179, 30);
      this.placeHolderToolStripMenuItem1.Text = "placeHolder";
      // 
      // exitToolStripMenuItem
      // 
      this.exitToolStripMenuItem.Name = "exitToolStripMenuItem";
      this.exitToolStripMenuItem.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.X)));
      this.exitToolStripMenuItem.Size = new System.Drawing.Size(179, 30);
      this.exitToolStripMenuItem.Text = "E&xit";
      this.exitToolStripMenuItem.Click += new System.EventHandler(this.exitMainFormMenuStrip_click);
      // 
      // transactionToolStripMenuItem
      // 
      this.transactionToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.purchaseToolStripMenuItem,
            this.sellToolStripMenuItem,
            this.historyToolStripMenuItem});
      this.transactionToolStripMenuItem.Name = "transactionToolStripMenuItem";
      this.transactionToolStripMenuItem.Size = new System.Drawing.Size(114, 29);
      this.transactionToolStripMenuItem.Text = "&Transaction";
      // 
      // purchaseToolStripMenuItem
      // 
      this.purchaseToolStripMenuItem.Name = "purchaseToolStripMenuItem";
      this.purchaseToolStripMenuItem.Size = new System.Drawing.Size(198, 30);
      this.purchaseToolStripMenuItem.Text = "&Purchase";
      this.purchaseToolStripMenuItem.Click += new System.EventHandler(this.purchaseToolStripMenuItem_Click);
      // 
      // sellToolStripMenuItem
      // 
      this.sellToolStripMenuItem.Name = "sellToolStripMenuItem";
      this.sellToolStripMenuItem.Size = new System.Drawing.Size(198, 30);
      this.sellToolStripMenuItem.Text = "&Watch List";
      this.sellToolStripMenuItem.Click += new System.EventHandler(this.sellToolStripMenuItem_Click);
      // 
      // historyToolStripMenuItem
      // 
      this.historyToolStripMenuItem.Name = "historyToolStripMenuItem";
      this.historyToolStripMenuItem.Size = new System.Drawing.Size(198, 30);
      this.historyToolStripMenuItem.Text = "&History";
      this.historyToolStripMenuItem.Click += new System.EventHandler(this.historyToolStripMenuItem_Click);
      // 
      // zedPieControl
      // 
      this.zedPieControl.Location = new System.Drawing.Point(657, 42);
      this.zedPieControl.Margin = new System.Windows.Forms.Padding(6, 8, 6, 8);
      this.zedPieControl.Name = "zedPieControl";
      this.zedPieControl.ScrollGrace = 0D;
      this.zedPieControl.ScrollMaxX = 0D;
      this.zedPieControl.ScrollMaxY = 0D;
      this.zedPieControl.ScrollMaxY2 = 0D;
      this.zedPieControl.ScrollMinX = 0D;
      this.zedPieControl.ScrollMinY = 0D;
      this.zedPieControl.ScrollMinY2 = 0D;
      this.zedPieControl.Size = new System.Drawing.Size(816, 531);
      this.zedPieControl.TabIndex = 1;
      // 
      // zg1
      // 
      this.zg1.Location = new System.Drawing.Point(804, 582);
      this.zg1.Margin = new System.Windows.Forms.Padding(6, 8, 6, 8);
      this.zg1.Name = "zg1";
      this.zg1.ScrollGrace = 0D;
      this.zg1.ScrollMaxX = 0D;
      this.zg1.ScrollMaxY = 0D;
      this.zg1.ScrollMaxY2 = 0D;
      this.zg1.ScrollMinX = 0D;
      this.zg1.ScrollMinY = 0D;
      this.zg1.ScrollMinY2 = 0D;
      this.zg1.Size = new System.Drawing.Size(657, 546);
      this.zg1.TabIndex = 2;
      // 
      // stockDataGridView
      // 
      this.stockDataGridView.AllowUserToAddRows = false;
      this.stockDataGridView.AllowUserToDeleteRows = false;
      dataGridViewCellStyle1.BackColor = System.Drawing.Color.Beige;
      this.stockDataGridView.AlternatingRowsDefaultCellStyle = dataGridViewCellStyle1;
      this.stockDataGridView.BackgroundColor = System.Drawing.Color.LightYellow;
      this.stockDataGridView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
      this.stockDataGridView.Location = new System.Drawing.Point(18, 582);
      this.stockDataGridView.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
      this.stockDataGridView.MultiSelect = false;
      this.stockDataGridView.Name = "stockDataGridView";
      this.stockDataGridView.ReadOnly = true;
      this.stockDataGridView.RowHeadersVisible = false;
      dataGridViewCellStyle2.BackColor = System.Drawing.Color.Bisque;
      dataGridViewCellStyle2.SelectionBackColor = System.Drawing.SystemColors.MenuHighlight;
      this.stockDataGridView.RowsDefaultCellStyle = dataGridViewCellStyle2;
      this.stockDataGridView.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
      this.stockDataGridView.Size = new System.Drawing.Size(777, 546);
      this.stockDataGridView.TabIndex = 3;
      this.stockDataGridView.CellClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.stockDataGridView_CellClick);
      // 
      // nameLabel
      // 
      this.nameLabel.AutoSize = true;
      this.nameLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
      this.nameLabel.Location = new System.Drawing.Point(18, 62);
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
      this.label1.Location = new System.Drawing.Point(18, 120);
      this.label1.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
      this.label1.Name = "label1";
      this.label1.Size = new System.Drawing.Size(166, 29);
      this.label1.TabIndex = 3;
      this.label1.Text = "Cash on hand:";
      // 
      // cashTextBox
      // 
      this.cashTextBox.BackColor = System.Drawing.Color.LightYellow;
      this.cashTextBox.Enabled = false;
      this.cashTextBox.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
      this.cashTextBox.Location = new System.Drawing.Point(369, 111);
      this.cashTextBox.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
      this.cashTextBox.Name = "cashTextBox";
      this.cashTextBox.ReadOnly = true;
      this.cashTextBox.Size = new System.Drawing.Size(163, 35);
      this.cashTextBox.TabIndex = 2;
      this.cashTextBox.TabStop = false;
      // 
      // qtyNumericUpDown
      // 
      this.qtyNumericUpDown.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
      this.qtyNumericUpDown.Location = new System.Drawing.Point(87, 515);
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
      this.label4.Location = new System.Drawing.Point(20, 518);
      this.label4.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
      this.label4.Name = "label4";
      this.label4.Size = new System.Drawing.Size(61, 29);
      this.label4.TabIndex = 13;
      this.label4.Text = "Qty :";
      // 
      // sellButton
      // 
      this.sellButton.BackColor = System.Drawing.Color.SkyBlue;
      this.sellButton.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
      this.sellButton.Location = new System.Drawing.Point(192, 509);
      this.sellButton.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
      this.sellButton.Name = "sellButton";
      this.sellButton.Size = new System.Drawing.Size(224, 48);
      this.sellButton.TabIndex = 12;
      this.sellButton.Text = "Sell Stocks";
      this.sellButton.UseVisualStyleBackColor = false;
      this.sellButton.Click += new System.EventHandler(this.sellButton_Click);
      // 
      // label2
      // 
      this.label2.AutoSize = true;
      this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
      this.label2.Location = new System.Drawing.Point(18, 182);
      this.label2.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
      this.label2.Name = "label2";
      this.label2.Size = new System.Drawing.Size(347, 29);
      this.label2.TabIndex = 16;
      this.label2.Text = "Total money invested in stocks:";
      // 
      // investTextBox
      // 
      this.investTextBox.BackColor = System.Drawing.Color.LightYellow;
      this.investTextBox.Enabled = false;
      this.investTextBox.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
      this.investTextBox.Location = new System.Drawing.Point(369, 172);
      this.investTextBox.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
      this.investTextBox.Name = "investTextBox";
      this.investTextBox.ReadOnly = true;
      this.investTextBox.Size = new System.Drawing.Size(163, 35);
      this.investTextBox.TabIndex = 15;
      this.investTextBox.TabStop = false;
      // 
      // label3
      // 
      this.label3.AutoSize = true;
      this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
      this.label3.Location = new System.Drawing.Point(18, 245);
      this.label3.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
      this.label3.Name = "label3";
      this.label3.Size = new System.Drawing.Size(348, 29);
      this.label3.TabIndex = 18;
      this.label3.Text = "Money value from current price:";
      // 
      // returnTextBox
      // 
      this.returnTextBox.BackColor = System.Drawing.Color.LightYellow;
      this.returnTextBox.Enabled = false;
      this.returnTextBox.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
      this.returnTextBox.Location = new System.Drawing.Point(369, 235);
      this.returnTextBox.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
      this.returnTextBox.Name = "returnTextBox";
      this.returnTextBox.ReadOnly = true;
      this.returnTextBox.Size = new System.Drawing.Size(163, 35);
      this.returnTextBox.TabIndex = 17;
      this.returnTextBox.TabStop = false;
      // 
      // mainFormLoadingCircle
      // 
      this.mainFormLoadingCircle.Active = false;
      this.mainFormLoadingCircle.Color = System.Drawing.Color.DodgerBlue;
      this.mainFormLoadingCircle.InnerCircleRadius = 5;
      this.mainFormLoadingCircle.Location = new System.Drawing.Point(192, 342);
      this.mainFormLoadingCircle.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
      this.mainFormLoadingCircle.Name = "mainFormLoadingCircle";
      this.mainFormLoadingCircle.NumberSpoke = 12;
      this.mainFormLoadingCircle.OuterCircleRadius = 11;
      this.mainFormLoadingCircle.RotationSpeed = 100;
      this.mainFormLoadingCircle.Size = new System.Drawing.Size(224, 160);
      this.mainFormLoadingCircle.SpokeThickness = 2;
      this.mainFormLoadingCircle.StylePreset = MRG.Controls.UI.LoadingCircle.StylePresets.MacOSX;
      this.mainFormLoadingCircle.TabIndex = 19;
      this.mainFormLoadingCircle.Text = "mainFormLoadingCircle";
      // 
      // profitLabel
      // 
      this.profitLabel.AutoSize = true;
      this.profitLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
      this.profitLabel.Location = new System.Drawing.Point(18, 306);
      this.profitLabel.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
      this.profitLabel.Name = "profitLabel";
      this.profitLabel.Size = new System.Drawing.Size(185, 29);
      this.profitLabel.TabIndex = 21;
      this.profitLabel.Text = "Total profit/loss:";
      // 
      // profitTextBox
      // 
      this.profitTextBox.BackColor = System.Drawing.Color.LightYellow;
      this.profitTextBox.Enabled = false;
      this.profitTextBox.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
      this.profitTextBox.Location = new System.Drawing.Point(369, 297);
      this.profitTextBox.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
      this.profitTextBox.Name = "profitTextBox";
      this.profitTextBox.ReadOnly = true;
      this.profitTextBox.Size = new System.Drawing.Size(163, 35);
      this.profitTextBox.TabIndex = 20;
      this.profitTextBox.TabStop = false;
      this.profitTextBox.TextChanged += new System.EventHandler(this.currencyTextBox_TextChanged);
      // 
      // MainForm
      // 
      this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 20F);
      this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
      this.BackColor = System.Drawing.Color.LightGreen;
      this.ClientSize = new System.Drawing.Size(1276, 774);
      this.Controls.Add(this.profitLabel);
      this.Controls.Add(this.profitTextBox);
      this.Controls.Add(this.mainFormLoadingCircle);
      this.Controls.Add(this.label3);
      this.Controls.Add(this.returnTextBox);
      this.Controls.Add(this.label2);
      this.Controls.Add(this.investTextBox);
      this.Controls.Add(this.qtyNumericUpDown);
      this.Controls.Add(this.label4);
      this.Controls.Add(this.sellButton);
      this.Controls.Add(this.nameLabel);
      this.Controls.Add(this.label1);
      this.Controls.Add(this.cashTextBox);
      this.Controls.Add(this.stockDataGridView);
      this.Controls.Add(this.zg1);
      this.Controls.Add(this.zedPieControl);
      this.Controls.Add(this.mainFormMenuStrip);
      this.MainMenuStrip = this.mainFormMenuStrip;
      this.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
      this.Name = "MainForm";
      this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
      this.Text = "Stock Market Simulator Main Form";
      this.mainFormMenuStrip.ResumeLayout(false);
      this.mainFormMenuStrip.PerformLayout();
      ((System.ComponentModel.ISupportInitialize)(this.stockDataGridView)).EndInit();
      ((System.ComponentModel.ISupportInitialize)(this.qtyNumericUpDown)).EndInit();
      this.ResumeLayout(false);
      this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip mainFormMenuStrip;
        private System.Windows.Forms.ToolStripMenuItem fileToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem placeHolderToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem placeHolderToolStripMenuItem1;
        private System.Windows.Forms.ToolStripMenuItem exitToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem transactionToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem purchaseToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem sellToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem historyToolStripMenuItem;
        private ZedGraph.ZedGraphControl zedPieControl;
        private ZedGraph.ZedGraphControl zg1;
        private System.Windows.Forms.DataGridView stockDataGridView;
        private System.Windows.Forms.Label nameLabel;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox cashTextBox;
        private System.Windows.Forms.NumericUpDown qtyNumericUpDown;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Button sellButton;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox investTextBox;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox returnTextBox;
        private MRG.Controls.UI.LoadingCircle mainFormLoadingCircle;
        private System.Windows.Forms.Label profitLabel;
        private System.Windows.Forms.TextBox profitTextBox;
    }
}