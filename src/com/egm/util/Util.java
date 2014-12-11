package com.egm.util;
import java.util.*;
import java.text.*;

public class Util
{
	public static String toString(Date date)
	{
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String string = format.format(date);
		return (string);
	}
	
	public static Date toDate(String dateTime)
	{
		Date date = new Date();
	DateFormat format;
	L.d("date = "+dateTime+", date length = "+dateTime.length());
	if (dateTime.length()==19) {
		format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	} else {
		format = new SimpleDateFormat("ddd MMM dd HH:mm:ss zzz yyyy");
	}
	try {
		date = format.parse(dateTime);
	} catch (ParseException e) {
		L.e("Parsing datetime failed", e);
	}

	long when = date.getTime();
	int flags = 0;
	flags |= android.text.format.DateUtils.FORMAT_SHOW_TIME;
	flags |= android.text.format.DateUtils.FORMAT_SHOW_DATE;
	flags |= android.text.format.DateUtils.FORMAT_ABBREV_MONTH;
	flags |= android.text.format.DateUtils.FORMAT_SHOW_YEAR;

	//String finalDateTime = android.text.format.DateUtils.formatDateTime(context, when + TimeZone.getDefault().getOffset(when), flags);

		return date;																	
	}

}
