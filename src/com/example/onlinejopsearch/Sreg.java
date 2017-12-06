package com.example.onlinejopsearch;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Sreg extends Activity {
RadioButton r;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sreg);
		final EditText e1=(EditText)findViewById(R.id.editText1);
	Button b=(Button)findViewById(R.id.button1);
		final EditText e2=(EditText)findViewById(R.id.EditText01);
		final EditText e3=(EditText)findViewById(R.id.EditText02);
		final EditText e4=(EditText)findViewById(R.id.EditText03);
		final RadioGroup rg=(RadioGroup)findViewById(R.id.radioGroup1);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String s1=e1.getText().toString();
				String s2=e2.getText().toString();
				String s3=e3.getText().toString();
				String s4=e4.getText().toString();
			
				int selectedId = rg.getCheckedRadioButtonId();
				 
				// find the radiobutton by returned id
			        r = (RadioButton) findViewById(selectedId);
	 String s5=r.getText().toString();

Intent i1=new Intent(Sreg.this,Sreg1.class);
	 i1.putExtra("name", s1);
	 i1.putExtra("pass", s2);
	 i1.putExtra("email", s3);
	 i1.putExtra("mobile", s4);
	 i1.putExtra("sex", s5);
	startActivity(i1);
	
			}
		});
	}


	

}
