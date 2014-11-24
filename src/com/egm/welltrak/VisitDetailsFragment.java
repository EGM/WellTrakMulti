package com.egm.welltrak;

import com.egm.util.L;
import com.egm.welltrak.Constants;

import java.util.Calendar; 
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.EditText;

public class VisitDetailsFragment extends Fragment {
	
	private DatePicker dpDate;
	private EditText etFlowMeter;
	private EditText etEntryChlorine;
	private EditText etRemoteChlorine;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.visit_details_fragment, container, false);
		
		dpDate = (DatePicker) rootView.findViewById(R.id.vd_dpDate);
		etFlowMeter = (EditText) rootView.findViewById(R.id.vd_etFlowMeter);
		etEntryChlorine = (EditText) rootView.findViewById(R.id.vd_etEntryChlorine);
		etRemoteChlorine = (EditText) rootView.findViewById(R.id.vd_etRemoteChlorine);
		
        //Prevent calendar from showing future dates
		dpDate.setMaxDate(Calendar.getInstance().getTimeInMillis());
		//Set tab title to current date
		setTabTitle();
		dpDate.init(dpDate.getYear(),dpDate.getMonth(), dpDate.getDayOfMonth(),
			new OnDateChangedListener() {
   
		 	@Override
			public void onDateChanged(DatePicker arg0, int arg1, int arg2, int arg3) {
    			// TODO Auto-generated method stub
				setTabTitle();
   			}
  		});
		
		return rootView;
	}
	
	public void setTabTitle() {
		getActivity().getActionBar().getTabAt(Constants.Tabs.VISIT_DETAILS).setText(
			new StringBuilder("")
			.append(dpDate.getYear()).append("-")
			.append(dpDate.getMonth()+1).append("-")
			.append(dpDate.getDayOfMonth()).toString());
	}
}
