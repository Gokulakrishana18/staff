package com.tdc.app.platform.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.tdc.app.platform.exception.ErrorMessage;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseRequest {

	private String statusCode;

	private String statusMessage;
	
	private ErrorMessage error;

}
