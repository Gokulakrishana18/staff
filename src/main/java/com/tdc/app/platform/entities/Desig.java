package com.tdc.app.platform.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Data
@Table(name = "DESIG", uniqueConstraints = {@UniqueConstraint(columnNames = {"DESIG_ID"})})
public class Desig  implements Serializable{

    /**
	 * Serial Version Id
	 */
	private static final long serialVersionUID = 1L;

	@Id
	//@NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="DESIG_ID", length=50)
	private Integer desigId;
	
	@Column(name="DESIG")
	private String designation;
	
	@OneToMany(mappedBy = "desig", fetch = FetchType.LAZY, orphanRemoval = false)
    private List<Staff> listStaffs = new ArrayList<>();

}
