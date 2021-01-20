using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
using MySql.Data;
using System.Data;
using MySql.Data.MySqlClient;
/// <summary>
/// Summary description for WebService
/// </summary>
[WebService(Namespace = "http://tempuri.org/")]
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
// To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
// [System.Web.Script.Services.ScriptService]
public class WebService : System.Web.Services.WebService
{
    Class1 ob = new Class1();
    public WebService()
    {

        //Uncomment the following line if using designed components 
        //InitializeComponent(); 
    }


    [WebMethod]
    public string viewlaws()
    {
        string s = "";
        MySqlCommand cmd = new MySqlCommand();
        cmd.CommandText = "select * from laws";
        DataTable dt = ob.getdata(cmd);
        if (dt.Rows.Count > 0)
        {
            foreach (DataRow dr in dt.Rows)
            {

                s += dr[0].ToString() + "#" + dr[1].ToString() + "#" + dr[2].ToString() + "@";

            }
        }
        return s;
    }
    [WebMethod]
    public string addlaw( string lw, string de)
    {
        string s = "";
        MySqlCommand cmd = new MySqlCommand();
        //cmd.CommandText = "select max(lid) from laws";
        //int id = ob.max_id(cmd);


        cmd.CommandText = "INSERT INTO `laws`( `laws`, `description`) VALUES ('"+lw+"','"+de+"')";
        try
        {
            ob.execute(cmd);
            s = "success";
        }
        catch
        {
            s = "error";
        }
        return s;
    }

    [WebMethod]
    public string reg(string uname, string pss, string add, string aadhar,  string ph, string em, string img)
    {
        string s = "";
        MySqlCommand cmd = new MySqlCommand();
  
        cmd.CommandText = "INSERT INTO `registration`( `username`, `address`, `phone`, `password`, `email`, ` adhar`, `image`, `status`) VALUES ('" + uname + "','" + add + "','" + ph + "','" + pss + "','" + em + "','" + aadhar + "','" + img + "','pending')";

        ob.execute(cmd);
        cmd.CommandText = "select max(rid) from registration";
        int id = ob.max_id(cmd);
        MySqlCommand cmd1 = new MySqlCommand();
        cmd1.CommandText = "INSERT INTO `login`(`id`, `username`, `password`, `type`) VALUES ('"+id+"','"+em+"','"+pss+"','user')";
        try
        {
            ob.execute(cmd1);
            s = "success";
        }
        catch
        {
            s = "error";
        }
        return s;
    }
   
    [WebMethod]
    public string election()
    {
        string s = "";
        MySqlCommand cmd = new MySqlCommand();
        cmd.CommandText = "select * from election";
        DataTable dt = ob.getdata(cmd);
        if (dt.Rows.Count > 0)
        {
            foreach (DataRow dr in dt.Rows)
            {

                s += dr[0].ToString() + "#" + dr[1].ToString() + "#" + dr[2].ToString() + "#" + dr[3].ToString() + "@";

            }
        }
        return s;
    }
    public string addelection(string ndate, string wdate,string edate)
    {
        string s = "";
        MySqlCommand cmd = new MySqlCommand();

        cmd.CommandText = "INSERT INTO `election`( `ndate`, `wdate`, `edate`) VALUES ('"+ndate+"','"+wdate+"','"+edate+"')";
        try
        {
            ob.execute(cmd);
            s = "success";
        }
        catch
        {
            s = "error";
        }
        return s;
    }
    [WebMethod]
    public string log(string uname,string pss)
    {
        string s="";
        MySqlCommand cmd=new MySqlCommand();
        cmd.CommandText="select * from login where username='"+uname+"' and password='"+pss+"'";
        DataTable dt=ob.getdata(cmd);
        if (dt.Rows.Count > 0)
        {
            s= dt.Rows[0][4].ToString()+"#"+dt.Rows[0][3].ToString();
        }
        else
        {

            s = "error";
        }
        return s;
    }

    [WebMethod]
    public string nom(string rid, string post)
    {
       string s = "";
       MySqlCommand cmd = new MySqlCommand();
       cmd.CommandText = "INSERT INTO `nomination`(  `post`, `status`, `rid`) VALUES ('" + post + "','pending','"+rid+"')";
       try
       { 
           
           ob.execute(cmd);
           s = "success";
       }
       catch
       {
           s = "error";
       }
       return s;

    }

