package com.egm.welltrak.model;

import java.util.Calendar;
import android.renderscript.*;

public class VisitItem implements Item
{
	int _id;
	Calendar date;
	Integer flowMeter;
	Float entryChlorine;
	Float remoteChlorine;
	
	public void VisitItem()
	{
		//Default constructor
	}
	
	public void VisitItem(int id, Calendar date)
	{
		this._id = id;
		this.date = date;
	}
	
	public void VisitItem(int id, Calendar date, Integer flowMeter)
	{
		this._id = id;
		this.date = date;
		this.flowMeter = flowMeter;
	}
	
	public void VisitItem(int id, Calendar date, Integer flowMeter,
		Float entryChlorine, Float remoteChlorine)
	{
		this._id = id;
		this.date = date;
		this.flowMeter = flowMeter;
		this.entryChlorine = entryChlorine;
		this.remoteChlorine = remoteChlorine;
	}

	public void setId(int id)
	{
		this._id = id;
	}

	public int getId()
	{
		return _id;
	}

	public void setDate(Calendar date)
	{
		this.date = date;
	}

	public Calendar getDate()
	{
		return date;
	}

	public void setFlowMeter(Integer flowMeter)
	{
		this.flowMeter = flowMeter;
	}

	public Integer getFlowMeter()
	{
		return flowMeter;
	}

	public void setEntryChlorine(Float entryChlorine)
	{
		this.entryChlorine = entryChlorine;
	}

	public Float getEntryChlorine()
	{
		return entryChlorine;
	}


	public void setRemoteChlorine(Float remoteChlorine)
	{
		this.remoteChlorine = remoteChlorine;
	}

	public Float getRemoteChlorine()
	{
		return remoteChlorine;
	}
}
