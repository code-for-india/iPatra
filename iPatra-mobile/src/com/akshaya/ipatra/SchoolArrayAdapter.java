package com.akshaya.ipatra;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.akshaya.ipatra.vo.School;

public class SchoolArrayAdapter extends ArrayAdapter<School> {
    private static final String tag = "CountryArrayAdapter";
    private static final String ASSETS_DIR = "images/";
    private Context context;
    private TextView schoolIcon;
    private TextView schoolName;
    private List<School> schools = new ArrayList<School>();
 
    public SchoolArrayAdapter(Context context, int textViewResourceId,
            List<School> objects) {
        super(context, textViewResourceId, objects);
        this.context = context;
        this.schools = objects;
    }
 
    public int getCount() {
        return this.schools.size();
    }
 
    public School getItem(int index) {
        return this.schools.get(index);
    }
 
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            // ROW INFLATION
            Log.d(tag, "Starting XML Row Inflation ... ");
            LayoutInflater inflater = (LayoutInflater) this.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.school_listitem, parent, false);
            Log.d(tag, "Successfully completed XML Row Inflation!");
        }
 
        // Get item
        School school = getItem(position);
         
        // Get reference to ImageView 
        schoolIcon = (TextView) row.findViewById(R.id.school_icon);
         
        // Get reference to TextView - country_name
        schoolName = (TextView) row.findViewById(R.id.school_name);
         
        //Set country name
        schoolName.setText(school.getSchoolName());
        
        schoolIcon.setText("NEW");
         
////        // Set country icon usign File path
//        String imgFilePath = "/Users/timran/Tahir/personal/Project/Android/workspace/iPatra/img/ic_launcher.png";
//        try {
//            Bitmap bitmap = BitmapFactory.decodeStream(this.context.getResources().getAssets()
//                    .open(imgFilePath));
//            schoolIcon.setImageBitmap(bitmap);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
         
        // Set country abbreviation
        return row;
    }
}
