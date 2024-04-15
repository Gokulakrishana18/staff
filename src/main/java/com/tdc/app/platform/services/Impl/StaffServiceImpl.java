package com.tdc.app.platform.services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import com.tdc.app.platform.services.Impl.StaffDetailServiceImpl;
import com.tdc.app.platform.services.StaffService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.tdc.app.platform.dto.StaffRequest;
import com.tdc.app.platform.entities.Staff;
import com.tdc.app.platform.exception.TDCServiceException;
import com.tdc.app.platform.repos.StaffRepository;
import com.tdc.app.platform.utility.TDCObjectMapper;

@Service
public class StaffServiceImpl implements StaffService {

	private static final Logger LOGGER = LoggerFactory.getLogger(StaffDetailServiceImpl.class);

	@Autowired
	private TDCObjectMapper objectMapper;

	@Autowired
	private StaffRepository staffRepository;

	@Override
	public StaffRequest saveUpdateStaff(StaffRequest staffDto) throws DataIntegrityViolationException {
		// Inorder to map dto to entity pass dto object and entity class to same method
		
		Staff entity = objectMapper.mapEntityToDto(staffDto, Staff.class);
		Staff staff = staffRepository.save(entity);
		return objectMapper.mapEntityToDto(staff, StaffRequest.class);

	}

	@Override
	public List<StaffRequest> deleteStaff(int staffId) {
		try {
			staffRepository.deleteById(staffId);
			return getAllStaffs();
		} catch (DataAccessException e) {
			throw new TDCServiceException("Failed to delete the staff with staffId = " + staffId, e);
		}
	}

	@Override
	public StaffRequest getStaffById(int staffId) {
		try {
			// StaffRequest staff=
			// objectMapper.mapEntityToDto(staffRepository.findById(staffId).get(),
			// StaffRequest.class);
			return objectMapper.mapEntityToDto(staffRepository.findById(staffId).get(), StaffRequest.class);
		} catch (Exception e) {
			throw new TDCServiceException("Could not find user with staffId= " + staffId, e);
		}
	}

	@Override
	public List<StaffRequest> getAllStaffs() {
		try {
			List<StaffRequest> staffBeansList = null;
			List<Staff> dbDetails = staffRepository.findAll();
			if (!CollectionUtils.isEmpty(dbDetails)) {
				staffBeansList = dbDetails.stream().map(staff -> {

					return objectMapper.mapEntityToDto(staff, StaffRequest.class);

				}).collect(Collectors.toList());
			}
			return staffBeansList;
		} catch (Exception e) {
			LOGGER.error("Exception occured while retrieving record: {}", e);
		}
		return null;
	}

	@Override
	public List<StaffRequest> findAllStaffsOfADesig(int desigId) {
		try {
			List<StaffRequest> staffBeansList = null;
			List<Staff> dbStaffs = staffRepository.findAllStaffsOfADesig(desigId);
			if (!CollectionUtils.isEmpty(dbStaffs)) {
				staffBeansList = dbStaffs.stream().map(staff -> {

					return objectMapper.mapEntityToDto(staff, StaffRequest.class);

				}).collect(Collectors.toList());
			}
			return staffBeansList;
		} catch (Exception e) {
			LOGGER.error("Exception occured while retrieving record: {}", e);
		}
		return null;
	}
	
	//DateFormater implementation priority is normal

}
