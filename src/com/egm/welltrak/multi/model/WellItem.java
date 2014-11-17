package com.egm.welltrak.multi.model;

public class WellItem
{
	private int _id;
	private String name;
	private String address;

	public WellItem()
	{
		//Default Constructor
	}
	
	public WellItem(int id, String name, String address)
	{
		this._id = id;
		this.name = name;
		this.address = address;
	}
	
	public void setId(int id)
	{
		_id = id;
	}

	public int getId()
	{
		return _id;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getAddress()
	{
		return address;
	}
}
