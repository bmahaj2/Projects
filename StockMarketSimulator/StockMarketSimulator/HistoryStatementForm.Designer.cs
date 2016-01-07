namespace StockMarketSimulator
{
    partial class HistoryStatementForm
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
      System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle1 = new System.Windows.Forms.DataGridViewCellStyle();
      System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle2 = new System.Windows.Forms.DataGridViewCellStyle();
      this.historyDataGridView = new System.Windows.Forms.DataGridView();
      ((System.ComponentModel.ISupportInitialize)(this.historyDataGridView)).BeginInit();
      this.SuspendLayout();
      // 
      // historyDataGridView
      // 
      this.historyDataGridView.AllowUserToAddRows = false;
      this.historyDataGridView.AllowUserToDeleteRows = false;
      dataGridViewCellStyle1.BackColor = System.Drawing.Color.Beige;
      this.historyDataGridView.AlternatingRowsDefaultCellStyle = dataGridViewCellStyle1;
      this.historyDataGridView.BackgroundColor = System.Drawing.Color.LightYellow;
      this.historyDataGridView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
      this.historyDataGridView.Location = new System.Drawing.Point(27, 14);
      this.historyDataGridView.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
      this.historyDataGridView.MultiSelect = false;
      this.historyDataGridView.Name = "historyDataGridView";
      this.historyDataGridView.ReadOnly = true;
      this.historyDataGridView.RowHeadersVisible = false;
      dataGridViewCellStyle2.BackColor = System.Drawing.Color.Bisque;
      dataGridViewCellStyle2.SelectionBackColor = System.Drawing.SystemColors.MenuHighlight;
      this.historyDataGridView.RowsDefaultCellStyle = dataGridViewCellStyle2;
      this.historyDataGridView.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
      this.historyDataGridView.Size = new System.Drawing.Size(1061, 434);
      this.historyDataGridView.TabIndex = 4;
      // 
      // HistoryStatementForm
      // 
      this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 20F);
      this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
      this.BackColor = System.Drawing.Color.LightGreen;
      this.ClientSize = new System.Drawing.Size(1120, 966);
      this.Controls.Add(this.historyDataGridView);
      this.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
      this.Name = "HistoryStatementForm";
      this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
      this.Text = "History Statement Form";
      ((System.ComponentModel.ISupportInitialize)(this.historyDataGridView)).EndInit();
      this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.DataGridView historyDataGridView;
    }
}