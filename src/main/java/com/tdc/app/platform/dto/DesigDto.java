package com.tdc.app.platform.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DesigDto  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer desigId;
	
	private String designation;

}
