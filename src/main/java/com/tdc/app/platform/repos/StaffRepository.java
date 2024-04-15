package com.tdc.app.platform.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tdc.app.platform.entities.Staff;

public interface StaffRepository extends JpaRepository<Staff, Integer>{

	 @Query("from Staff s where s.desig=:desigId") 
	 List<Staff> findAllStaffsOfADesig(@Param("desigId") int desigId);
	 
	 @Query("from Staff s where s.reportingTo=:reportingTo") 
	 Staff findStaffsReportingTo(@Param("reportingTo") Integer reportingTo);
	
}
