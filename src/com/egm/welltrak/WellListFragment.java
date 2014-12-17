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
import android.widget.AbsListView.MultiChoiceModeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.*;
import android.widget.*;
import android.view.*;
import android.view.ContextMenu.*;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import java.util.*;

public class WellListFragment extends Fragment {
	private Button btnNewWell;
	private ListView lvWellList;
	private WellsAdapter adapter;
	View rootView;
	private WellItem item = new WellItem();
	private WellDao dao = new WellDao();
	String[] Countries;

	public WellItem getWellItem() {
		return item;
	} 
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.well_list_fragment, container, false);

		btnNewWell =   (Button) rootView.findViewById(R.id.wl_btnNewWell);
		lvWellList = (ListView) rootView.findViewById(R.id.wl_lvWellList);
		addListenerOnButton();
		
		adapter = new WellsAdapter(getActivity(), dao.getAll());
		lvWellList.setAdapter(adapter);
		addListenerOnListView();
		registerForContextMenu(lvWellList);
		
		try {
			L.i("count="+dao.getCount());
			item = dao.get(1);
			L.d(item.toString());
		} catch (Exception e) {
			L.e("err", e);
		}
		return rootView;
	}
	
	private void addListenerOnButton() {
		btnNewWell.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent myIntent = new Intent(getActivity(), NewWellActivity.class);
				getActivity().startActivity(myIntent);
				refresh();
			}
		});
	}
	
	private void addListenerOnListView() {
		lvWellList.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
									int position, long id) {
				//TODO: Do something useful
				L.d("position: "+position+", id: "+id);
				item = dao.get(position+1);
				L.d(item.getName());
			}
		});
	
//		
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
	{
		// TODO: Implement this method
		super.onCreateContextMenu(menu, v, menuInfo);
		AdapterContextMenuInfo aInfo = (AdapterContextMenuInfo) menuInfo;
		
		WellItem wItem = (WellItem) adapter.getItem(aInfo.position); 
		menu.setHeaderTitle("Options for " + wItem.getName()); 
		menu.add(1, 1, 1, "Details"); 
		menu.add(1, 2, 2, "Delete");
	}
	
	@Override 
	public boolean onContextItemSelected(MenuItem mItem) { 
		int itemId = mItem.getItemId(); 
		String switchString = "";
		switch (itemId) {
			case 1: switchString = "details";
				break;
			case 2: switchString = "delete";
				break;
		}
		// Implements our logic 
		Toast.makeText(getActivity(), "Item id ["+itemId+"] = "+switchString, Toast.LENGTH_SHORT).show(); 
		return true; 
	}
	
	public void refresh() {
		adapter.notifyDataSetChanged();
	}

	@Override
	public void onResume() {
		super.onResume();
		refresh();
	}
}
