package com.egm.welltrak.dao;

import com.egm.welltrak.MainActivity;
import android.database.sqlite.*;
import android.content.*;

public enum DatabaseManager
{
	INSTANCE;
	private DatabaseHelper helper;
	public void init(Context context)
	{
		helper = new DatabaseHelper(context);
	}
	public SQLiteDatabase getDatabase()
	{
		return helper.getWritableDatabase();
	}
}
