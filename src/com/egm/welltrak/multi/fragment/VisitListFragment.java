package com.egm.welltrak.multi.fragment;

import android.support.v4.app.ListFragment;
import android.os.*;
import android.widget.ListView;

import com.egm.util.L;

public class VisitListFragment extends ListFragment
{
	private ListView lvVisitList;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		L.i("fragment created");
	}
}
