using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace VottingClient
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
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

        string sin = "";
        public delegate void showres();

        public void printres()
        {
            
            textBox1.Text =textBox1.Text +  sin;
            textBox1.Select(textBox1.Text.Length - 1,0);

            //textBox1.SelectionStart = textBox1.Text.Length;
            textBox1.ScrollToCaret();

        }


        private void serialPort1_DataReceived(object sender, System.IO.Ports.SerialDataReceivedEventArgs e)
        {
            sin = serialPort1.ReadExisting();
            this.Invoke(new showres(printres));

        }

        private void button3_Click(object sender, EventArgs e)
        {
           // byte[] b = new byte[] { 65 };
           //serialPort1.Write(b, 0, 1);
            serialPort1.Write("A");
        }

        private void button2_Click(object sender, EventArgs e)
        {
            serialPort1.Write(textBox2.Text);

        }
    }
}
