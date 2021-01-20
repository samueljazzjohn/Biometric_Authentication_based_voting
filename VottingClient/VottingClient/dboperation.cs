using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data;
using MySql.Data;
using MySql.Data.MySqlClient;

namespace VottingClient
{
    class dboperation
    {
        MySqlConnection con = new MySqlConnection("server=localhost;database=bio;username=root;password=''");
        public void execute(MySqlCommand cmd)
        {
            cmd.Connection = con;
            try
            {
                con.Open();
                cmd.ExecuteNonQuery();
            }
            catch
            {
            }
            con.Close();
        }

        public DataTable get(MySqlCommand cmd)
        {
            cmd.Connection = con;
            MySqlDataAdapter da = new MySqlDataAdapter();
            da.SelectCommand = cmd;
            DataSet ds = new DataSet();
            da.Fill(ds);
            return ds.Tables[0];
        }

    }
}
