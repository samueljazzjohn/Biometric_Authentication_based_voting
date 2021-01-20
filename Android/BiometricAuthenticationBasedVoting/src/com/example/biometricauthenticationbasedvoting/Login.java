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
import android.widget.TextView;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.GINGERBREAD) public class Login extends Activity {
	EditText e1,e2;
	Button b1;
	TextView t;
	static String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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
        b1=(Button)findViewById(R.id.button1);
        b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(!e1.getText().toString().equals("")&&!e2.getText().toString().equals(""))
				{
				SoapObject obj=new SoapObject(soapclass.NAMESPACE,"log");
				obj.addProperty("uname", e1.getText().toString());
				obj.addProperty("pss", e2.getText().toString());
				soapclass sc=new soapclass();
				String ou=sc.Callsoap(obj, "http://tempuri.org/log");
				if(!ou.equals("error")&&!ou.equals(""))
				{
					String [] arr=ou.split("#");
					uid=arr[0];
					String type=arr[1];
					if(type.equals("user"))
					{
						Intent i=new Intent(getApplicationContext(),Userhome.class);
						startActivity(i);	
					}
					else	if(type.equals("candidate"))
					{
						Intent i=new Intent(getApplicationContext(),Candidatehome.class);
						startActivity(i);	
					}
				}
				else
				{
					Toast.makeText(getApplicationContext(), "invalid password or username", 3).show();
				}
				}
				else
				{
					Toast.makeText(getApplicationContext(), "Fill", 3).show();
				}
						
			}
			
			
	       
				
		});
        t=(TextView)findViewById(R.id.textView3);
        t.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i=new Intent(getApplicationContext(),Publichome.class);
				startActivity(i);				
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }
    
}
