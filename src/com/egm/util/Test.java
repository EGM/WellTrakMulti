package com.egm.util;
import com.egm.util.L;
import com.egm.welltrak.model.*;
import java.nio.*;
import junit.framework.*;

public class Test
{
	public static void assertEquals(VisitItem expected, VisitItem actual) {
		assertEquals(expected, actual, null);
	}

	public static void assertEquals(VisitItem expected, VisitItem actual, String msg) {
		if ((expected.getId()==actual.getId()) 
			&& (expected.getWellId()==actual.getWellId())
			&& (expected.getDate().equals(actual.getDate()) 
			&& (expected.getFm()==actual.getFm())
			&& (expected.getFrcPoe().equals(actual.getFrcPoe())
			&& (expected.getFrcPou().equals(actual.getFrcPou())
			&& (expected.getPh().equals(actual.getPh())
			)))))
			pass(msg);
		else fail(expected, actual, msg);
	}
	
	public static void assertEquals(WellItem expected, WellItem actual) {
		assertEquals(expected, actual, null);
	}
	
	public static void assertEquals(WellItem expected, WellItem actual, String msg) {
		if ((expected.getId()==actual.getId()) 
			&& (expected.getName().equals(actual.getName()) 
			&& (expected.getPwsid().equals(actual.getPwsid()) 
			&& (expected.getLocation().equals(actual.getLocation())
		))))
		pass(msg);
		else fail(expected, actual, msg);
	}
	
	public static void assertEquals(int expected, int actual) {
		assertEquals(expected, actual, null);
	}
	
	public static void assertEquals(int expected, int actual, String msg) {
		if (expected==actual) pass(msg);
		else fail(expected, actual, msg);
	}
	
	public static void assertEquals(float expected, float actual) {
		assertEquals(expected, actual, null);
	}

	public static void assertEquals(float expected, float actual, String msg) {
		if (expected==actual) pass(msg);
		else fail(expected, actual, msg);
	}

	public static void assertEquals(long expected, long actual) {
		assertEquals(expected, actual, null);
	}

	public static void assertEquals(long expected, long actual, String msg) {
		if (expected==actual) pass(msg);
		else fail(expected, actual, msg);
	}
	
	public static void assertEquals(String expected, String actual) {
		assertEquals(expected, actual, null);
	}
	
	public static void assertEquals(String expected, String actual, String msg) {
		if (expected.equals(actual)) pass(msg);
		else fail(expected, actual, msg);
	}
	
	private static void pass(String msg) {
			StringBuilder sb = new StringBuilder("PASSED");
			if (msg!=null) sb.append(" [").append(msg).append("]");
			L.i(sb.toString());
	}
	
	private static void fail(Object expected, Object actual, String msg) {
		StringBuilder sb = new StringBuilder("FAIL [Expected ")
			.append(" '")
			.append(expected.toString())
			.append("', actual ")
			.append(" '")
			.append(actual.toString())
			.append("' was given instead.]");
		if (msg!=null) sb.append(" [").append(msg).append("]");
		L.w(sb.toString());
	}
}
