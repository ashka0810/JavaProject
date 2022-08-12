package com.easypguser.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeOperation {
	
	public static Timestamp changeStrToDate(String str)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
		Timestamp date_Time = Timestamp.valueOf(dateTime);
		return date_Time;

	}

}
