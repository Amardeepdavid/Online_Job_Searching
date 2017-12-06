package com.example.onlinejopsearch;

import com.quitz.test.db.SQLiteHelper;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Post1 extends Activity {

	 SQLiteHelper sh;
	 String cn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.post);
		sh=new SQLiteHelper(this);
		Intent i = getIntent();
		cn = i.getStringExtra("cn");
		Button b1=(Button)findViewById(R.id.imageView3);
		Button b2=(Button)findViewById(R.id.Button01);
		Button b3=(Button)findViewById(R.id.Button02);
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(Post1.this,Joppost.class);
				i.putExtra("cn", cn);
				startActivity(i);
			}
		});
b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(Post1.this,Resume.class);
				startActivity(i);
			}
		});
b3.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i=new Intent(Post1.this,MainActivity.class);
		startActivity(i);
	}
});
	}

	

}
