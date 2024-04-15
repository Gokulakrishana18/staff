package com.tdc.app.platform.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StaffDetailResponse extends BaseRequest implements Serializable{
	/**
     * Generated serial id.
     */
    private static final long serialVersionUID = 475413620336011412L;    
       
    private List<StaffDetailDto> dataList;
    
    private StaffDetailDto data;

}
