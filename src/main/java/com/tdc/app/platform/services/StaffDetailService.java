package com.tdc.app.platform.services;

import java.util.List;

import com.tdc.app.platform.entities.StaffDetail;
import org.springframework.web.multipart.MultipartFile;

import com.tdc.app.platform.dto.StaffDetailDto;

public interface StaffDetailService {
	
	List<StaffDetailDto> getAllStaffDetails();
	StaffDetailDto getStaffDetailById(int staffDetailId);
	StaffDetailDto saveUpdateStaffDetails(String detailRequest, MultipartFile document, MultipartFile degreeCertificate);

	List<StaffDetailDto> getStaffByExperience(int experience);
	boolean deleteById(Integer staffId);
}
