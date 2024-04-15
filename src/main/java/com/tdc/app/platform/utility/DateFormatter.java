package com.tdc.app.platform.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateFormatter {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	public Date getSubmissionDateConverted(String timezone, String date) throws ParseException {
		dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
		return dateFormat.parse(date);
	}

	public String setSubmissionDate(Date date, String timezone) {
		dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
		String convertedDate = dateFormat.format(date);
		return convertedDate;
	}
}