    [WebMethod]
    public string post_manifesto(string cid,string post,string man)
    {
        string s="";
        MySqlCommand cmd=new MySqlCommand();
        cmd.CommandText = "INSERT INTO `manifesto`( `cid`, `post`, `manifesto`) VALUES ('" + cid + "','" + post + "','" + man + "')";
        try
       {
           ob.execute(cmd);
           s = "success";
       }
       catch
       {
           s = "error";
       }
       return s;

    }
    
    [WebMethod]
    public string nmw(string post,string reason,string cid)
    {
        string s="";
        MySqlCommand cmd=new MySqlCommand();
        cmd.CommandText = "INSERT INTO `nomination_withdraw`(   `cid`,`post`,`reason`,`status`) VALUES ('" + cid + "','" + post + "','" + reason + "','pending')";
        try
       {
           ob.execute(cmd);
           s = "success";
       }
       catch
       {
           s = "error";
       }
       return s;
    }

    [WebMethod]
    public string cand()
    {
        string s = "";
        MySqlCommand cmd = new MySqlCommand();
        cmd.CommandText = "select  n.post,r.username,r.image,c.cid from nomination  n,registration r,candidate c where c.rid=r.rid and n.rid=r.rid";
        DataTable dt = ob.getdata(cmd);
        if (dt.Rows.Count > 0)
        {
            foreach (DataRow dr in dt.Rows)
            {

                s += dr[0].ToString() + "#" + dr[1].ToString() + "#" + dr[2].ToString() + "#" + dr[3].ToString() + "@";

            }
        }
        return s;
    }
    [WebMethod]
    public string candlist_for_result(string post)
    {
        string s = "";
        MySqlCommand cmd = new MySqlCommand();
        cmd.CommandText = "select  n.post,r.username,r.image,c.cid from nomination  n,registration r,candidate c where c.rid=r.rid and n.rid=r.rid and  n.post='"+post+"'";
        DataTable dt = ob.getdata(cmd);
        if (dt.Rows.Count > 0)
        {
            foreach (DataRow dr in dt.Rows)
            {

                s += dr[0].ToString() + "#" + dr[1].ToString() + "#" + dr[2].ToString() + "#" + dr[3].ToString() + "@";

            }
        }
        else
        {
            s = "error";
        }
        return s;
    }

        
    //[WebMethod]
    //public string announce_result(string nm,string post,string vote)
    //{
    //    string s="";
    //    MySqlCommand cmd=new MySqlCommand();
    //    cmd.CommandText = " INSERT INTO `result`( `name`, `post`, `votes`) VALUES ('" + nm + "','" + post + "','" + vote + "')";
    //    try
    //   {
    //       ob.execute(cmd);
    //       s = "success";
    //   }
    //   catch
    //   {
    //       s = "error";
    //   }
    //   return s;
    //}

    [WebMethod]
    public string viewman()
    {
        string s = "";
        MySqlCommand cmd = new MySqlCommand();
        cmd.CommandText = "select m.post,m.manifesto,r.username  from manifesto m,candidate c,registration r where m.cid=c.cid and c.rid=r.rid";
        DataTable dt = ob.getdata(cmd);
        if (dt.Rows.Count > 0)
        {
            foreach (DataRow dr in dt.Rows)
            {

                s += dr[0].ToString() + "#" + dr[1].ToString() + "#" + dr[2].ToString() + "@";

            }
        }
        return s;
    }

    //[WebMethod]
    //public string remove_candidate(string nid)
    //{
    //    string s="";
    //    MySqlCommand cmd=new MySqlCommand();
    //    cmd.CommandText="delete from nomination where cid='"+nid+"'";
    //    try
    //    {
    //        ob.execute(cmd);
    //        s = "success";
    //    }
    //    catch
    //    {
    //        s = "error";
    //    }
    //    return s;
    //}

    //[WebMethod]
    //public string regview()
    //{
    //    string s = "";
    //    MySqlCommand cmd = new MySqlCommand();
    //    cmd.CommandText = "select * from registration where status='pending'";
    //    DataTable dt = ob.getdata(cmd);
    //    if (dt.Rows.Count > 0)
    //    {
    //        foreach (DataRow dr in dt.Rows)
    //        {

    //            s += dr[1].ToString() + "#" + dr[2].ToString() + "#" + dr[3].ToString() + "#" + dr[4].ToString() +"#"+dr[5].ToString() + "#" +dr[6].ToString() + "#" +dr[7].ToString() + "#" +dr[8].ToString() + "#" +dr[9].ToString()+"#"+dr[10].ToString()+ "@";

