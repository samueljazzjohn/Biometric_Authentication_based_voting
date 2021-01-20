package com.example.biometricauthenticationbasedvoting;

import org.ksoap2.serialization.SoapObject;

import android.R.string;
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

@TargetApi(Build.VERSION_CODES.GINGERBREAD) public class U_update extends Activity {
	EditText e1,e2,e3,e6,e7;
	Button b;
	ImageButton i;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_u_update);
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
	
		
		e6=(EditText)findViewById(R.id.editText6);
		e7=(EditText)findViewById(R.id.editText5);
		b=(Button)findViewById(R.id.button1);
		i=(ImageButton)findViewById(R.id.imageButton1);
		
		e1.setFocusable(false);
		e7.setFocusable(false);
		
		
		SoapObject obj=new SoapObject(soapclass.NAMESPACE,"viewprofile");
		obj.addProperty("rid", Login.uid);
		soapclass sc=new soapclass();
		String ou=sc.Callsoap(obj,"http://tempuri.org/viewprofile");
		if(!ou.equals("error")&&!ou.equals(""))
		{
			String []s=ou.split("#");
			e1.setText(s[1]);
			e2.setText(s[2]);
			e3.setText(s[3]);
			e6.setText(s[4]);
			e7.setText(s[5]);
			//i.setImageBitmap(bm)
			
			
			
		}
	else 		           
			{
			Toast.makeText(getApplicationContext(), "invalid details", 3).show();
		}				
		
		
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
				SoapObject obj1=new SoapObject(soapclass.NAMESPACE,"update");
				obj1.addProperty("rid", Login.uid);
				obj1.addProperty("add", e2.getText().toString());
				obj1.addProperty("ph", e3.getText().toString());
				obj1.addProperty("em", e6.getText().toString());
				obj1.addProperty("img", "img");
				soapclass sc1=new soapclass();
				String ou1=sc1.Callsoap(obj1,  "http://tempuri.org/update");
				if(!ou1.equals("error")&&!ou1.equals(""))
				{
                 Toast.makeText(getApplicationContext(), "updation successfull", 3).show();
					
					
				}
			else 		           
					{
					Toast.makeText(getApplicationContext(), "invalid details", 3).show();
				}
				}
				
			
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.u_update, menu);
		return true;
	}

}
