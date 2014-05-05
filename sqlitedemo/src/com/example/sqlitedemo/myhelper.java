package com.example.sqlitedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class myhelper extends SQLiteOpenHelper {
	
	
	public myhelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	public static int database_version = 1;
	public static String tab1 = "mytable";
	public static String id = "_id";
	public static String name = "name";
	public static String rollno = "rollno";
	private String strQuery = "CREATE TABLE "+tab1+" ( "+id+" INTEGER PRIMARY KEY AUTOINCREMENT,"
			+" "+name+" TEXT, "
			+" "+rollno+" NUMBER)";
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(strQuery);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
		if (oldVersion < newVersion) {
			//
			db.execSQL("DROP IF EXISTS "+tab1);
			//
		}
		
	}
}
