package com.example.biometricauthenticationbasedvoting;

import org.ksoap2.serialization.SoapObject;

import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.GINGERBREAD) public class P_registration extends Activity {
	EditText e1,e2,e3,e4,e5,e6,e7;
	Button b;
	ImageButton i;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_p_registration);
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
		e1=(EditText)findViewById(R.id.editText1);
		e2=(EditText)findViewById(R.id.editText2);
		e3=(EditText)findViewById(R.id.editText3);
		e4=(EditText)findViewById(R.id.editText4);
		e5=(EditText)findViewById(R.id.editText5);
		e6=(EditText)findViewById(R.id.editText6);
		e7=(EditText)findViewById(R.id.editText7);
		b=(Button)findViewById(R.id.button1);
		i=(ImageButton)findViewById(R.id.imageButton1);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(!e1.getText().toString().equals("") && !e2.getText().toString().equals("")
						&& !e3.getText().toString().equals("") && !e4.getText().toString().equals("")
						&& !e5.getText().toString().equals("") && !e6.getText().toString().equals("")
						&& !e1.getText().toString().equals(""))
				{
				SoapObject obj=new SoapObject(soapclass.NAMESPACE,"reg");
				obj.addProperty("uname",e1.getText().toString());
				obj.addProperty("pss",e5.getText().toString());
				obj.addProperty("add",e2.getText().toString());
				obj.addProperty("aadhar",e7.getText().toString());
				obj.addProperty("ph",e3.getText().toString());
				obj.addProperty("em",e6.getText().toString());
				obj.addProperty("img","img");
				soapclass sc=new soapclass();
				String ou=sc.Callsoap(obj,  "http://tempuri.org/reg");
				if(!ou.equals("error")&&!ou.equals(""))
				{
		        	Toast.makeText(getApplicationContext(), "registration success", 3).show();
				}
			else 		           
 				{
					Toast.makeText(getApplicationContext(), "invalid details", 3).show();
				}
				Intent i=new Intent(getApplicationContext(),Login.class);
				startActivity(i);				
			}
			else
			{
				Toast.makeText(getApplicationContext(), "Fill", 3).show();
			}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.p_registration, menu);
		return true;
	}

}
