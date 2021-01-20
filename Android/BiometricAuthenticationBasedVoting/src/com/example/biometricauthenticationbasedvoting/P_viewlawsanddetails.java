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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.GINGERBREAD) public class P_viewlawsanddetails extends Activity {
	ListView l;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_p_viewlawsanddetails);
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
		l=(ListView)findViewById(R.id.listView1);
		SoapObject obj=new SoapObject(soapclass.NAMESPACE,"viewlaws");
		soapclass sc=new soapclass();
		String ou=sc.Callsoap(obj, "http://tempuri.org/viewlaws");
		if(!ou.equals("error")&&!ou.equals(""))
		{
			ArrayList<HashMap<String, String>> al=new ArrayList<HashMap<String,String>>();
			String []s1=ou.split("@");
			for(int i=0;i<s1.length;i++)
			{
				String []s2=s1[i].split("#");
				HashMap<String, String> hmap=new HashMap<String, String>();
				hmap.put("a", s2[0]);
				hmap.put("b", s2[1]);
				hmap.put("c", s2[2]);
				al.add(hmap);
				
				
			}
			
			ListAdapter lis=new SimpleAdapter(P_viewlawsanddetails.this, al,R.layout.lawsanddetails, new String[]{"a","b","c"}, new int[]{R.id.textView4,R.id.textView5,R.id.textView6});
		l.setAdapter(lis);
		}
		else
		{
			Toast.makeText(getApplicationContext(), "No data found", 3).show();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.p_viewlawsanddetails, menu);
		return true;
	}

}
