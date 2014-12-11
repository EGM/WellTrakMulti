package com.egm.welltrak.dao;

import com.egm.welltrak.MainActivity;

public enum DatabaseManager
{
	INSTANCE;
	private DatabaseHelper helper = new DatabaseHelper(MainActivity.getContext());
	
	public DatabaseHelper getInstance() 
	{
		// Perform operation here 
		return null;
	}
}
