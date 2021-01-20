package com.example.biometricauthenticationbasedvoting;

import org.ksoap2.serialization.SoapObject;

import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.TargetApi;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.GINGERBREAD) public class C_electionmanifesto extends Activity {
	EditText e3;
	Button b;
	Spinner s;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_c_electionmanifesto);
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
		s=(Spinner)findViewById(R.id.spinner1);
		
		e3=(EditText)findViewById(R.id.editText3);
		b=(Button)findViewById(R.id.button1);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				if(!e3.getText().toString().equals(""))
				{
				SoapObject obj=new SoapObject(soapclass.NAMESPACE,"post_manifesto");
				obj.addProperty("cid",Login.uid);
				obj.addProperty("post",s.getSelectedItem().toString());
				obj.addProperty("man",e3.getText().toString());
			
				soapclass sc=new soapclass();
				String ou=sc.Callsoap(obj,  "http://tempuri.org/post_manifesto");
				if(!ou.equals("error")&&!ou.equals(""))
				{
		        	Toast.makeText(getApplicationContext(), "success", 3).show();
				}
			else 		           
 				{
					Toast.makeText(getApplicationContext(), "invalid details", 3).show();
				}
			}
				else
				{
					Toast.makeText(getApplicationContext(), "Fill...", 3).show();	
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.c_electionmanifesto, menu);
		return true;
	}

}
