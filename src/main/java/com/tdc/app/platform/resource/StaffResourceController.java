package com.tdc.app.platform.resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tdc.app.platform.dto.StaffRequest;
import com.tdc.app.platform.dto.StaffResponse;
import com.tdc.app.platform.exception.ErrorMessage;
import com.tdc.app.platform.exception.TDCServiceException;
import com.tdc.app.platform.services.StaffService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api")
@Tag(name = "Staff", description = "The Staff api")
public class StaffResourceController {

	@Autowired
	private StaffService staffService;

	private static final Logger LOGGER = LoggerFactory.getLogger(StaffDetailsResourceController.class);

	/**
	 * Get Staff Detail.
	 *
	 * @param staffId - to get particular designation
	 * @return the TDC response
	 * @throws TDCServiceException will thrown if anything went wrong
	 */
	@GetMapping("/staff/{staffId}")
	@Operation(summary = "Fetch staff by id", description = "fetches all staff entities and their data from data source by id")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "successful operation") })
	public StaffResponse getStaff(@PathVariable Integer staffId) throws TDCServiceException {
		StaffResponse staffResponse = new StaffResponse();
		try {
			final StaffRequest staff = staffService.getStaffById(staffId);

			if (staff != null) {
				staffResponse.setStatusCode("200");
				staffResponse.setData(staff);
				staffResponse.setStatusMessage("Staff Detail value retrieved");
				LOGGER.info("Staff Detail data pulled successfully");
			}

		} catch (Exception ex) {
			ErrorMessage error = new ErrorMessage();
			error.setErrorCode("404");
			error.setErrorMessage("Not able to fetch designation");
			staffResponse.setError(error);
			LOGGER.error("Staff detail list not found ", ex);

		}
		return staffResponse;
	}

	/**
	 * Get all Staff.
	 *
	 * @return the Staff response
	 * @throws TDCServiceException will thrown if anything went wrong
	 */
	@GetMapping("/staff")
	@Operation(summary = "Fetch all Staff details", description = "fetches all staff entities and their data from data source")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "successful operation") })
	public StaffResponse getAllStaffDetails() throws TDCServiceException {
		StaffResponse staffResponse = new StaffResponse();
		try {

			final List<StaffRequest> staffDto = staffService.getAllStaffs();

			if (staffDto != null) {
				staffResponse.setStatusCode("200");
				staffResponse.setDataList(staffDto);
				staffResponse.setStatusMessage("Staff details value retrieved");
				LOGGER.info("Staff details data pulled successfully");
			}

		} catch (Exception ex) {
			ErrorMessage error = new ErrorMessage();
			error.setErrorCode(HttpStatus.BAD_REQUEST.toString());
			error.setErrorMessage("Not able to fetch designation records");
			staffResponse.setError(error);
			LOGGER.error("Designation list not found", ex);
		}
		return staffResponse;
	}

	/**
	 * Get Staff Detail.
	 *
	 * @param staffId - to get particular designation
	 * @return the TDC response
	 * @throws TDCServiceException will thrown if anything went wrong
	 */
	@PostMapping("/staff")
	@Operation(summary = "Save or Update Staff Records", description = "Persist/Update staff record in database")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "successful operation") })
	public StaffResponse createUpdateStaff(@RequestHeader("userId") String user, @RequestBody StaffRequest staff)
			throws TDCServiceException {
		LOGGER.info("createUpdateStaff entered and incoming request {}", staff);
		StaffResponse staffResponse = new StaffResponse();

		try {
			final StaffRequest staffDto = staffService.saveUpdateStaff(staff);
			staffResponse.setStatusCode("200");
			staffResponse.setData(staffDto);
			staffResponse.setStatusMessage("Staff record processed successfully");
			return staffResponse;

		} catch (Exception ex) {

			ErrorMessage error = new ErrorMessage();
			error.setErrorCode("500");
			error.setErrorMessage("Not able to process");
			staffResponse.setError(error);
			LOGGER.error("Staff record not processed {}", ex);
			return staffResponse;
		}

	}

	/**
	 * Get Staff Detail.
	 *
	 * @param staffId - to get particular designation
	 * @return the TDC response
	 * @throws TDCServiceException will thrown if anything went wrong
	 */
	@DeleteMapping("/staff/delete")
	@Operation(summary = "Delete Staff Records", description = "Delete staff record in database")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "successful operation") })
	public StaffResponse deleteStaff(@PathVariable int staffId) throws TDCServiceException {

		StaffResponse staffResponse = new StaffResponse();

		try {
			final List<StaffRequest> staffList = staffService.deleteStaff(staffId);
			staffResponse.setStatusCode("205");
			staffResponse.setDataList(staffList);
			staffResponse.setStatusMessage("Staff record deleted successfully");

		} catch (Exception ex) {

			ErrorMessage error = new ErrorMessage();
			error.setErrorCode("500");
			error.setErrorMessage("Not able to process");
			staffResponse.setError(error);
			LOGGER.error("Staff record not processed {}", ex);
		}
		return null;

	}

}
