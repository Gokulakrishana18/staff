package com.tdc.app.platform.utility;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tdc.app.platform.exception.TDCServiceException;

@Component
public class TDCObjectMapper {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ObjectMapper objectMapper;

	public <T> T mapEntityToDto(Object object, Class<T> classToReturn) throws TDCServiceException {
		T dto = modelMapper.map(object, classToReturn);
		return dto;
	}
	
	
	
	public <T> T mapStringToDto(String object, Class<T> classToReturn) throws TDCServiceException {
		T dto;
		try {
			dto = objectMapper.readValue(object, classToReturn);
			return dto;
		} catch (JsonMappingException e) {
			@SuppressWarnings("unchecked")
			T body = (T) ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Mapping Request");
			return body;
			
		} catch (JsonProcessingException e) {
			@SuppressWarnings("unchecked")
			T body = (T) ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Json Request");
			return body;
		}		
		
	}

}
