package com.example.biometricauthenticationbasedvoting;

import java.util.ArrayList;
import java.util.HashMap;

import org.ksoap2.serialization.SoapObject;

import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.TargetApi;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.GINGERBREAD) public class U_viewelectionresult extends Activity {
	Spinner s1,s2;
	Button b;
	TextView res;
String cid[],cnm[];
String candid;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_u_viewelectionresult);
		try
    	{
    		if (android.os.Build.VERSION.SDK_INT > 9) 
    		{
    			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
    			StrictMode.setThreadPolicy(policy);
    		}
    	}
    	catch(Exception e)
    	{
    		
    	}
		s1=(Spinner)findViewById(R.id.spinner1);
		s2=(Spinner)findViewById(R.id.spinner2);
		b=(Button)findViewById(R.id.button1);
		res=(TextView)findViewById(R.id.textView4);
		s1.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				SoapObject obj=new SoapObject(soapclass.NAMESPACE,"candlist_for_result");
				obj.addProperty("post", s1.getSelectedItem().toString());
				soapclass sc=new soapclass();
				String ou=sc.Callsoap(obj, "http://tempuri.org/candlist_for_result");
				if(!ou.equals("error")&&!ou.equals(""))
				{
					String []c1=ou.split("@");
					cid=new String[c1.length];
					cnm=new String[c1.length];
					for(int i=0;i<c1.length;i++)
					{
						
						String []c2=c1[i].split("#");
						cid[i]=c2[3];
						cnm[i]=c2[1];
						
						
					}
					ArrayAdapter<String> ad=new ArrayAdapter<String>(U_viewelectionresult.this, android.R.layout.simple_spinner_item,cnm);
					s2.setAdapter(ad);
					
				}
				else
				{
					Toast.makeText(getApplicationContext(), "No data found", 3).show();
				}
			
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		s2.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				candid=cid[arg2];
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				SoapObject obj1=new SoapObject(soapclass.NAMESPACE,"vw_res");
				obj1.addProperty("cid", candid);
				obj1.addProperty("post", s1.getSelectedItem().toString());
				soapclass sc1=new soapclass();
				String ou1=sc1.Callsoap(obj1, "http://tempuri.org/vw_res");
				if(!ou1.equals("error")&&!ou1.equals(""))
				{

					res.setText(ou1);
				}
				else
				{
					Toast.makeText(getApplicationContext(), "No data found", 3).show();
				}
			}
			
		});

	}

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.u_viewelectionresult, menu);
		return true;
	}

}