    //        }
    //    }
    //    return s;
    //}

    //[WebMethod]
    //public string nomview()
    //{
    //    string s = "";
    //    MySqlCommand cmd = new MySqlCommand();
    //    cmd.CommandText = "select * from nomination where status='pending'";
    //    DataTable dt = ob.getdata(cmd);
    //    if (dt.Rows.Count > 0)
    //    {
    //        foreach (DataRow dr in dt.Rows)
    //        {

    //            s += dr[1].ToString() + "#" + dr[2].ToString() + "#" + dr[3].ToString() + "#" + dr[4].ToString()+ "@";

    //        }
    //    }
    //    return s;
    //}

    //[WebMethod]
    //public string nomwview()
    //{
    //    string s = "";
    //    MySqlCommand cmd = new MySqlCommand();
    //    cmd.CommandText = "select * from nomination_withdraw where status='pending'";
    //    DataTable dt = ob.getdata(cmd);
    //    if (dt.Rows.Count > 0)
    //    {
    //        foreach (DataRow dr in dt.Rows)
    //        {

    //            s += dr[1].ToString() + "#" + dr[2].ToString() + "#" + dr[3].ToString() + "#" + dr[4].ToString() +"#"+ dr[5].ToString() +   "@";

    //        }
    //    }
    //    return s;
    //}
    
    //[WebMethod]
    //public string accept_reject_reg(string rid,string status)
    //{
    //     string s="";
    //    MySqlCommand cmd=new MySqlCommand();
    //    cmd.CommandText = " UPDATE `registration` SET `status`='"+status+"' WHERE rid='"+rid+"'";
    //    try
    //    {
    //        ob.execute(cmd);
    //        s = "success";
    //    }
    //    catch
    //    {
    //        s = "error";
    //    }
    //    return s;
    //}

    //[WebMethod]
    //public string accept_reject_nom(string nid, string status)
    //{
    //    string s = "";
    //    MySqlCommand cmd = new MySqlCommand();
    //    cmd.CommandText = " UPDATE `nomination` SET `status`='" + status + "' WHERE nid='" + nid + "'";
    //    try
    //    {
    //        ob.execute(cmd);
    //        s = "success";
    //    }
    //    catch
    //    {
    //        s = "error";
    //    }
    //    return s;
    //}

    //[WebMethod]
    //public string accept_reject_nomw(string wid, string status)
    //{
    //    string s = "";
    //    MySqlCommand cmd = new MySqlCommand();
    //    cmd.CommandText = " UPDATE `nomination_withdraw` SET `status`='" + status + "' WHERE wid='" + wid + "'";
    //    try
    //    {
    //        ob.execute(cmd);
    //        s = "success";
    //    }
    //    catch
    //    {
    //        s = "error";
    //    }
    //    return s;
    //}
    


    [WebMethod]
    public string update(string uname, string pss, string add, string aadhar,  string ph, string em, string img)
    {
        string s = "";
        MySqlCommand cmd = new MySqlCommand();
        cmd.CommandText = "UPDATE `registration` SET `username`='"+uname+"',`address`='"+add+"',`phone`='"+ph+"',`password`='"+pss+"',`email`='"+em+"',` aadhar`='"+add+"',`image`='"+img+"'";
        try
        {
            ob.execute(cmd);
            s = "success";
        }
        catch
        {
            s = "error";
        }
        return s;
    }




    [WebMethod]
    public string vw_res(string cid, string post)
    {
        string s = "";
        MySqlCommand cmd = new MySqlCommand();
        cmd.CommandText = "select count(cid) from vote where cid='"+cid+"' and post='"+post+"'";
        DataTable dt = ob.getdata(cmd);
        if (dt.Rows.Count > 0)
        {
            s = dt.Rows[0][0].ToString();
        }
        else
        {

            s = "error";
        }
        return s;
    }



    [WebMethod]
    public string viewprofile(string rid)
    {
        string s = "";
        MySqlCommand cmd = new MySqlCommand();
        cmd.CommandText = "select * from registration where rid='"+rid+"'";
        DataTable dt = ob.getdata(cmd);
        if (dt.Rows.Count > 0)
        {
            foreach (DataRow dr in dt.Rows)
            {

                s= dr[0].ToString() + "#" + dr[1].ToString() + "#" + dr[2].ToString() + "#" + dr[3].ToString() + "#" + dr[5].ToString() + "#" + dr[6].ToString() + "#" + dr[7].ToString() ;

            }
        }
        return s;
    }







}