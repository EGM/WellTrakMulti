package com.egm.welltrak.dao;

public enum VisitColumns {
	_ID("_id", 0),
	WELL_ID("well_id", 1),
	DATE("date", 2),
	FM("fm", 3),
	FRC_POE("frc_poe", 4),
	FRC_POU("frc_pou", 5),
	PH("ph", 6),
	_COUNT("_count", 7);

	private String stringValue;
	private int intValue;
	private VisitColumns(String toString, int value) {
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
