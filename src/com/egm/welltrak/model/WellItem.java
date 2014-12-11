package com.egm.welltrak.model;

public class WellItem
{
	private long id;
	private String name;
	private String pwsid;
	private String location;
	
	public WellItem()
	{
	}
	
	public WellItem(String name, String pwsid, String location)
	{
		this.name = name;
		this.pwsid = pwsid;
		this.location = location;
	}
	
	public WellItem(long id, String name, String pwsid, String location)
	{
		this.id = id;
		this.name = name;
		this.pwsid = pwsid;
		this.location = location;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	public void setId(long id)
	{
		this.id = (int)id;
	}
	
	public long getId()
	{
		return id;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setPwsid(String pwsid)
	{
		this.pwsid = pwsid;
	}

	public String getPwsid()
	{
		return pwsid;
	}


	public void setLocation(String location)
	{
		this.location = location;
	}

	public String getLocation()
	{
		return location;
	}

	@Override
	public String toString()
	{
		return new StringBuilder("id=")
		.append(getId())
		.append(",name=")
		.append(getName())
		.append(",pwsid=")
		.append(getPwsid())
		.append(",location=")
		.append(getLocation())
		.toString();
	}
}
