package com.egm.welltrak;

import com.egm.util.L;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class VisitListFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
				
		View rootView = inflater.inflate(R.layout.visit_list_fragment, container, false);
		
		return rootView;
	}
}
