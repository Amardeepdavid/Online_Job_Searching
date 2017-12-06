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



	public class Resume extends Activity  {
		private SQLiteHelper SQLHelper;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.apply3);
			 Intent i = getIntent();

				// Place referece id
				
				final String n1=i.getStringExtra("n");
			ArrayList<String[]> DATA = new ArrayList<String[]>();
			ListView lv ;
			  SQLHelper = new SQLiteHelper(this); 
			  DATA=SQLHelper.selectalldatabase1();
			  
			lv=(ListView)findViewById(R.id.listView1);
			
			if(!DATA.isEmpty())
			{
			       lv.setAdapter(new MyCustomBaseAdapter1(this, DATA));
			   lv.setOnItemClickListener(new OnItemClickListener() {
			    	 public void onItemClick(AdapterView<?> arg0, View v,int position, long arg3)
			         {
			             // position parameter gives the index or position of ListView Item which is Clicked
			             TextView tv1=(TextView)v.findViewById(R.id.textView2);
			             TextView tv=(TextView)v.findViewById(R.id.textView1);
			             
			             TextView tv2=(TextView)v.findViewById(R.id.textView3);
			             TextView tv3=(TextView)v.findViewById(R.id.textView4);
			             TextView tv4=(TextView)v.findViewById(R.id.textView5);
			             TextView tv5=(TextView)v.findViewById(R.id.textView6);
			             TextView tv6=(TextView)v.findViewById(R.id.textView7);
			             
			             String ad=tv1.getText().toString();
			             String n=tv.getText().toString();
			            String ph= tv2.getText().toString();
			         	
			            String el=tv3.getText().toString();
			             String ex=tv4.getText().toString();
			            String id= tv5.getText().toString();
			            String sa=tv6.getText().toString();
			         

			            Intent i = new Intent(Resume.this, Applyjop2.class);
			         	
			         	i.putExtra("cn", n);
			         	i.putExtra("po", ad);
			         	i.putExtra("lo", ph);
			         	i.putExtra("el", el);
			         	i.putExtra("ex", ex);
			         	i.putExtra("id", id);
			         	i.putExtra("sa", sa);
			         	i.putExtra("n1", n1);
			         
			         	startActivity(i);
			         
			             
			           
			         }
				});


			}
			else
			{
				Toast.makeText(this,"no", Toast.LENGTH_LONG).show();
			}
			
}
	}

	

