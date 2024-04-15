package com.tdc.app.platform.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class StaffDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5577021807669558622L;

    private Integer staffId;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private String email;
	
	private String phone;
	
	private Integer desigId;
	
	private String alternateContactNo;
	
	private String profilePicturePath;
	
	private String gender;
	
	private String dateOfBirth;
	
	private Integer reportingTo;
	
    private String state;
	
	private String country;
	
	private String password;
	
}
