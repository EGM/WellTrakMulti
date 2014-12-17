package com.egm.welltrak;

import com.egm.util.L;
import com.egm.welltrak.adapter.TabsPagerAdapter;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.egm.welltrak.model.Item_Tests;
import com.egm.welltrak.dao.*;

public class MainActivity extends FragmentActivity implements
		ActionBar.TabListener {

	private ViewPager viewPager;
	private TabsPagerAdapter mAdapter;
	private ActionBar actionBar;
	// Tab titles
	private String[] tabs = { "Wells", "WELL_NAME", "VISIT_DATE", "Visits" };

	@Override 
	protected void onCreate(Bundle savedInstanceState) {
	try {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Initilization
		DatabaseManager.INSTANCE.init(this);
//		Item_Tests.run();	
		viewPager = (ViewPager) findViewById(R.id.pager);
		actionBar = getActionBar();
		mAdapter = new TabsPagerAdapter(getSupportFragmentManager());

		viewPager.setAdapter(mAdapter);
		actionBar.setHomeButtonEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);		

		// Adding Tabs
		for (String tab_name : tabs) {
			actionBar.addTab(actionBar.newTab().setText(tab_name)
					.setTabListener(this));
		}
		/**
		 * on swiping the viewpager make respective tab selected
		 * */
		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				// on changing the page
				// make respected tab selected
				actionBar.setSelectedNavigationItem(position);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				//L.d("arg 0: "+arg0+", 1: "+arg1+", 2: "+arg2);
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				//L.d("arg 0: "+arg0);
			}
		});
		} catch (Exception e) {
			L.e("CRASH!", e);
		}
			
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// on tab selected
		// show respected fragment view
		viewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
	}

}
