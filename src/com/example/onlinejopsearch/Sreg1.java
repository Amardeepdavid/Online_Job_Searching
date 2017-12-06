package com.example.onlinejopsearch;


import com.quitz.test.db.SQLiteHelper;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Sreg1 extends Activity {
RadioButton r;
 EditText e1;
String sp;
String sp1;
String name1;

String pass1;

String email1;

String mobile1;

String sex1;
SQLiteHelper sh;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sreg1);
		sh=new SQLiteHelper(this);
		Intent i1 = getIntent();
		name1=i1.getStringExtra("name");

		pass1=i1.getStringExtra("pass");

		email1=i1.getStringExtra("email");

		mobile1=i1.getStringExtra("mobile");

		sex1=i1.getStringExtra("sex");
		
		String s1[] ={"select","B.E/B.Tech","Mca","Bsc","Msc","M.E/M.Tech"};
		String s2[] ={"select","Java",".Net","php","Oracle","Networking"};
 e1=(EditText)findViewById(R.id.editText1);
	Button b=(Button)findViewById(R.id.button1);

	ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
			android.R.layout.simple_spinner_item, s1);
	ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
			android.R.layout.simple_spinner_item, s2);
		final EditText e2=(EditText)findViewById(R.id.editText2);
		final Spinner s11=(Spinner)findViewById(R.id.spinner11);
		final Spinner s12=(Spinner)findViewById(R.id.spinner1);
		final TextView t=(TextView)findViewById(R.id.textView5);
		s11.setAdapter(adapter);
		s12.setAdapter(adapter1);

	s11.setOnItemSelectedListener(new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			sp=s11.getSelectedItem().toString();
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
	});
	s12.setOnItemSelectedListener(new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			sp1=s12.getSelectedItem().toString();
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
	});
		
		
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String s1=e1.getText().toString();
				String s2=e2.getText().toString();
				
				int m=sh.insertData(name1, pass1,email1,mobile1,sex1,sp,s1,sp1,s2);
				
			t.setText("Successfully added");

		
			    

	 
			}
		});
	}

	

}
