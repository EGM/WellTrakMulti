package com.egm.welltrak.multi.fragment;

import android.support.v4.app.Fragment;
import android.os.*;
import android.widget.Button;
import android.widget.EditText;

import com.egm.util.L;

public class WellDetailsFragment extends Fragment
{
	private EditText etName;
	private EditText etAddress;
	private Button btnUpdateWell;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		L.i("fragment created");
	}
}
