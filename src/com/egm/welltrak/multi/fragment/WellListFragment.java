package com.egm.welltrak.multi.fragment;

import android.support.v4.app.Fragment;
import android.os.*;
import android.widget.ListView;
import android.widget.Button;


import com.egm.util.L;

public class WellListFragment extends Fragment
{
	private Button btnNewWell;
	private ListView lvWellList;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		L.i("fragment created");
	}
}
