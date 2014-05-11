package com.akshaya.ipatra.datasource;




import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {

  public static final String TABLE_SCHOOL = "schools";
  public static final String COLUMN_ID = "_id";
  public static final String COLUMN1 = "yesterday_actual";
  public static final String COLUMN2 = "tomorrow_need";
  public static final String COLUMN3 = "school_id";
  public static final String COLUMN4 = "status";
  

  private static final String DATABASE_NAME = "schools.db";
  private static final int DATABASE_VERSION = 1;

  // Database creation sql statement
  private static final String DATABASE_CREATE = "create table "
      + TABLE_SCHOOL + "(" + COLUMN_ID
      + " integer primary key autoincrement, " + COLUMN1
      + " integer ,  " + COLUMN2  +  " integer , " + COLUMN3  + " string , " + COLUMN4 + " string  ) " ;

  public MySQLiteHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase database) {
    database.execSQL(DATABASE_CREATE);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    Log.w(MySQLiteHelper.class.getName(),
        "Upgrading database from version " + oldVersion + " to "
            + newVersion + ", which will destroy all old data");
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCHOOL);
    onCreate(db);
  }

} 
