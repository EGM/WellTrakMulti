package com.egm.welltrak.dao;

import com.egm.welltrak.model.VisitItem;
import com.egm.util.L;
import com.egm.util.Util;
import android.database.sqlite.*;
import java.util.*;
import android.content.*;
import android.database.*;

public class VisitDao
{
	public static final String TABLE_NAME = "visits";

	public static void onCreate(SQLiteDatabase db)
	{
		L.i("Creating table "+TABLE_NAME);
		String sql = new StringBuilder()
			.append("CREATE TABLE ").append(TABLE_NAME)
			.append(" ( ").append(VisitColumns._ID)
			.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ")
			.append(VisitColumns.WELL_ID)
			.append(" INTEGER NOT NULL REFERENCES ")
			.append(WellDao.TABLE_NAME).append(" (")
			.append(WellColumns._ID).append("), ")
			.append(VisitColumns.DATE)
			.append(" DATETIME NOT NULL, ")
			.append(VisitColumns.FM)
			.append(" INTEGER NOT NULL, ")
			.append(VisitColumns.FRC_POE)
			.append(" TEXT, ")
			.append(VisitColumns.FRC_POU)
			.append(" TEXT, ")
			.append(VisitColumns.PH)
			.append(" TEXT )")
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
	
	public long add(VisitItem item)
	{ 
		L.d("Adding item: "+item.toString());
		L.d("adding date = "+item.getDate().toLocaleString());
		ContentValues values = new ContentValues();
		values.put(VisitColumns.WELL_ID.toString(), item.getWellId());
		values.put(VisitColumns.DATE.toString(), Util.toString(item.getDate()));
		values.put(VisitColumns.FM.toString(), item.getFm());
		values.put(VisitColumns.FRC_POE.toString(), item.getFrcPoe());
		values.put(VisitColumns.FRC_POU.toString(), item.getFrcPou());
		values.put(VisitColumns.PH.toString(), item.getPh());
		return (DatabaseManager.INSTANCE.getDatabase().insert(TABLE_NAME, null, values));
	}
	
	public void delete(VisitItem item)
	{
		L.d("Deleting item: "+item.toString());
		DatabaseManager.INSTANCE.getDatabase().delete(TABLE_NAME, 
			VisitColumns._ID.toString()+" = ? ", new String[] { String.valueOf(item.getId()) });
	}
	
	public VisitItem get(long id)
	{ 
		L.d("Getting item for id "+id);
		VisitItem item = new VisitItem();
		Cursor cursor = DatabaseManager.INSTANCE.getDatabase()
			.query(TABLE_NAME, new String[]{ "*" }, VisitColumns._ID.toString()+"=?", 
				   new String[]{ String.valueOf(id) }, null, null, null);
		
		if(cursor.moveToFirst())
		{
			item.setId(cursor.getInt(VisitColumns._ID.getValue()));
			item.setWellId(cursor.getInt(VisitColumns.WELL_ID.getValue()));
			item.setDate(Util.toDate(cursor.getString(VisitColumns.DATE.getValue())));
			item.setFrcPoe(cursor.getString(VisitColumns.FRC_POE.getValue()));
			item.setFrcPou(cursor.getString(VisitColumns.FRC_POU.getValue()));
			item.setPh(cursor.getString(VisitColumns.PH.getValue()));
		}
		cursor.close();
		return item;
	}
	
	public VisitItem get(long wellId, Date date){ return null; }
	
	public List<VisitItem> getAll(){ return null; }
	
	public int getCount()
	{ 
		int count = 0;
		Cursor cursor = DatabaseManager.INSTANCE.getDatabase()
			.query(TABLE_NAME, null, null, null, null, null, null);
		count = cursor.getCount();
		cursor.close();
		return count; 
	}
	
	public void update(VisitItem item)
	{
		ContentValues values = new ContentValues();
		values.put(VisitColumns.WELL_ID.toString(), item.getWellId());
		values.put(VisitColumns.DATE.toString(), item.getDate().toString());
		values.put(VisitColumns.FM.toString(), item.getFm());
		values.put(VisitColumns.FRC_POE.toString(), item.getFrcPoe());
		values.put(VisitColumns.FRC_POU.toString(), item.getFrcPou());
		values.put(VisitColumns.PH.toString(), item.getPh());
		DatabaseManager.INSTANCE.getDatabase()
			.update(TABLE_NAME, values, WellColumns._ID+"=", 
					new String[] { String.valueOf(item.getId()) });
	}
}
