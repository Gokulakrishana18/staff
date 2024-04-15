package com.tdc.app.platform.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tdc.app.platform.entities.StaffDetail;

public interface StaffDetailRepository extends JpaRepository<StaffDetail, Integer>{

    StaffDetail findById(int id);

}
