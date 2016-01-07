using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;

namespace BusinessTier
{
    public class BusinessLogic
    {
            // fields
            private string _DBFile;
            private DataAccessTier.Data dataTier;
            double initialBal = 10000.00;

            public BusinessLogic(string dataFile)
            {
                this._DBFile = dataFile;
                dataTier = new DataAccessTier.Data(this._DBFile);
            }

            public bool TestConnection()
            {
                return dataTier.TestConnection();
            }

            public String getSecurityQuestion( String userName)
            {

                string sql = string.Format(@"
                             
                        SELECT Question FROM Questions
	                    INNER JOIN(
	                    SELECT QuestionID FROM Users WHERE UserName='{0}'
	                    )T
	                    ON T.QuestionID = Questions.ID;
                              ", userName);
                Object result = dataTier.ExecuteScalarQuery(sql);
                if (result == null)
                {

                    return String.Empty;
                }
                return result.ToString();
            }
            public String getPasswordByQuestion(String userName, String answer)
            {

                string sql = string.Format(@"
                             
	                    SELECT UserPassword FROM Users WHERE UserName='{0}' AND Answer='{1}';
                              ", userName, answer);
                Object result = dataTier.ExecuteScalarQuery(sql);
                if (result == null)
                {

                    return String.Empty;
                }
                return result.ToString();
            }
        public bool updatePassword(string userName, string newpass)
            {
                string sql = string.Format(@"
                             
	                    Update Users set  UserPassword ='{0}' WHERE UserName='{1}';
                              ", newpass, userName);
                Object result = dataTier.ExecuteActionQuery(sql);
                if (result == null)
                    return false;
                else
                    return true;
               
            }
            public bool validateUser(User usr)
            {
                if (usr.userName == string.Empty || usr.password == string.Empty)
                {
                    throw new System.ArgumentException("UserName or password can't be empty");
                }
                else
                {
                    string sql = string.Format(@"
                             
                             SELECT ID, FirstName, LastName, Email, Balance 
                             FROM Users WHERE UserName='{0}' AND UserPassword='{1}';

                              ", usr.userName, usr.password);
                    DataSet ds = dataTier.ExecuteNonScalarQuery(sql);
                    if (ds.Tables[0].Rows.Count == 0)
                    {
                        return false;
                    }
                    DataTable dt = ds.Tables["TABLE"];

                    foreach (DataRow r in dt.Rows)
                    {
                        usr.id = System.Convert.ToInt32(r["ID"]);
                        usr.firstName = System.Convert.ToString(r["FirstName"]);
                        usr.lastName = System.Convert.ToString(r["LastName"]);
                        usr.email = System.Convert.ToString(r["Email"]);
                        usr.balance = System.Convert.ToDouble(r["Balance"]);
                        return true;
                    }

                }
                return false;
            }

            public bool createUser(string userName, string userPassword, string firstName,
                                   string lastName, string email,int questionid, string answer)
            {
                
                    string sql = string.Format(@"
                             
                             SELECT FirstName FROM Users WHERE UserName='{0}';

                              ", userName);
                    Object result = dataTier.ExecuteScalarQuery(sql);
                    if (result == null)
                    {
                        sql = string.Format(@"
                               INSERT INTO Users (UserName, UserPassword, FirstName, LastName, Email, Balance, QuestionID,Answer) 
		                                   VALUES('{0}', '{1}', '{2}', '{3}', '{4}', {5}, {6}, '{7}');
                               ", userName, userPassword, firstName, lastName, email, initialBal,questionid,answer);
                        result = dataTier.ExecuteActionQuery(sql);
                        if (result == null || System.Convert.ToInt32(result.ToString()) <= 0)
                        {
                            return false;
                        }
                        return true;
                    }
                return false;
            }



            public bool UpdateBalance(double Balance,string username)
            {

                string sql = string.Format(@"update Users set Balance={0} where UserName ='{1}'",Balance,username);
                
             Object result = dataTier.ExecuteActionQuery(sql);

               return false;
            }
            public bool populateStocksDB( string addr)
            {
                
                return true;
            }





            public DataTable populateIndustryDropDown()
            {
                string sql = string.Format(@"
                     SELECT DISTINCT  Industry FROM Stocks ORDER BY Industry ASC;"
                    );

                DataSet ds = dataTier.ExecuteNonScalarQuery(sql);
                DataTable dt = ds.Tables["TABLE"];
                DataRow dr;
                dr = dt.NewRow();

                // dr["Name"] = "All";
                dr.ItemArray = new object[1] { "All" };
                dt.Rows.InsertAt(dr, 0);
                return dt;

            }


            public DataTable populateSecurityQuestionDropDown()
            {
                string sql = string.Format(@"
                     SELECT DISTINCT ID, Question FROM Questions;"
                    );

                DataSet ds = dataTier.ExecuteNonScalarQuery(sql);
                DataTable dt = ds.Tables["TABLE"];
                DataRow dr;
                dr = dt.NewRow();

                // dr["Name"] = "All";
               // dr.ItemArray = new object[1] { "All" };
                //dt.Rows.InsertAt(dr, 0);
                return dt;

            }

            public DataTable populateCompanyListWithStockName(string Industry)
            {
                string sql;
                if (Industry.Equals("All"))
                {
                    sql = string.Format(@"
                      SELECT ID,Name,Symbol FROM Stocks ORDER BY Name ASC ;"
                   );
                }
                else
                {
                    sql = string.Format(@"
                        SELECT ID,Name,Symbol FROM Stocks where Industry = '{0}' ORDER BY Name ASC;", Industry
                       );
                }
                DataSet ds = dataTier.ExecuteNonScalarQuery(sql);
                DataTable dt = ds.Tables["TABLE"];
                DataRow dr;
                dr = dt.NewRow();
                return dt;

            }


            public DataTable populateCompanyListWithStockSymbol(string Industry)
            {
                string sql;
                if (Industry.Equals("All"))
                {
                    sql = string.Format(@"
                          SELECT ID,Symbol FROM Stocks ORDER BY Symbol ASC ;"
                   );
                }
                else
                {
                    sql = string.Format(@"
                         SELECT ID,Symbol FROM Stocks where Industry = '{0}' ORDER BY Symbol ASC;", Industry
                       );
                }

                DataSet ds = dataTier.ExecuteNonScalarQuery(sql);
                DataTable dt = ds.Tables["TABLE"];
                DataRow dr;
                dr = dt.NewRow();
                return dt;

            }

            public DataTable getSearchResults(string searchString)
            {
              string sql;
              sql = string.Format(@"
                      SELECT ID,Name,Symbol FROM Stocks 
                      WHERE Name LIKE '%{0}%' OR Symbol LIKE '%{0}%'
                      ORDER BY Name ASC ;", searchString);

              DataSet ds = dataTier.ExecuteNonScalarQuery(sql);
              DataTable dt = ds.Tables["TABLE"];
              DataRow dr;
              dr = dt.NewRow();
              return dt;

            }



            public List<Stock> GetStockInfo(string Symbol)
            {
                List<Stock> stock = new List<Stock>();
                string sql = string.Format(@"
                         SELECT ID,Symbol,Name,IpoYear,Sector,Industry FROM Stocks WHERE Symbol = '{0}';", Symbol
                    );

                DataSet ds = dataTier.ExecuteNonScalarQuery(sql);
                DataTable dt = ds.Tables["TABLE"];
                DataRow dr;
                dr = dt.NewRow();

                foreach (DataRow row in dt.Rows)
                {
                    int id = System.Convert.ToInt32(row["ID"]);
                    string symbol = System.Convert.ToString(row["Symbol"]);
                    string name = System.Convert.ToString(row["Name"]);
                    int ipoYear = System.Convert.ToInt32(row["IpoYear"]);
                    string sector = System.Convert.ToString(row["Sector"]);
                    string industry = System.Convert.ToString(row["Industry"]);
       
                    //company.Add(System.Convert.ToString(row["Symbol"]));
                    //company.Add(System.Convert.ToString(row["Name"]));
                    //if (System.Convert.ToString(row["IpoYear"]).Equals("0"))
                    //{
                    //company.Add("N/A");
                    //}
                    //else
                    //{
                    //    company.Add(System.Convert.ToString(row["IpoYear"]));
                    //}
                    //company.Add(System.Convert.ToString(row["Sector"]));
                    //company.Add(System.Convert.ToString(row["Industry"]));

                    stock.Add(new Stock(id,symbol, name, ipoYear, sector, industry));

                }

                return stock;

            }

            public int GetStockID(string symbol)
            {
                string sql = string.Format(@"
                         SELECT ID FROM Stocks WHERE Symbol = '{0}';", symbol
                   );
                Object result = dataTier.ExecuteScalarQuery(sql);
                return System.Convert.ToInt32(result.ToString());
            }

            public bool UpdateBalance(double Balance, string username, int userid, int stockId, double currentPrice, DateTime date, int selectedQty, String transType)
            {
                string sql = string.Format(@"update Users set Balance={0} where UserName ='{1}'", Balance, username);
                Object result = dataTier.ExecuteActionQuery(sql);

                sql = string.Format(@"
                               INSERT INTO StocksPurchase (UserID, StockID, PurchasePrice, PurchaseDate, NumStocks, TransType) 
		                                   VALUES({0}, {1}, {2}, '{3}', {4}, '{5}');
                               ", userid, stockId, currentPrice, date, selectedQty, transType);
                result = dataTier.ExecuteActionQuery(sql);
                if (result == null)
                {
                    return false;
                }
                if (System.Convert.ToInt32(result.ToString()) <= 0)
                {
                    return false;
                }

                sql = string.Format(@"SELECT Qty, TotalInvestment FROM UserStocksRepo WHERE UserID={0} AND StockID={1}", userid, stockId);
                DataSet ds = dataTier.ExecuteNonScalarQuery(sql);
                DataTable dt = ds.Tables["TABLE"];
                
                int qty = 0;
                Double totalInvestment = 0.0;
                if (transType == "Bought")
                {
                    if (dt.Rows.Count > 0) // update existing row
                    {
                        foreach (DataRow dr in dt.Rows)
                        {
                            qty = System.Convert.ToInt32(dr["Qty"].ToString());
                            totalInvestment = System.Convert.ToDouble(dr["TotalInvestment"].ToString());
                        }
                        sql = string.Format(@"
                        UPDATE UserStocksRepo SET Qty={0}, TotalInvestment={1} 
                               WHERE StockID={2} AND UserID={3};
                        ", (qty + selectedQty), (selectedQty * currentPrice + totalInvestment), stockId, userid);
                        result = dataTier.ExecuteActionQuery(sql);
                    }
                    else // first time purchase
                    {
                        sql = string.Format(@"
                        INSERT INTO UserStocksRepo (StockID, UserID, Qty, TotalInvestment)
                            VALUES({0}, {1}, {2},{3});
                        ", stockId, userid, selectedQty, (selectedQty * currentPrice));
                        result = dataTier.ExecuteActionQuery(sql);

                    }
                }
                else // selling it
                {
                    
                    if (dt.Rows.Count > 0) // update user repo
                    {
                        foreach (DataRow dr in dt.Rows)
                        {
                            qty = System.Convert.ToInt32(dr["Qty"].ToString());
                            totalInvestment = System.Convert.ToDouble(dr["TotalInvestment"].ToString());
                        }
                        if ((qty - selectedQty) == 0)
                        {
                                                    sql = string.Format(@"
                            DELETE UserStocksRepo WHERE StockID={0} AND UserID={1};
                            ", stockId, userid);
                            result = dataTier.ExecuteActionQuery(sql);
                        }else{
                                                    sql = string.Format(@"
                            UPDATE UserStocksRepo SET Qty={0}, TotalInvestment={1} 
                               WHERE StockID={2} AND UserID={3};
                            ", (qty - selectedQty), (totalInvestment -selectedQty * currentPrice), stockId, userid);
                            result = dataTier.ExecuteActionQuery(sql);

                        }

                    }
                    else // can't sell since don't own it
                    {
                        return false;

                    }
                }
                if (result == null)
                {
                    return false;
                }
                if (System.Convert.ToInt32(result.ToString()) <= 0)
                {
                    return false;
                }
                return true;
            }

            public DataTable searchBoxAutoComplete()
            {
                string sql = string.Format(@"
                     SELECT DISTINCT Symbol as symbol FROM Stocks where ;"
                    );

                DataSet ds = dataTier.ExecuteNonScalarQuery(sql);
                DataTable dt = ds.Tables["TABLE"];
                return dt;

            }

            public DataTable getUserPurchaseTable(string username)
            {

              string sql = string.Format(@"
                      SELECT Symbol, Name, T.[Total Stocks], T.[Total Investment]
                      FROM Stocks INNER JOIN(
                        SELECT StockID, Qty AS 'Total Stocks', TotalInvestment AS 'Total Investment'
                        FROM UserStocksRepo
                        INNER JOIN(
                          SELECT ID FROM Users
                           WHERE UserName = '{0}'
                        )T1  
                        ON T1.ID = UserStocksRepo.UserID
                      ) T
                      ON Stocks.ID = T.StockID;
                      ", username);

              DataSet ds = dataTier.ExecuteNonScalarQuery(sql);
              DataTable dt = ds.Tables["TABLE"];
              return dt;
            }

            public DataTable getUserPurchaseHistory(string username)
            {

              string sql = string.Format(@"
                      SELECT Symbol, Name, T.[Transaction Price], T.[Transaction Type], T.[Num. of Stocks], T.[Transaction Date]
                      FROM Stocks INNER JOIN(
                        SELECT StockID, PurchasePrice AS 'Transaction Price', TransType AS 'Transaction Type', NumStocks AS 'Num. of Stocks', PurchaseDate AS 'Transaction Date'
                        FROM StocksPurchase INNER JOIN(
                          SELECT ID FROM Users
                          WHERE UserName = '{0}'
                        ) T2
                        ON StocksPurchase.UserID = T2.ID
                      )T
                      ON Stocks.ID = T.StockID
                      ORDER BY T.[Transaction Date] DESC;
                      ", username);

              DataSet ds = dataTier.ExecuteNonScalarQuery(sql);
              DataTable dt = ds.Tables["TABLE"];
              return dt;
            }

            public bool CheckWatchlist(int userid)
            {

                string sql = string.Format(@"
                             
                             SELECT count(*) FROM Watchlist WHERE UserID='{0}';

                              ", userid);
                Object result = dataTier.ExecuteScalarQuery(sql);

                if (System.Convert.ToInt32(result.ToString()) == 5 )
                {
                    return false;
                }
                else
                {
                    return true;
                }
             
                
            }



            public bool AddToWatchlist(int userid, string symbol)
            {

                string sql = string.Format(@"
                             
                             SELECT UserID FROM Watchlist WHERE UserID={0} and Symbol = '{1}';

                              ", userid, symbol);
                Object result = dataTier.ExecuteScalarQuery(sql);
                if (result == null)
                {
                    sql = string.Format(@"
                               INSERT INTO Watchlist (UserID, Symbol) 
		                                   VALUES({0}, '{1}');
                               ", userid,symbol);
                    result = dataTier.ExecuteActionQuery(sql);
                    if (result == null || System.Convert.ToInt32(result.ToString()) <= 0)
                    {
                        return false;
                    }
                    return true;
                }
                return false;


            }



        public DataTable getWatchlistStock(int userid)
       {
           string sql = string.Format(@"
                             
                             select Watchlist.Symbol as Symbol, Stocks.Name as Name from Watchlist INNER JOIN Stocks on Watchlist.Symbol = Stocks.Symbol where Watchlist.UserID={0};

                              ", userid);

           DataSet ds = dataTier.ExecuteNonScalarQuery(sql);
           DataTable dt = ds.Tables["TABLE"];
           return dt;

       }



        public bool RemoveFromWatchlist(int userid, string symbol)
        {

         
               string sql = string.Format(@" 
                            DELETE FROM Watchlist where UserID = {0} and Symbol = '{1}';
                               ", userid, symbol);
                Object result = dataTier.ExecuteActionQuery(sql);
                if (result == null || System.Convert.ToInt32(result.ToString()) <= 0)
                {
                    return false;
                }
                return true;
          }


        public bool isWatchlistEmpty(int userid)
        {
            string sql = string.Format(@"
                             
                             SELECT count(*) FROM Watchlist WHERE UserID='{0}';

                              ", userid);
            Object result = dataTier.ExecuteScalarQuery(sql);

            if (System.Convert.ToInt32(result.ToString()) == 0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }



        public DataTable searchAutocomplete()
        {
            string sql = string.Format(@"
                     SELECT DISTINCT  Symbol FROM Stocks ORDER BY Symbol ASC;"
                );

            DataSet ds = dataTier.ExecuteNonScalarQuery(sql);
            DataTable dt = ds.Tables["TABLE"];
            //DataRow dr;
            //dr = dt.NewRow();

            // dr["Name"] = "All";
           // dr.ItemArray = new object[1] { "All" };
            //dt.Rows.InsertAt(dr, 0);
            return dt;

        }




    }// class
}
