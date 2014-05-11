package com.akshaya.ipatra;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends ActionBarActivity {

	Spinner spinner = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 addItemsOnSpinner();
		
		
	}
	
	//add items into spinner dynamically
		public void addItemsOnSpinner() {

			spinner = (Spinner) findViewById(R.id.spinner1);
			List<String> list = new ArrayList<String>();
			list.add("RC00001");
			list.add("RC00002");
			list.add("RC00003");
			ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
			dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			spinner.setAdapter(dataAdapter);
			
			Button btnSubmit = (Button) findViewById(R.id.button1);
			 
			btnSubmit.setOnClickListener(new OnClickListener() {
		 
			  @Override
			  public void onClick(View v) {
		 
				  Intent i = new Intent(getApplicationContext(), SchoolsListActivity.class);
				  startActivity(i);
			  }
			  
			});
			
			
			
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
