package main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateEvents {

private static String format = "yyyy-MM-dd";
public static String format() {
	long currentTime=System.currentTimeMillis();
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
	Date resultDate=new Date(currentTime);
	return simpleDateFormat.format(resultDate);
}
}