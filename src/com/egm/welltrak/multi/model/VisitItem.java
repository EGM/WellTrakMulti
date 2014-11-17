package com.egm.welltrak.multi.model;

import java.util.Date;

public class VisitItem
{
	private int _id;
	private Date date;
	private Integer flowMeter;
	private Float entryChlorine;
	private Float remoteChlorine;
	
	public VisitItem()
	{
		//Default Constructor
	}
	
	public VisitItem(int id, Date date, Integer flowMeter,
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
		_id = id;
	}

	public int getId()
	{
		return _id;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public Date getDate()
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
	}}
