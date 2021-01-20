package com.example.biometricauthenticationbasedvoting;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Publichome extends Activity {
	Button b1,b2,b3,b4,b5,b6;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_publichome);
	      b1=(Button)findViewById(R.id.button1);
	        b1.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
					Intent i=new Intent(getApplicationContext(),P_viewlawsanddetails.class);
					startActivity(i);				
				}
			});
	    
	      b2=(Button)findViewById(R.id.button2);
	        b2.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
					Intent i=new Intent(getApplicationContext(),U_viewelectionresult.class);
					startActivity(i);				
				}
			});
	        b3=(Button)findViewById(R.id.button3);
	        b3.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
					Intent i=new Intent(getApplicationContext(),P_viewelection.class);
					startActivity(i);				
				}
			});
	        b4=(Button)findViewById(R.id.button4);
	        b4.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
					Intent i=new Intent(getApplicationContext(),P_registration.class);
					startActivity(i);				
				}
			});
	        b5=(Button)findViewById(R.id.button5);
	        b5.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
					Intent i=new Intent(getApplicationContext(),U_viewcandidatelist.class);
					startActivity(i);				
				}
			});
	        b6=(Button)findViewById(R.id.button6);
	        b6.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent i=new Intent(getApplicationContext(),Login.class);
					startActivity(i);
				}
			});
	    }
	    
	    
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.publichome, menu);
		return true;
	}

}
