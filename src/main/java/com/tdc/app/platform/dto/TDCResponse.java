package com.tdc.app.platform.dto;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.tdc.app.platform.exception.ErrorMessage;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TDCResponse  implements Serializable {
	/**
     * Generated serial id.
     */
    private static final long serialVersionUID = 475413620336011412L;
    
    private static final SimpleDateFormat dateFormat
    = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    
    private String statusCode;

    private String statusMessage;

    private Object dataList;

    private ErrorMessage error;
    
    private String date;
    
    public Date getSubmissionDateConverted(String timezone) throws ParseException {
        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        return dateFormat.parse(this.date);
    }

    public void setSubmissionDate(Date date, String timezone) {
        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        this.date = dateFormat.format(date);
    }
}
