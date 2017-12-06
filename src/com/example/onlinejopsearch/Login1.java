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

public class Login1 extends Activity {

	 SQLiteHelper sh;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login1);
		sh=new SQLiteHelper(this);
		Button b=(Button)findViewById(R.id.button1);
		Button b1=(Button)findViewById(R.id.button2);
		final EditText e1=(EditText)findViewById(R.id.editText1);
		final EditText e2=(EditText)findViewById(R.id.editText2);
		final TextView t=(TextView)findViewById(R.id.textView3);
		
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String s=e1.getText().toString();
				String s1=e2.getText().toString();
				String m=sh.loginData1(s, s1);
				if(m.equals("ok"))
				{

					Intent i=new Intent(Login1.this,Post1.class);
					i.putExtra("cn", s);
					startActivity(i);
				}
				else
				{
				t.setText("Login failed.Try again");
				}
				
			}
		});
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent i=new Intent(Login1.this,Rreg.class);
				startActivity(i);
			}
		});
		
	}

	

}
