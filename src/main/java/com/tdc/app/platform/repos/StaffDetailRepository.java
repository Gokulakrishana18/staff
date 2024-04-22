package com.tdc.app.platform.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tdc.app.platform.entities.StaffDetail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StaffDetailRepository extends JpaRepository<StaffDetail, Integer>{

    @Query("from StaffDetail s where s.experience=:exp")
    List<StaffDetail> findByExperience(@Param("exp") int experience);
//    void findBySTAFFDETAILID(@Param("id") int id);
    Optional<StaffDetail> findByStaffDetailId(Integer id);

//    @Query("from Staff s where s.desig=:desigId")
//    List<Staff> findAllStaffsOfADesig(@Param("desigId") int desigId);

}
