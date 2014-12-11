package com.egm.welltrak.dao;

import com.egm.util.L;
import com.egm.welltrak.model.WellItem;

public class WellDaoTest
{
	public static void runTests(WellDao wellDao)	
	{
		for(int i=1;i<wellDao.getCount();i++)	
		{
			wellDao.delete(i);
		}
		WellItem item = new WellItem();
		L.d("Adding Gibsonia");
		item.setName("Gibsonia");
		wellDao.add(item);
		L.d("Adding Lk Gibson #1");
		item.setName("Lk Gibson #1");
		wellDao.add(item);
		L.d("Adding Lk Gibson #2");
		item.setName("Lk Gibson #2");
		wellDao.add(item);
		L.d("Adding Village");
		item.setName("Village");
		wellDao.add(item);
		L.d(new StringBuilder("Well records in database = ")
			.append(wellDao.getCount()).toString());
		for(int i=1;i<wellDao.getCount();i++)	
		{
			L.d(new StringBuilder("Well #").append(i).append(" = ")
				.append(wellDao.getItem(i).getName()).toString());
		}
		
	}
	
}
