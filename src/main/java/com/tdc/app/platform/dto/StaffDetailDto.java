package com.tdc.app.platform.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

/**
 * THis class is to serve common data for both employment and education details.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StaffDetailDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5577021807669558622L;

	private Integer staffDetailId;

	private String staffId;

	private String companyName;

	private String experience;

	private String document;

	private String uploadDocument;

	private String qualification;

	private String degreeCertificate;

}
