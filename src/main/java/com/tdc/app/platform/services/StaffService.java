package com.tdc.app.platform.services;

import java.util.List;

import com.tdc.app.platform.dto.StaffRequest;

public interface StaffService {

	StaffRequest saveUpdateStaff(StaffRequest staffDto);
	List<StaffRequest> deleteStaff(int staffId);
	StaffRequest getStaffById(int staffId);
	List<StaffRequest> getAllStaffs();
	List<StaffRequest> findAllStaffsOfADesig(int desigId);
	
}
