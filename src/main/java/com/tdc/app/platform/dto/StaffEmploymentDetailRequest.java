package com.tdc.app.platform.dto;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class StaffEmploymentDetailRequest implements Serializable {
	/**
	 * Serial Version Id
	 */
	private static final long serialVersionUID = 5577021807669558622L;

	private Integer staffDetailId;

	private String staffId;

	private String companyName;

	private String experience;

	private String documentDetail;

	private String uploadDocument;

}
