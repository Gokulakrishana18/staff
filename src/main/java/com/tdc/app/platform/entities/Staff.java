package com.tdc.app.platform.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Data
@Table(name = "STAFF", uniqueConstraints = {@UniqueConstraint(columnNames = {"STAFF_ID"})})
public class Staff implements Serializable{
	/**
	 *  Serial Version Id
	 */
	private static final long serialVersionUID = 5577021807669558622L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="STAFF_ID")
    private Integer staffId;
	
	@Column(nullable = false, name = "FIRST_NAME")
	private String firstName;
	
	@Column(name="MIDDLE_NAME")
	private String middleName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(nullable = false, unique = true, name = "EMAIL")
	private String email;
	
	@Column(nullable = false, unique = true, name = "PHONE")
	private String phone;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "desig.desigId")
	private Desig desig;
	
	@Column(name="ALTENATE_CONTACT_NO")
	private String alternateContactNo;
	
	@Column(name="PROFILE_PICTURE")
	private String profilePicturePath;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="DATE_OF_BIRTH")
	private String dateOfBirth;
	
	@Column(name="REPORTING_TO")
	private Integer reportingTo;
	
	@Column(name="STATE")
    private String state;
	
	@Column(name="COUNTRY")
	private String country;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="IS_ACTIVE")
	private Byte isActive;
	
	@Column(name="JOINING_DATE")
	private String joiningDate;
	
	@Column(name="SALARY")
	private Double salary;
}
