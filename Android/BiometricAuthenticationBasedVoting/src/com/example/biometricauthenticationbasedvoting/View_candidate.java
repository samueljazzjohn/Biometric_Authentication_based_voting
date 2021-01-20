package com.example.biometricauthenticationbasedvoting;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class View_candidate extends Activity {
	TextView t1,t2,t3;
	ImageView i;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_candidate);
		t1=(TextView)findViewById(R.id.textView2);
		t2=(TextView)findViewById(R.id.textView4);
		t3=(TextView)findViewById(R.id.textView6);
		i=(ImageView)findViewById(R.id.imageView1);
		String id=getIntent().getStringExtra("id");
		String name=getIntent().getStringExtra("name");
		String img=getIntent().getStringExtra("img");
		String post=getIntent().getStringExtra("post");
		t2.setText(name);
		t3.setText(post);
		t1.setText(id);
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_candidate, menu);
		return true;
	}

}
