package com.egm.welltrak.dao;

import java.util.List;
import android.database.sqlite.SQLiteDatabase;
import com.egm.welltrak.model.Item;

public interface BaseDao
{	
	public void add(Item item);
	public void delete(int index);
	public List<Item> getAll();
	public Item getItem(int index);
	public void onCreate(SQLiteDatabase db);
	public void onUpgrade(SQLiteDatabase db);
	public void update(Item item);
}
