package com.tdc.app.platform.services;

import java.util.List;
import java.util.Optional;

import com.tdc.app.platform.dto.StaffRequest;
import com.tdc.app.platform.entities.Staff;

public interface StaffService {

	StaffRequest saveUpdateStaff(StaffRequest staffDto);
	List<StaffRequest> deleteStaff(int staffId);
	StaffRequest getStaffById(int staffId);
	List<StaffRequest> getAllStaffs();
	List<StaffRequest> findAllStaffsOfADesig(int desigId);

	List<StaffRequest> getStaffByPhoneNumber(String phoneNumber);

	List<StaffRequest> getStaffByCounty(String country);

	List<StaffRequest> getStaffByGender(String gender);

	List<StaffRequest> getStaffByIsActive(boolean isActive);

	List<StaffRequest> getStaffByGmail(String  email);
	
}
