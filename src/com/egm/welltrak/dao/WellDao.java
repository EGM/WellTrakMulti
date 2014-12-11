package com.egm.welltrak.dao;

import com.egm.util.L;
import com.egm.welltrak.model.*;
import android.database.sqlite.*;
import java.util.*;
import android.content.*;
import android.database.*;

public class WellDao
{
	public static final String TABLE_NAME = "wells";
	
	public static void onCreate(SQLiteDatabase db)
	{
		L.i("Creating table "+TABLE_NAME);
		String sql = new StringBuilder()
			.append("CREATE TABLE ").append(TABLE_NAME)
			.append(" ( ").append(WellColumns._ID)
			.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ")
			.append(WellColumns.NAME)
			.append(" TEXT NOT NULL UNIQUE, ")
			.append(WellColumns.PWSID).append(" TEXT, ")
			.append(WellColumns.LOCATION).append(" TEXT )")
			.toString();
		db.execSQL(sql);
	}
	
	public static void onUpgrade(SQLiteDatabase db)
	{
		L.i("Upgrading table "+TABLE_NAME);
		String sql = new StringBuilder("DROP TABLE IF EXISTS ")
			.append(TABLE_NAME).toString();
		db.execSQL(sql);
		onCreate(db);
	}
	
	public long add(WellItem item)
	{
		ContentValues values = new ContentValues();
		values.put(WellColumns.NAME.toString(), item.getName());
		values.put(WellColumns.PWSID.toString(), item.getPwsid());
		values.put(WellColumns.LOCATION.toString(), item.getLocation());
		return (DatabaseManager.INSTANCE.getDatabase().insert(TABLE_NAME, null, values)); 
	}
	
	public void delete(WellItem item)
	{
		DatabaseManager.INSTANCE.getDatabase().delete(TABLE_NAME, 
			WellColumns._ID.toString()+" = ? ", new String[] { String.valueOf(item.getId()) });
	}
	
	public WellItem get(long id)
	{
		WellItem item = new WellItem();
		Cursor cursor = DatabaseManager.INSTANCE.getDatabase()
			.query(TABLE_NAME, new String[]{ "*" }, WellColumns._ID.toString()+"=?", 
				new String[]{ String.valueOf(id) }, null, null, null);
	
		if(cursor.moveToFirst())
			{
				item.setId(cursor.getInt(WellColumns._ID.getValue()));
				item.setName(cursor.getString(WellColumns.NAME.getValue()));
				item.setPwsid(cursor.getString(WellColumns.PWSID.getValue()));
				item.setLocation(cursor.getString(WellColumns.LOCATION.getValue()));
			}
		cursor.close();
		return item;
	}
	
	public WellItem get(String name)
	{
		WellItem item = new WellItem();
		Cursor cursor = DatabaseManager.INSTANCE.getDatabase()
			.query(TABLE_NAME, new String[]{ "*" }, WellColumns.NAME.toString()+"=?", 
				   new String[]{ name }, null, null, null);
		if(cursor.moveToFirst())
		{
			item.setId(cursor.getInt(WellColumns._ID.getValue()));
			item.setName(cursor.getString(WellColumns.NAME.getValue()));
			item.setPwsid(cursor.getString(WellColumns.PWSID.getValue()));
			item.setLocation(cursor.getString(WellColumns.LOCATION.getValue()));
		}
		cursor.close();
		return item;
	}
	
	public List<WellItem> getAll()
	{ 
		//todo 
		return null;
	}
	
	public int getCount()
	{
		int count = 0;
		Cursor cursor = DatabaseManager.INSTANCE.getDatabase()
			.query(TABLE_NAME, null, null, null, null, null, null);
		count = cursor.getCount();
		cursor.close();
		return count;
	}
	
	public void update(WellItem item)
	{
		//todo
		ContentValues values = new ContentValues();
		values.put(WellColumns.NAME.toString(), item.getName());
		values.put(WellColumns.PWSID.toString(), item.getPwsid());
		values.put(WellColumns.LOCATION.toString(), item.getLocation());
		DatabaseManager.INSTANCE.getDatabase()
			.update(TABLE_NAME, values, WellColumns._ID+"=", 
				new String[] { String.valueOf(item.getId()) });
	}
	
}
