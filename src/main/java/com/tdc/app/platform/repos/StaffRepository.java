package com.tdc.app.platform.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tdc.app.platform.entities.Staff;

public interface StaffRepository extends JpaRepository<Staff, Integer>{

	 @Query("from Staff s where s.desig=:desigId") 
	 List<Staff> findAllStaffsOfADesig(@Param("desigId") int desigId);
	 
	 @Query("from Staff s where s.reportingTo=:reportingTo") 
	 Staff findStaffsReportingTo(@Param("reportingTo") Integer reportingTo);

	List<Staff> findByPhone(String phoneNumber);

	List<Staff> findByCountry(String country);

	List<Staff> findByGender(String gender);

	List<Staff> findByIsActive(boolean isActive);

	List<Staff> findByEmail(String email);
	
}
