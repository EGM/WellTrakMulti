package com.egm.welltrak.adapter;

import com.egm.welltrak.R;
import android.widget.*;
import android.view.*;
import android.content.*;
import java.util.*;
import com.egm.welltrak.model.*;

public class WellsAdapter extends ArrayAdapter
{
	private final Context context; 
	//private final String[] values;
	ArrayList<WellItem> items;
	
	public WellsAdapter(Context context, ArrayList<WellItem> items) 
	{ 
		super(context, R.layout.well_item, items); 
		this.context = context; 
		this.items = items;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{ 
		LayoutInflater inflater = (LayoutInflater) context 
			.getSystemService(Context.LAYOUT_INFLATER_SERVICE); 
		View rowView = inflater.inflate(R.layout.well_item, parent, false); 
		TextView name = (TextView) rowView.findViewById(R.id.wi_tvName); 
		TextView pwsid = (TextView) rowView.findViewById(R.id.wi_tvPwsid);
		TextView location = (TextView) rowView.findViewById(R.id.wi_tvLocation);
		WellItem item = items.get(position);
		name.setText(item.getName());
		pwsid.setText(item.getPwsid());
		location.setText(item.getLocation());
		
		return rowView; 
	}
}
