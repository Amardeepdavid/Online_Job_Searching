package com.example.onlinejopsearch;

import com.quitz.test.db.SQLiteHelper;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class Joppost extends Activity {

	 SQLiteHelper sh;
	 String sp;
	 String sp1;
	 String cn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jopp);
		Intent i1 = getIntent();
		cn=i1.getStringExtra("cn");

		sh=new SQLiteHelper(this);
		final Spinner s=(Spinner)findViewById(R.id.spinner1);
		final Spinner s1=(Spinner)findViewById(R.id.spinner2);
		final EditText e1=(EditText)findViewById(R.id.editText1);
		final EditText e2=(EditText)findViewById(R.id.editText2);
		final EditText e3=(EditText)findViewById(R.id.EditText01);
		final EditText e4=(EditText)findViewById(R.id.EditText02);
		String a1[] ={"select","B.E/B.Tech","Mca","Bsc","Msc","M.E/M.Tech"};
		String a2[] ={"select","Java developer",".Net developer","php developer","Oracle developer","Networking developer"};
		Button b=(Button)findViewById(R.id.button1);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, a1);
		ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, a2);
		s.setAdapter(adapter);
		s1.setAdapter(adapter1);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				String d1=e1.getText().toString();
				String d2=e2.getText().toString();
				String d3=e3.getText().toString();
				String d4=e4.getText().toString();
				int h=sh.insertData2(cn, sp, d1, sp1, d2, d3, d4 );
			}
		});

	s.setOnItemSelectedListener(new OnItemSelectedListener() {



		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			sp=s.getSelectedItem().toString();
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
	});
	s1.setOnItemSelectedListener(new OnItemSelectedListener() {



		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
		sp1 = s1.getSelectedItem().toString();
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
	});
		
		
	}

	

}
