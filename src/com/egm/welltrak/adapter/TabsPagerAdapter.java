package com.egm.welltrak.adapter;

import com.egm.util.L;
import com.egm.welltrak.Constants;
import com.egm.welltrak.VisitListFragment;
import com.egm.welltrak.WellDetailsFragment;
import com.egm.welltrak.VisitDetailsFragment;
import com.egm.welltrak.WellListFragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {
	
	public TabsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {
		switch (index) {
		case Constants.Tabs.WELL_LIST:
			// Well List fragment activity
			return new WellListFragment();
		case Constants.Tabs.WELL_DETAILS:
			// Well Details fragment activity
			return new WellDetailsFragment();
		case Constants.Tabs.VISIT_DETAILS:
			// Visit Details fragment activity
			return new VisitDetailsFragment();
		case Constants.Tabs.VISIT_LIST:
			// Visit List fragment activity
			return new VisitListFragment();
		}
		return null;
	}

	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return Constants.Tabs.COUNT;
	}
}
