package com.tdc.app.platform.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tdc.app.platform.services.DesigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.tdc.app.platform.dto.DesigDto;
import com.tdc.app.platform.entities.Desig;
import com.tdc.app.platform.exception.TDCServiceException;
import com.tdc.app.platform.repos.DesigRepository;
import com.tdc.app.platform.utility.TDCObjectMapper;

@Service
public class DesigServiceImpl implements DesigService {

	@Autowired
	private DesigRepository desigRepository;

	@Autowired
	private TDCObjectMapper objectMapper;

	@Override
	public List<DesigDto> getAllDesigs() throws TDCServiceException {
		List<DesigDto> desigBeansList = null;
		Optional<List<Desig>> dbDesignations = Optional.ofNullable(desigRepository.findAll());
		List<Desig> desigs=dbDesignations.get();
		if (!CollectionUtils.isEmpty(desigs)) {
			desigBeansList = desigs.stream().map(desig -> {

				return objectMapper.mapEntityToDto(desig, DesigDto.class);

			}).collect(Collectors.toList());
		}
		return desigBeansList;
	}

	@Override
	public DesigDto getDesigById(int desigId) throws TDCServiceException {
		// TODO Auto-generated method stub
		Optional<Desig> desig=Optional.ofNullable(desigRepository.findById(desigId).get());
		return objectMapper.mapEntityToDto(desig, DesigDto.class);
	}

}
