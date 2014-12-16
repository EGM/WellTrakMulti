package com.egm.welltrak;

import com.egm.util.L;
import com.egm.welltrak.model.WellItem;
import com.egm.welltrak.dao.WellDao;
import android.app.Activity;
import android.os.*;
import android.widget.*;
import android.view.View;
import android.view.View.OnClickListener;

public class NewWellActivity extends Activity
{
	private Button btnOk;
	private Button btnCancel;
	private EditText etName;
	private EditText etPwsid;
	private EditText etLocation;
	private WellItem item;
	private WellDao dao;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_well);

		btnOk = (Button) findViewById(R.id.nw_btnOk);
		btnCancel = (Button) findViewById(R.id.nw_btnCancel);
		etName = (EditText) findViewById(R.id.nw_etName);
		etPwsid = (EditText) findViewById(R.id.nw_etPwsid);
		etLocation = (EditText) findViewById(R.id.nw_etLocation);
		addListenerOnButton();

		item = new WellItem();
		dao = new WellDao();
	}

	private void addListenerOnButton()
	{
		btnOk.setOnClickListener(new OnClickListener() 
			{
				@Override
				public void onClick(View arg0)
				{
					//do something
					L.d("New well 'Ok' clicked");
					item.setName(etName.getText().toString());
					item.setPwsid(etPwsid.getText().toString());
					item.setLocation(etLocation.getText().toString());
					if (item.getName().isEmpty())
					{
						Toast.makeText(NewWellActivity.this, 
									   getString(R.string.name_blank), 
									   Toast.LENGTH_SHORT).show();
					}
					else
					{
						long result = dao.add(item);
						if (result == -1L)
						{
							Toast.makeText(NewWellActivity.this, 
										   getString(R.string.add_fail),
										   Toast.LENGTH_SHORT).show();
						}
						else
						{
							Toast.makeText(NewWellActivity.this, 
										   getString(R.string.add_success), 
										   Toast.LENGTH_SHORT).show();
							finish();
						}
					}
				}
			});

		btnCancel.setOnClickListener(new OnClickListener() 
			{
				@Override
				public void onClick(View arg0)
				{
					//do something
					L.d("New well 'Cancel' clicked");
					finish();
				}
			});
	}
}
