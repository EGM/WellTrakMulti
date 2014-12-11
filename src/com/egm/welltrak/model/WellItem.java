package com.egm.welltrak.model;

public class WellItem implements Item
{
	
	private int _id;
	private String pwsid;
	private String name;
	private String address;
	
	public void WellItem() 
	{
		//Empty constructor
	}
	
	public void WellItem(int id, String pwsid, String name, String address) 
	{
		this._id = id;
		this.pwsid = pwsid;
		this.name = name;
		this.address = address;
	}
	
	public void WellItem(String pwsid, String name, String address) 
	{
		this.pwsid = pwsid;
		this.name = name;
		this.address = address;
	}
	
	public void setId(int id)
	{
		this._id = id;
	}

	public int getId()
	{
		return _id;
	}

	public void setPwsid(String pwsid)
	{
		this.pwsid = pwsid;
	}

	public String getPwsid()
	{
		return pwsid;
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
