package  com.akshaya.ipatra.datasource;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Comment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class SchoolsDataSource {

  // Database fields
  private SQLiteDatabase database;
  private MySQLiteHelper dbHelper;
  private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
      MySQLiteHelper.COLUMN1 ,  MySQLiteHelper.COLUMN2 };

  public SchoolsDataSource(Context context) {
    dbHelper = new MySQLiteHelper(context);
  }

  public void open() throws SQLException {
    database = dbHelper.getWritableDatabase();
  }

  public void close() {
    dbHelper.close();
  }

  public void insertIntent(int yesterdayActual , int tomorrowNeed , String schoolId , String status) {
    ContentValues values = new ContentValues();
    values.put(MySQLiteHelper.COLUMN1, yesterdayActual);
    values.put(MySQLiteHelper.COLUMN2, tomorrowNeed);
    values.put(MySQLiteHelper.COLUMN3, schoolId);
    values.put(MySQLiteHelper.COLUMN4, status);
    
    long insertId = database.insert(MySQLiteHelper.TABLE_SCHOOL, null,
        values);
    
    
//    Cursor cursor = database.query(MySQLiteHelper.TABLE_SCHOOL,
//        allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null,
//        null, null, null);
//    cursor.moveToFirst();
//    Comment newComment = cursorToComment(cursor);
//    cursor.close();
//    return newComment;
  }

//  public void deleteComment(Comment comment) {
//    long id = comment.getId();
//    System.out.println("Comment deleted with id: " + id);
//    database.delete(MySQLiteHelper.TABLE_SCHOOL, MySQLiteHelper.COLUMN_ID
//        + " = " + id, null);
//  }

//  public List<Comment> getAllComments() {
//    List<Comment> comments = new ArrayList<Comment>();
//
//    Cursor cursor = database.query(MySQLiteHelper.TABLE_SCHOOL,
//        allColumns, null, null, null, null, null);
//
//    cursor.moveToFirst();
//    while (!cursor.isAfterLast()) {
//      Comment comment = cursorToComment(cursor);
//      comments.add(comment);
//      cursor.moveToNext();
//    }
//    // make sure to close the cursor
//    cursor.close();
//    return comments;
//  }

//  private Comment cursorToSchool(Cursor cursor) {
//    Comment comment = new Comment();
//    comment.setId(cursor.getLong(0));
//    comment.setComment(cursor.getString(1));
//    return comment;
//  }
} 

