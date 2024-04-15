package com.tdc.app.platform.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tdc.app.platform.entities.Staff;

import jakarta.persistence.Transient;
import lombok.Data;

@Data
public class StaffRequest implements Serializable {
	/**
	 * Serial Version Id
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
	
	private String joiningDate;

	private Integer reportingTo;

	private String state;

	private String country;

	private String password;
	
	private Double Salary;
	
	@JsonIgnore
	private Staff manager;
	
	
}
