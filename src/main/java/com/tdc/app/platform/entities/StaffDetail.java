package com.tdc.app.platform.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "STAFF_EMPLOYMENT_DETAILS")
@SecondaryTable(name = "STAFF_EDUCATION_DETAIL")
public class StaffDetail {
	/**
	 * Serial Version Id
	 */
	private static final long serialVersionUID = 5577021807669558622L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="STAFF_DETAIL_ID", updatable = false, nullable = false)
    private Integer staffDetailId;
	
	@Column(name="STAFF_ID", nullable = false, unique = true)
	private String staffId;
	
	@Column(name="COMPANY_NAME")
	private String companyName;
	
	@Column(name="EXPERIENCE")
	private String experience;	
	
	@Column(name="DOCUMENT")
	private String document;
	
	@Column(name="UPLOAD_DOC")
	private String uploadDocument;
	
	@Column(table = "STAFF_EDUCATION_DETAIL",name="QUALIFICATION")
	private String qualification;
	
	@Column(table = "STAFF_EDUCATION_DETAIL",name="DEGREE_CERT")
	private String degreeCertificate;
}
