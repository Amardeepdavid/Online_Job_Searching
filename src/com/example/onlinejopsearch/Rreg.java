package com.example.onlinejopsearch;

import com.quitz.test.db.SQLiteHelper;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Rreg extends Activity {

	SQLiteHelper sh;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rreg);
		sh=new SQLiteHelper(this);
		final EditText e1=(EditText)findViewById(R.id.editText1);
		Button b=(Button)findViewById(R.id.button1);
	final TextView t=(TextView)findViewById(R.id.textView2);
		final EditText e2=(EditText)findViewById(R.id.EditText01);

		b.setOnClickListener(new OnClickListener() {
			
		

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String s=e1.getText().toString();
				String s1=e2.getText().toString();
			int h=sh.insertData1(s, s1);
			t.setText("successfully added");
			}
		});
		
		
	}

	

}
