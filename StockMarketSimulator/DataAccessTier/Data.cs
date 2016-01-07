//
// Data Access Tier:  interface between business tier and data store.
//

using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;


namespace DataAccessTier
{

    public class Data
    {
        //
        // Fields:
        //
        private string _DBFile;
        private string _DBConnectionInfo;

        //
        // constructor:
        //
        public Data(string DatabaseFilename)
        {
            _DBFile = DatabaseFilename;
            _DBConnectionInfo = String.Format(@"Data Source=(LocalDB)\v11.0;AttachDbFilename=|DataDirectory|\{0};Integrated Security=True;", DatabaseFilename);
        }

        //
        // TestConnection:  returns true if the database can be successfully opened and closed,
        // false if not.
        //
        public bool TestConnection()
        {
            SqlConnection db = new SqlConnection(_DBConnectionInfo);

            bool state = false;

            try
            {
                db.Open();

                state = (db.State == ConnectionState.Open);
            }
            catch
            {
                // nothing, just discard:
            }
            finally
            {
                db.Close();
            }

            return state;
        }

        //
        // ExecuteScalarQuery:  executes a scalar Select query, returning the single result
        // as an object.  
        //
        public object ExecuteScalarQuery(string sql)
        {
            //
            // TODO!
            //
            SqlConnection db = new SqlConnection(_DBConnectionInfo);
            SqlCommand cmd = new SqlCommand();
            cmd.Connection = db;
            db.Open();

            cmd.CommandText = sql;

            object result = cmd.ExecuteScalar();
            db.Close();
            if (result != null)
            {
                return result;
            }

            return null;
        }

        //
        // ExecuteNonScalarQuery:  executes a Select query that generates a temporary table,
        // returning this table in the form of a Dataset.
        //
        public DataSet ExecuteNonScalarQuery(string sql)
        {
            //
            // TODO!
            //
            SqlConnection db = new SqlConnection(_DBConnectionInfo);
            SqlCommand cmd = new SqlCommand();
            cmd.Connection = db;
            db.Open();
            
            cmd.CommandText = sql;
            
            SqlDataAdapter adapter = new SqlDataAdapter(cmd);
            DataSet ds = new DataSet();
            adapter.Fill(ds);  // execute!
            db.Close();
            //DataTable dt = ds.Tables["TABLE"];

            return ds;
        }

        //
        // ExecutionActionQuery:  executes an Insert, Update or Delete query, and returns
        // the number of records modified.
        //
        public int ExecuteActionQuery(string sql)
        {
            //
            // TODO!
            //
            SqlConnection db = new SqlConnection(_DBConnectionInfo);
            SqlCommand cmd = new SqlCommand();
            cmd.Connection = db;
            db.Open();

            cmd.CommandText = sql;

            int rowsModified = cmd.ExecuteNonQuery();
            db.Close();

            if (rowsModified == 0)
            {
                return -1;
            }

            return rowsModified;
        }
        public bool bulkData(string addr)
        {
            SqlConnection db = new SqlConnection(_DBConnectionInfo);
            System.Data.SqlClient.SqlCommand cmd = new SqlCommand();
            cmd.Connection = db;
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.CommandText = "CreateBulkSymbols";
            var bc = cmd.Parameters.Add("bulk_command", SqlDbType.NVarChar);
            var retval = cmd.Parameters.Add("RetVal", SqlDbType.Int);
            retval.Direction = ParameterDirection.ReturnValue;
            bc.Direction = ParameterDirection.Input;
            bc.Value = addr;
            object result = cmd.ExecuteScalar();
            if (result == null)
            {
                return false;
            }
            int rv = Convert.ToInt32(retval.Value);
            if (rv == 0)
            {
                return false;
            }
            return true;
        }

    }//class

}//namespace
