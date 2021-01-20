using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using MySql.Data;
using MySql.Data.MySqlClient;

namespace VottingClient
{
    public partial class frm_matching : Form
    {
        dboperation db = new dboperation();
        string can_id;
        public frm_matching()
        {
            InitializeComponent();
        }
        
        string sin = "";
        public delegate void showres();

        public void printres()
        {

            textBox1.Text = textBox1.Text + sin;
            textBox1.Select(textBox1.Text.Length - 1, 0);

            //textBox1.SelectionStart = textBox1.Text.Length;
            textBox1.ScrollToCaret();


            //*1#A$
            if (textBox1.Text.Contains('$'))
            {
                string vt = textBox1.Text.Substring(1, 3);
                label2.Text = vt;
                string[] sp = vt.Split('#');
                label3.Text = sp[0];
                label4.Text = sp[1];
                textBox1.Clear();
                
                if(label4.Text=="A")
                {
                    can_id="1";
                }
                if(label4.Text=="B")
                {
                    can_id="2";
                }
                 if(label4.Text=="C")
                {
                    can_id="3";
                }
                 if(label4.Text=="D")
                {
                    can_id="4";
                }
                MySqlCommand cmd = new MySqlCommand();


                cmd.CommandText = "select  post from nomination where status='accept' and rid='" + can_id + "'";
                DataTable dt=db.get(cmd);

                cmd.CommandText = "select * from vote where post ='" + comboBox2.Text + "' and uid='" + label3.Text + "'";
                DataTable dt1=db.get(cmd);
                if(dt1.Rows.Count>0)
                {
                    MessageBox.Show("You are Already voted");
                }
                else
                {
                    cmd.CommandText = "INSERT INTO `vote`(`cid`, `post`, `uid`) VALUES ('" + can_id + "','" + comboBox2.Text + "','" + label3.Text + "')";
                    db.execute(cmd);
                    MessageBox.Show("Success");
                }


                


            }


        }


        private void frm_matching_Load(object sender, EventArgs e)
        {
            MySqlCommand cmd = new MySqlCommand();
            cmd.CommandText = "select distinct post from nomination";
            comboBox2.DataSource = db.get(cmd);
            comboBox2.DisplayMember="post";
            comboBox2.ValueMember = "post";
           // comboBox2.Items.Insert(0, "select");
        }

        private void serialPort1_DataReceived(object sender, System.IO.Ports.SerialDataReceivedEventArgs e)
        {
            sin = serialPort1.ReadExisting();
            this.Invoke(new showres(printres));
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (serialPort1.IsOpen)
                serialPort1.Close();
            serialPort1.PortName = comboBox1.Text;
            try
            {
                serialPort1.Open();

            }
            catch (Exception ex)
            {
                MessageBox.Show("Invalid Port");

            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            try
            {
                 serialPort1.Write("B");

            }
            catch (Exception ex)
            {
 

            }
        }

        private void comboBox2_SelectedIndexChanged(object sender, EventArgs e)
        {

        }
    }
}
