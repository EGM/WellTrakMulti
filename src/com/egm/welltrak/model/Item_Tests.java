package com.egm.welltrak.model;
import com.egm.util.*;
import com.egm.welltrak.model.*;
import com.egm.welltrak.dao.*;
import java.util.*;

public class Item_Tests
{
	public static void run()
	{
		try
		{
			WellDao.onUpgrade(DatabaseManager.INSTANCE.getDatabase());
			
			VisitItem v = new VisitItem();
			v.setDate("11 Dec 2014");
			Test.assertEquals("11 Dec 2014", v.getDateString(), "1");

			WellDao dao = new WellDao();
			WellItem item = new WellItem();

			item.setName("Well 1");
			dao.add(item);

			item.setName("Well 2");
			dao.add(item);

			item.setName("Well 3");
			dao.add(item);

			ArrayList<WellItem> items = dao.getAll();

			Test.assertEquals(3, items.size(), "2");
			
			VisitDao.onUpgrade(DatabaseManager.INSTANCE.getDatabase());
			VisitDao vdao = new VisitDao();
			
			v.setWellId(2);
			v.setFm(123456);
			v.setId(vdao.add(v));
			VisitItem a = vdao.get(v.getId());
			Test.assertEquals(1, vdao.getCount(), "3");
			L.d("v: "+v.toString());
			L.d("a: "+a.toString());
			Test.assertEquals(v, a, "4");
		}
		catch (Exception e)
		{
			L.e("broke", e);
		}
	}
}
