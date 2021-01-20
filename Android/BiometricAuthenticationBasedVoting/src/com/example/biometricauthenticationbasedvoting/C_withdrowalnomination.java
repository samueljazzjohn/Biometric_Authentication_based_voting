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

@TargetApi(Build.VERSION_CODES.GINGERBREAD) public class C_withdrowalnomination extends Activity {
	EditText e4;
	Spinner s;
	Button b;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_c_withdrowalnomination);
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
		e4=(EditText)findViewById(R.id.editText4);
		b=(Button)findViewById(R.id.button1);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(!e4.getText().toString().equals(""))
				{
				SoapObject obj=new SoapObject(soapclass.NAMESPACE,"nmw");
				obj.addProperty("post", s.getSelectedItem().toString());
				obj.addProperty("reason",e4.getText().toString());
				obj.addProperty("cid",Login.uid);
				soapclass sc=new soapclass();
				String ou=sc.Callsoap(obj, "http://tempuri.org/nmw");
				if(!ou.equals("error")&&!ou.equals(""))
				{
					Toast.makeText(getApplicationContext(), "success", 3).show();
				}
				else
				{
					Toast.makeText(getApplicationContext(), "failed", 3).show();
				}
				}
				{
					Toast.makeText(getApplicationContext(), "Fill", 3).show();
				}
			}
	       
				
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.c_withdrowalnomination, menu);
		return true;
	}

}
