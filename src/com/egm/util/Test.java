package com.egm.util;
import com.egm.util.L;
import com.egm.welltrak.model.*;
import java.nio.*;
import junit.framework.*;

/**
 * Test Class
 *
 * @author John LaDuke
 */
public class Test
{
	public static void assertEquals(VisitItem expected, VisitItem actual) {
		assertEquals(expected, actual, null);
	}

	public static void assertEquals(VisitItem expected, VisitItem actual, String msg) {
		if (
			expected.getId()==actual.getId()
			&& expected.getWellId()==actual.getWellId()
			&& expected.getDate().equals(actual.getDate())
			&& expected.getFm()==actual.getFm()
			&& compare(expected.getFrcPoe(), actual.getFrcPoe())
			&& compare(expected.getFrcPou(), actual.getFrcPou())
			&& compare(expected.getPh(), actual.getPh())
			)
			pass(msg);
		else fail(expected, actual, msg);
	}
	
	public static void assertEquals(WellItem expected, WellItem actual) {
		assertEquals(expected, actual, null);
	}
	
	public static void assertEquals(WellItem expected, WellItem actual, String msg) {
		if (
			expected.getId()==actual.getId()
			&& compare(expected.getName(), actual.getName()) 
			&& compare(expected.getPwsid(), actual.getPwsid()) 
			&& compare(expected.getLocation(), actual.getLocation())
		)
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
		if (compare(expected, actual)) pass(msg);
		else fail(expected, actual, msg);
	}
	
	private static boolean compare(String expected, String actual)
	{
		if (expected==null)
			return (actual==null);
		else
			return (expected.equals(actual));
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
