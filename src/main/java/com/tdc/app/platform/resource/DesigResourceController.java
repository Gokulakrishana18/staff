package com.tdc.app.platform.resource;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tdc.app.platform.constants.StaffServiceConstants;
import com.tdc.app.platform.dto.DesigDto;
import com.tdc.app.platform.dto.DesigResponse;
import com.tdc.app.platform.exception.ErrorMessage;
import com.tdc.app.platform.exception.TDCServiceException;
import com.tdc.app.platform.services.DesigService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


@RestController
@RequestMapping("/api")
@Tag(name = "Designation", description = "The Designation api")
public class DesigResourceController {
	@Autowired
	private DesigService desigService;

	private static final Logger LOGGER = LoggerFactory.getLogger(DesigResourceController.class);

	/**
		 * Get Designation Detail.
	 *
	 * @param desigId - to get particular designation
	 * @return the TDC response
	 * @throws TDCServiceException will thrown if anything went wrong
	 */
	@GetMapping("/desig/{desigId}")
	@Operation(summary = "Fetch designation by id", description = "fetches all designation entities and their data from data source by id")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "successful operation") })
	public DesigResponse getDesignation(@PathVariable Integer desigId) throws TDCServiceException {
		DesigResponse tdcResponse = new DesigResponse();
		try {
			final Optional<DesigDto> desigResponse = Optional.ofNullable(desigService.getDesigById(desigId));
			DesigDto desigRes = desigResponse.get();

			if (desigResponse != null) {
				tdcResponse.setStatusCode(StaffServiceConstants.SUCCESS_CODE);
				tdcResponse.setDesig(desigRes);
				tdcResponse.setStatusMessage(StaffServiceConstants.SUCCESS_MESSAGE);
				LOGGER.info("Designation data pulled successfully");
			}

		} catch (NoSuchElementException ex) {
			ErrorMessage error = new ErrorMessage();
			error.setErrorCode(StaffServiceConstants.NO_RESULT_FOUND);
			error.setErrorMessage(StaffServiceConstants.ERR_CODE_DESIGNATION_NOT_FOUND_BY_ID);
			tdcResponse.setError(error);
			 LOGGER.error("Desig list not found for the given id ");
		}
		return tdcResponse;
	}
	

	/**
	 * Get Designation Detail.
	 *
	 * @return the Designation response
	 * @throws TDCServiceException will thrown if anything went wrong
	 */
	@GetMapping("/desig")
	@Operation(summary = "Fetch all designation", description = "fetches all designation entities and their data from data source")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "successful operation") })
	public DesigResponse getAllDesignation() throws TDCServiceException {
		DesigResponse tdcResponse = new DesigResponse();
		try {
			final List<DesigDto> desigResponse = desigService.getAllDesigs();

			if (desigResponse != null) {
				tdcResponse.setStatusCode(StaffServiceConstants.SUCCESS_CODE);
				tdcResponse.setDataList(desigResponse);
				tdcResponse.setStatusMessage(StaffServiceConstants.SUCCESS_MESSAGE);
				LOGGER.info("Designation data pulled successfully");
			}

		} catch (Exception ex) {
			ErrorMessage error = new ErrorMessage();
			error.setErrorCode(StaffServiceConstants.NO_RESULT_FOUND);
			error.setErrorMessage(StaffServiceConstants.ERR_DESC_NO_RESULT_FOUND);
			tdcResponse.setError(error);
			 LOGGER.error("Designation list not found", ex);
		}
		return tdcResponse;
	}
	
	//GetDesigByName


}
