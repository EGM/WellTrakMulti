package com.egm.welltrak.dao;

import com.egm.util.L;
import com.egm.welltrak.model.*;
import java.util.*;
import java.sql.*;
import android.content.ContentValues;
import android.database.sqlite.*;
import android.database.*;

public class WellDao
{
	public static final String TABLE_NAME = "wells";
	private SQLiteDatabase db;
	
	public WellDao(SQLiteDatabase db)
	{
		this.db = db;
	}
	
	public class Columns	
	{
		protected static final String ID = "id";
		protected static final String PWSID = "pwsid";
		protected static final String NAME = "name";
		protected static final String ADDRESS = "address";
		protected static final String[] ALL = {"*"};
	}
	
	protected class Sql
	{
		protected static final String CREATE_TABLE =
			new StringBuilder()
			.append("CREATE TABLE ").append(TABLE_NAME).append(" (")
			.append(Columns.ID).append(" INTEGER PRIMARY KEY AUTOINCREMENT, ")
			.append(Columns.PWSID).append(" CHAR, ")
			.append(Columns.NAME).append(" CHAR NOT NULL UNIQUE, ")
			.append(Columns.ADDRESS).append(" CHAR )")
			.toString();
			
		protected static final String DROP_TABLE =
			new StringBuilder()
			.append("DROP TABLE ")
			.append(TABLE_NAME)
			.append(" IF EXISTS")
			.toString();
	}

	protected static void onCreate(SQLiteDatabase db)
	{
		db.execSQL(Sql.CREATE_TABLE);
	}

	public static void onUpgrade(SQLiteDatabase db)
	{
		db.execSQL(Sql.DROP_TABLE);
		db.execSQL(Sql.CREATE_TABLE);
	}

	public void add(WellItem item)
	{	
		ContentValues values = new ContentValues();
		values.put(Columns.PWSID, item.getPwsid());
		values.put(Columns.NAME, item.getName());
		values.put(Columns.ADDRESS, item.getAddress());
		db.insert(TABLE_NAME, null, values);
	}

	public List<WellItem> getAll()
	{
		// TODO: Implement this method
		return null;
	}

	public WellItem getItem(int index)
	{
		Cursor cursor = db.query(TABLE_NAME, Columns.ALL, Columns.ID + "=?",
			new String[] { String.valueOf(index) }, null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();

		WellItem item = new WellItem();
		item.setPwsid(cursor.getString(1));
		item.setName(cursor.getString(2));
		item.setAddress(cursor.getString(3));
		return item;
	}

	public void delete(int index)
	{
		db.delete(TABLE_NAME, Columns.ID+"=?", new String[] {String.valueOf(index)});
	}

	public void update(WellItem item)
	{
		ContentValues values = new ContentValues();
		values.put(Columns.PWSID, item.getPwsid());
		values.put(Columns.NAME, item.getName());
		values.put(Columns.ADDRESS, item.getAddress());
		db.update(TABLE_NAME, values, Columns.ID, 
			new String[] {String.valueOf(item.getId())});		
	}
	
	public int getCount()	
	{
		Cursor cursor = db.query(TABLE_NAME, Columns.ALL, null, null, null, null, null, null);
		return cursor.getCount();
	}	
}
