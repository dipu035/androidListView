package com.example.listview;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener,OnClickListener {
	
	ListView lvNames;
	ArrayAdapter<String> namesAdapter;
	List<String> names;
	Button btnSubmit;
	
	public static final String NAME_REF = "name";
	private static final int REQUEST_CODE = 101;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		init();
	}

	private void init() {
		lvNames = (ListView) findViewById(R.id.lvNames);
		btnSubmit = (Button) findViewById(R.id.btnSubmit);
		prepareNames();		
		namesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, names);
		lvNames.setAdapter(namesAdapter);
		lvNames.setOnItemClickListener(this);
		btnSubmit.setOnClickListener(this);
	}

	private List<String> prepareNames() {
		names = new ArrayList<String>();
		names.add("Apple");
		names.add("Mango");
		names.add("Grape");
		return names;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {
		Toast.makeText(this, names.get(position), Toast.LENGTH_LONG).show();
		
	}

	@Override
	public void onClick(View arg0) {
		Intent intent = new Intent(MainActivity.this, SecondActivity.class);
		startActivityForResult(intent, REQUEST_CODE);
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode == RESULT_OK){
			if(requestCode == REQUEST_CODE){
				String name = data.getStringExtra(NAME_REF);
				names.add(name);
				lvNames.setAdapter(namesAdapter);
				namesAdapter.notifyDataSetChanged();
			}
		}
	}


}
