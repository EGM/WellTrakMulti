package com.egm.welltrak.multi.fragment;

import android.support.v4.app.Fragment;
import android.os.*;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.egm.util.L;

public class VisitDetailsFragment extends Fragment
{
	private DatePicker dpDate;
	private EditText etFlowMeter;
	private EditText etEntryChlorine;
	private EditText etRemoteChlorine;
	private Button btnUpdateVisit;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		L.i("fragment created");
	}
}
