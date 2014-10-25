package com.example.listview;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends Activity implements OnClickListener {
	
	Button btnSubmit;
	EditText etName;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		init();
	}
	
	private void init() {
		btnSubmit = (Button) findViewById(R.id.btnSubmit);
		etName = (EditText) findViewById(R.id.etName);
		
		btnSubmit.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent();
		intent.putExtra(MainActivity.NAME_REF, etName.getText().toString());
		setResult(RESULT_OK, intent);
		finish();
	}
}
