package com.egm.welltrak.dao;

public enum WellColumns
{
	_ID("_id", 0),
	NAME("name", 1),
	PWSID("pwsid", 2),
	LOCATION("location", 3),
	_COUNT("_count", 4);

	private String stringValue;
	private int intValue;
	private WellColumns(String toString, int value) {
		stringValue = toString;
		intValue = value;
	}

	@Override
	public String toString() {
		return stringValue;
	}

	public int getValue() {
		return intValue;
	}
}
