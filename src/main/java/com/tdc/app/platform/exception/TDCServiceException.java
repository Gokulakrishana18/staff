package com.tdc.app.platform.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * An Staff specific exception.
 * 
 * @author Gurpreet
 *
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TDCServiceException extends RuntimeException{
	private static final long serialVersionUID = 1L;

    private final String statusCode;
    
    /**
     * Protected constructor.
     */
    protected TDCServiceException() {
        super();
        this.statusCode = "500";
    }

    /**
     * Public constructor with two parameters.
     *
     * @param message exception description
     * @param cause cause of this exception that will be chained in this exception
     */
    public TDCServiceException(String message, Throwable cause) {
        super(message, cause);
        this.statusCode = "500";
    }

    /**
     * Public constructor with parameter.
     *
     * @param cause cause of this exception that will be chained in this exception
     */
    public TDCServiceException(Throwable cause) {
        super(cause);
        this.statusCode = "500";
    }

    /**
     * Public constructor with two parameters.
     *
     * @param message exception description
     * @param cause cause of this exception that will be chained in this exception
     * @param statusCode the status code
     */
    public TDCServiceException(String message, Throwable cause, String statusCode) {
        super(message, cause);
        this.statusCode = statusCode;
    }
    
    /**
     * Public constructor with message.
     *
     * @param message exception description
     * @param statusCode the status code
     */
    public TDCServiceException(String message, String statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    /**
     * Returns the status code.
     * 
     * @return the status code
     */
    public String getStatusCode() {
        return statusCode;
    }
}
