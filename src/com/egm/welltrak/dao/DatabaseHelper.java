package com.egm.welltrak.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper
{
	private static final String DATABASE_NAME = "welltrak.sqlite";
	private static final int DATABASE_VERSION = 1;
	
	public DatabaseHelper(Context context)
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
		
	@Override
	public void onCreate(SQLiteDatabase db)
	{
		WellDao.onCreate(db);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		WellDao.onUpgrade(db);
	}
	
	public WellDao getWellDao()	
	{
		return new WellDao(getWritableDatabase());
	}
	
}
