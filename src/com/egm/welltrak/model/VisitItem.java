package com.egm.welltrak.model;
import java.util.*;

public class VisitItem
{
	long id;
	long wellId;
	Date date;
	int fm;
	String frcPoe;
	String frcPou;
	String ph;

	public VisitItem()
	{
	}
	
	public VisitItem(long id, long wellId, Date date, int fm, 
		String frcPoe, String frcPou, String ph)
	{
		this.id = id;
		this.wellId = wellId;
		this.date = date;
		this.fm = fm;
		this.frcPoe = frcPoe;
		this.frcPou = frcPou;
		this.ph = ph;
	}
	public VisitItem(long wellId, Date date, int fm, 
		String frcPoe, String frcPou, String ph)
	{
		this.wellId = wellId;
		this.date = date;
		this.fm = fm;
		this.frcPoe = frcPoe;
		this.frcPou = frcPou;
		this.ph = ph;
	}

	public void setFm(int fm)
	{
		this.fm = fm;
	}

	public int getFm()
	{
		return fm;
	}
	
	public void setId(long id)
	{
		this.id = id;
	}

	public long getId()
	{
		return id;
	}

	public void setWellId(long wellId)
	{
		this.wellId = wellId;
	}

	public long getWellId()
	{
		return wellId;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public Date getDate()
	{
		return date;
	}

	public void setFrcPoe(String frcPoe)
	{
		this.frcPoe = frcPoe;
	}

	public String getFrcPoe()
	{
		return frcPoe;
	}

	public void setFrcPou(String frcPou)
	{
		this.frcPou = frcPou;
	}

	public String getFrcPou()
	{
		return frcPou;
	}


	public void setPh(String ph)
	{
		this.ph = ph;
	}

	public String getPh()
	{
		return ph;
	}

	@Override
	public String toString()
	{
		return new StringBuilder("id=")
		.append(getId())
		.append(",well id=")
		.append(getWellId())
		.append(",date=")
		.append(getDate().toString())
		.append(",fm=")
		.append(getFm())
		.append(",frc poe=")
		.append(getFrcPoe())
		.append(",frc pou=")
		.append(getFrcPou())
		.append(",ph=")
		.append(getPh())
		.toString();
	}
}
