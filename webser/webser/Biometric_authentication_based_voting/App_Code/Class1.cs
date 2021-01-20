using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using MySql.Data.MySqlClient;
using System.Data;
using MySql.Data;

/// <summary>
/// Summary description for Class1
/// </summary>
public class Class1
{
    MySqlConnection con = new MySqlConnection(@"server=localhost;database=bio;username=root;password=''");
    public Class1()
	{
		//
		// TODO: Add constructor logic here
		//
	}
    public void execute(MySqlCommand cmd)
    {
        cmd.Connection = con;
        con.Open();
        cmd.ExecuteNonQuery();
        con.Close();
    }
    public DataTable getdata(MySqlCommand cmd)
    {
        cmd.Connection = con;
        MySqlDataAdapter da = new MySqlDataAdapter();
        da.SelectCommand = cmd;
        DataSet ds = new DataSet();
        da.Fill(ds);
        return ds.Tables[0];
    }
    public int max_id(MySqlCommand cmd)
    {
        cmd.Connection = con;
        int i;
        try
        {
            con.Open();
            i = Convert.ToInt32(cmd.ExecuteScalar());
        }
        catch
        {
            i = 1;
        }
        finally
        {
            con.Close();
        }

        return i;
    }
}