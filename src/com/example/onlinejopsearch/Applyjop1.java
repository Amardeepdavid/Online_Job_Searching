package com.example.onlinejopsearch;



import com.quitz.test.db.SQLiteHelper;

import java.util.ArrayList;

import android.app.Activity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;



	public class Applyjop1 extends Activity  {
		private SQLiteHelper SQLHelper;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.applyjop2);
			  SQLHelper = new SQLiteHelper(this); 
			  Button b=(Button)findViewById(R.id.button1);
		TextView cn=(TextView)findViewById(R.id.textView2);	
		TextView el=(TextView)findViewById(R.id.textView4);	
		TextView ex=(TextView)findViewById(R.id.textView6);	
		TextView po=(TextView)findViewById(R.id.textView8);	
		final TextView t=(TextView)findViewById(R.id.textView10);
		TextView sa=(TextView)findViewById(R.id.textView12);	
		TextView lo=(TextView)findViewById(R.id.textView14);
		
	
		 Intent i = getIntent();

			// Place referece id
			final String cn1 = i.getStringExtra("cn");
			String po1=i.getStringExtra("po");
			String lo1=i.getStringExtra("lo");
			String el1 = i.getStringExtra("el");
			String ex1=i.getStringExtra("ex");
			String id1=i.getStringExtra("ld");
			String sa1 = i.getStringExtra("sa");
			final String n1 = i.getStringExtra("n1");
			
			cn.setText(cn1);
			po.setText(po1);
			lo.setText(lo1);
			el.setText(el1);
			ex.setText(ex1);
		
			sa.setText(sa1);
			b.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					SQLHelper.cr(cn1, n1);
					t.setText("successfully applied");
				}
			});
			
}
	}

	

