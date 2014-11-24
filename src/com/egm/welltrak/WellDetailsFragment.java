package com.egm.welltrak;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;

public class WellDetailsFragment extends Fragment {
	
	private Button   btnUpdateWell;
	private EditText etName;
	private EditText etAddress;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.well_details_fragment, container, false);
		
		etName =    (EditText) rootView.findViewById(R.id.wd_etName);
		etAddress = (EditText) rootView.findViewById(R.id.wd_etAddress);
		btnUpdateWell = (Button) rootView.findViewById(R.id.wd_btnUpdateWell);
		
		return rootView;
	}
}
