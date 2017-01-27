package com.example.rndroid.minorproject2_database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rndroid on 4/1/17.
 */

public class MyDatabase {
    SQLiteDatabase sqLiteDatabase;
    MyHelper myHelper;

    public MyDatabase(Context context){
        myHelper = new MyHelper(context, "mydatabase.db", null, 1);
    }

    public void openDB(){
        sqLiteDatabase = myHelper.getWritableDatabase();
    }

    public void openReadableDB(){
        sqLiteDatabase = myHelper.getReadableDatabase();
    }

    public void closeDB(){
        sqLiteDatabase.close();
    }
    public void insert(String no, String name, String mobile, String email, String subject, String description, String date){
        ContentValues values = new ContentValues();
        values.put("sno", no);
        values.put("sname", name.toUpperCase());
        values.put("smobile", mobile);
        values.put("semail", email);
        values.put("ssubject", subject.toUpperCase());
        values.put("sdescription", description.toUpperCase());
        values.put("date",date);
        sqLiteDatabase.insert("student", null, values);
    }

    public Cursor getStudentDetails(){
        Cursor cursor = null;
        cursor = sqLiteDatabase.query("student",null, null, null, null, null, null);
        return cursor;
    }

    public Cursor getStudentByName(String name){
        Cursor cursor = null;
        String name1 = name;
        cursor = sqLiteDatabase.query("student",null, "sname=?", new String[]{name1}, null ,null, null);
        return cursor;
    }

    public Cursor getStudentByMobile(String mobile){
        Cursor cursor = null;
        cursor = sqLiteDatabase.query("student",null, "smobile=?", new String[]{mobile}, null, null, null);
        return cursor;
    }
    private class MyHelper extends SQLiteOpenHelper{

        public MyHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("create table student (_id integer primary key, sno text, sname text, smobile text, semail text, ssubject text, sdescription text, date text);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }
}
