package com.egm.welltrak.model;

import java.sql.Date;
import java.text.*;
import com.egm.util.*;

public class VisitItem {
	private long id;
	private long wellId;
	private Date date;
	private int fm;
	private String frcPoe;
	private String frcPou;
	private String ph;
	
	public VisitItem() {
	}
	
	public VisitItem(long id, long wellId, Date date, int fm, 
		String frcPoe, String frcPou, String ph) {
		setId(id);
		setWellId(wellId);
		setDate(date);
		setFm(fm);
		setFrcPoe(frcPoe);
		setFrcPou(frcPou);
		setPh(ph);
	}
	
	public VisitItem(long id, long wellId, String dateString, int fm, 
					 String frcPoe, String frcPou, String ph) {
		setId(id);
		setWellId(wellId);
		setDate(dateString);
		setFm(fm);
		setFrcPoe(frcPoe);
		setFrcPou(frcPou);
		setPh(ph);
	}
	
	public VisitItem(long wellId, Date date, int fm, 
		String frcPoe, String frcPou, String ph) {
		setWellId(wellId);
		setDate(date);
		setFm(fm);
		setFrcPoe(frcPoe);
		setFrcPou(frcPou);
		setPh(ph);
	}

	public void setFm(int fm) {
		this.fm = fm;
	}

	public int getFm() {
		return fm;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setWellId(long wellId) {
		this.wellId = wellId;
	}

	public long getWellId() {
		return wellId;
	}

	public void setDate(Date date) {
		if (date != null)
			this.date = date;
	}
	
	public void setDate(String dateString) {
		this.date = Date.valueOf(dateString);
	}

	public Date getDate() {
		return date;
	}
	
	public String getDateString() {
		return date.toString();
	}

	public void setFrcPoe(String frcPoe) {
		this.frcPoe = frcPoe;
	}

	public String getFrcPoe() {
		return frcPoe;
	}

	public void setFrcPou(String frcPou) {
		this.frcPou = frcPou;
	}

	public String getFrcPou() {
		return frcPou;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}

	public String getPh() {
		return ph;
	}

	@Override
	public String toString() {
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
