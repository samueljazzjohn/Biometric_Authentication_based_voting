package com.example.biometricauthenticationbasedvoting;

import java.util.ArrayList;
import java.util.HashMap;

import org.ksoap2.serialization.SoapObject;

import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.GINGERBREAD) public class U_viewcandidatelist extends Activity {
	ListView l;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_u_viewcandidatelist);
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
		SoapObject obj=new SoapObject(soapclass.NAMESPACE,"cand");
		soapclass sc=new soapclass();
		String ou=sc.Callsoap(obj, "http://tempuri.org/cand");
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
			    hmap.put("d", s2[3]);
				al.add(hmap);
				
				
		}
			ListAdapter lis=new SimpleAdapter(U_viewcandidatelist.this, al,R.layout.candidatelist, new String[]{"a","b","d"}, new int[]{R.id.textView4,R.id.textView5,R.id.textView6});
			l.setAdapter(lis);
			
		}
		else
		{
			Toast.makeText(getApplicationContext(), "No data found", 3).show();
		}
		l.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				
				HashMap<String, String>hmap=(HashMap<String, String>)arg0.getItemAtPosition(arg2);
				Intent i=new Intent(getApplicationContext(),View_candidate.class );
				i.putExtra("img", hmap.get("c"));
				i.putExtra("id", hmap.get("d"));
				i.putExtra("name", hmap.get("b"));
				i.putExtra("post", hmap.get("a"));
				startActivity(i);
			}
		});
	}

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.u_viewcandidatelist, menu);
		return true;
	}

}
