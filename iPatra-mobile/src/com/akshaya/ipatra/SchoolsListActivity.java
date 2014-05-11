package com.akshaya.ipatra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.akshaya.ipatra.util.FetchDataSrcUtil;
import com.akshaya.ipatra.vo.School;

public class SchoolsListActivity extends ActionBarActivity {
	
	
	List<School> listSchool = null;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_schools);
	
		final ListView listview = (ListView) findViewById(R.id.listView1);
		 
	   listSchool = FetchDataSrcUtil.fetchSchoolList();
	 	
//	    final ArrayList<String> list = new ArrayList<String>();
//	    for (School school: listSchool) {
//	      list.add(school.getSchoolName());
//	    }
//	    
//	    final StableArrayAdapter adapter = new StableArrayAdapter(this,
//	        android.R.layout.simple_list_item_1, list);
	    
	    
	    final SchoolArrayAdapter adapter = new SchoolArrayAdapter(
                getApplicationContext(), R.layout.school_listitem, listSchool);
	    
	    
	    listview.setAdapter(adapter);

	    listview.setOnItemClickListener(new OnItemClickListener() {
	    	  @Override
	    	  public void onItemClick(AdapterView<?> parent, View view,
	    	    int position, long id) {
	    		  Intent i = new Intent(getApplicationContext(), SchoolDetailActivity.class);
	    		  i.putExtra("school", listSchool.get(position));
	    		  startActivityForResult(i , 0);
	    	  }
	    }); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.schools, menu);
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
	
	 private class StableArrayAdapter extends ArrayAdapter<String> {

		    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

		    public StableArrayAdapter(Context context, int textViewResourceId,
		        List<String> objects) {
		      super(context, textViewResourceId, objects);
		      for (int i = 0; i < objects.size(); ++i) {
		        mIdMap.put(objects.get(i), i);
		      }
		    }

		    @Override
		    public long getItemId(int position) {
		      String item = getItem(position);
		      return mIdMap.get(item);
		    }

		    @Override
		    public boolean hasStableIds() {
		      return true;
		    }

		  }

}
