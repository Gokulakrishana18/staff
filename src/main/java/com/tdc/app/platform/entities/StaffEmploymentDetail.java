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
@Table(name = "STAFF_EMPLOYMENT_DETAILS")
public class StaffEmploymentDetail  implements Serializable{

	/**
	 * Serial Version Id
	 */
	private static final long serialVersionUID = 5577021807669558622L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="STAFF_DETAIL_ID")
    private Integer staffDetailId;
	
	@Column(name="STAFF_ID", nullable = false, unique = false)
	private String staffId;
	
	@Column(name="COMPANY_NAME")
	private String companyName;
	
	@Column(name="EXPERIENCE")
	private String experience;	
	
	@Column(name="DOCUMENT")
	private String document;
	
	@Column(name="UPLOAD_DOC")
	private String uploadDocument;
	
	
	
}
