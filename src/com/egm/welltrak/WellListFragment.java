package com.egm.welltrak;

import com.egm.util.L;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.ListView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class WellListFragment extends Fragment {

	private Button btnNewWell;
	private ListView lvWellList;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.well_list_fragment, container, false);
		
		btnNewWell =   (Button) rootView.findViewById(R.id.wl_btnNewWell);
		lvWellList = (ListView) rootView.findViewById(R.id.wl_lvWellList);
		
		return rootView;
	}
}
