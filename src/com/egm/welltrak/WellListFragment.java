package com.egm.welltrak;

import com.egm.util.L;
import com.egm.welltrak.MainActivity;
import com.egm.welltrak.adapter.WellsAdapter;
import com.egm.welltrak.dao.WellDao;
import com.egm.welltrak.model.WellItem;
import java.util.ArrayList;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class WellListFragment extends Fragment
{
	private Button btnNewWell;
	private ListView lvWellList;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState)
	{
		View rootView = inflater.inflate(R.layout.well_list_fragment, container, false);

		btnNewWell =   (Button) rootView.findViewById(R.id.wl_btnNewWell);
		lvWellList = (ListView) rootView.findViewById(R.id.wl_lvWellList);
		addListenerOnButton();
		
		WellDao dao = new WellDao();
		WellsAdapter adapter = new WellsAdapter(getActivity(), dao.getAll());
		lvWellList.setAdapter(adapter);
		
		return rootView;
	}

	private void addListenerOnButton()
	{
		btnNewWell.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0)
				{
					Intent myIntent = new Intent(getActivity(), NewWellActivity.class);
					getActivity().startActivity(myIntent);
				}
			});
	}
}
