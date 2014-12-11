package com.egm.welltrak.dao;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.*;
import android.database.sqlite.*;

public class DatabaseHelper extends SQLiteOpenHelper
{
	private static String DATABASE_NAME = "wellvisits.sqlite";
	private static int DATABASE_VERSION = 1;
	
	DatabaseHelper(Context context)
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db)
	{
		VisitDao.onCreate(db);
		WellDao.onCreate(db);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer)
	{
		VisitDao.onUpgrade(getWritableDatabase());
		WellDao.onUpgrade(getWritableDatabase());
	}
}
