package com.egm.welltrak.multi;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.TabListener;
import android.os.*;
import android.view.*;
import android.widget.*;

import com.egm.util.L;
import android.support.v4.app.*;
import android.support.v7.app.ActionBar.*;

public class MainActivity extends FragmentActivity
	implements ActionBar.TabListener
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		L.i("Success");
		L.heap();
    }

	@Override
	public void onTabSelected(ActionBar.Tab p1, FragmentTransaction p2)
	{
		// TODO: Implement this method
	}

	@Override
	public void onTabUnselected(ActionBar.Tab p1, FragmentTransaction p2)
	{
		// TODO: Implement this method
	}

	@Override
	public void onTabReselected(ActionBar.Tab p1, FragmentTransaction p2)
	{
		// TODO: Implement this method
	}
	
}
