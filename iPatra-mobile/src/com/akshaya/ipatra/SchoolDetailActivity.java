package com.akshaya.ipatra;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.akshaya.ipatra.datasource.SchoolsDataSource;
import com.akshaya.ipatra.vo.School;

public class SchoolDetailActivity extends ActionBarActivity {

	private SchoolsDataSource datasource;
	School school = null;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_school_detail);
		
		Intent i = this.getIntent();
		school = (School)i.getSerializableExtra("school");
		
		TextView textView = (TextView) findViewById(R.id.schoolTitle);
		textView.setText(school.getSchoolName());	
		
		datasource = new SchoolsDataSource(this);
	    datasource.open();

	    Button btnSubmit = (Button) findViewById(R.id.button1);
	   
	    btnSubmit.setOnClickListener(new OnClickListener() {
	    	
		  @Override
		  public void onClick(View v) {
			  datasource.insertIntent(100, 150, school.getSchoolId() , "NEW");
			  Log.d("SchoolsDataSource" , "Insert Successful");
			  Intent intentMessage=new Intent();

			  // put the message to return as result in Intent
		      intentMessage.putExtra("MESSAGE","0");
		      // Set The Result in Intent
		      setResult(2,intentMessage);
			  finish();
		  }
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.school_detail, menu);
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
