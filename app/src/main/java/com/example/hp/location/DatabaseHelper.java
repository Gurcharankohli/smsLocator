package com.example.hp.location;



import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "phonedb.db";
    public static final String TABLE_NAME = "Num_table";
    public static final String COL_ID = "ID";
    public static final String COL_NUMBER = "Number";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_NAME + " (" +COL_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +COL_NUMBER+ " TEXT)");
        db.execSQL("insert into "+ TABLE_NAME + "(" +COL_ID+ "," +COL_NUMBER+ ")Values (1,'8708263930')");

    }

    public boolean update(String s) {
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL("UPDATE "+TABLE_NAME+" SET Number = "+"'"+s+"' "+ "WHERE ID = 1");
        return true;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public Cursor getTitleData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select "+COL_ID+", "+COL_NUMBER+" from " + TABLE_NAME, null);
        return res;
    }
 


  

   
}
