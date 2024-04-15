package com.tdc.app.platform.services;

import java.util.List;

import com.tdc.app.platform.dto.DesigDto;
import com.tdc.app.platform.exception.TDCServiceException;

public interface DesigService {

	List<DesigDto> getAllDesigs() throws TDCServiceException;
	DesigDto getDesigById(int desigId) throws TDCServiceException;
}
