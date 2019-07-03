/*
 * 
 */
package main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class DateEvents.
 */
public class DateEvents {

/** The format. */
private static String format = "yyyy-MM-dd";

/**
 * Format.
 *
 * @return the string
 */
public static String format() {
	long currentTime=System.currentTimeMillis();
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
	Date resultDate=new Date(currentTime);
	return simpleDateFormat.format(resultDate);
}
}