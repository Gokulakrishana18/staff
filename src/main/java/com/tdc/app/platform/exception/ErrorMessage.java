package com.tdc.app.platform.exception;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Error model that contains information for the error code and message.
 * 
 * @author SSambandam
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class ErrorMessage implements Serializable {

    /**
     * Generated serialId.
     */
    private static final long serialVersionUID = -9205434639233579612L;

    private String errorCode;

    private String errorMessage;

    @JsonInclude(Include.NON_NULL)
    private List<String> errors;
}
