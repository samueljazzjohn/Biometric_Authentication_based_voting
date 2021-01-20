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

@TargetApi(Build.VERSION_CODES.GINGERBREAD) public class U_submitnomination extends Activity {
	Spinner s;
	Button b;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_u_submitnomination);
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
		b=(Button)findViewById(R.id.button1);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				SoapObject obj=new SoapObject(soapclass.NAMESPACE,"nom");
				obj.addProperty("rid", Login.uid);
				obj.addProperty("post", s.getSelectedItem().toString());
				soapclass sc=new soapclass();
				String ou=sc.Callsoap(obj, "http://tempuri.org/nom");
				if(!ou.equals("error")&&!ou.equals(""))
				{
					Toast.makeText(getApplicationContext(), "nomination successfully sent", 3).show();
				}
				else
				{
					Toast.makeText(getApplicationContext(), "invalid password or username", 3).show();
				}

				
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.u_submitnomination, menu);
		return true;
	}

}
