package com.tdc.app.platform.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "STAFF_EDUCATION_DETAIL")
public class StaffEducationDetail implements Serializable{
	/**
	 *  Serial Version Id
	 */
	private static final long serialVersionUID = 5577021807669558622L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="STAFF_EDU_ID")
	 private Integer staffEduId;
	
	@Column(nullable = false, name = "STAFF_ID")
	 private Integer staffId;
	@Column(name="QUALIFICATION")
	private String qualification;
	
	@Column(name="DEGREE_CERT")
	private String degreeCertificate;
}
