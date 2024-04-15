package com.tdc.app.platform.services.Impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tdc.app.platform.services.StaffDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import com.tdc.app.platform.dto.StaffDetailDto;
import com.tdc.app.platform.dto.StaffDetailRequest;
import com.tdc.app.platform.entities.StaffDetail;
import com.tdc.app.platform.repos.StaffDetailRepository;
import com.tdc.app.platform.utility.ImageSaver;
import com.tdc.app.platform.utility.TDCObjectMapper;

@Service
public class StaffDetailServiceImpl implements StaffDetailService {

	private static final Logger LOGGER = LoggerFactory.getLogger(StaffDetailServiceImpl.class);

	@Autowired
	private StaffDetailRepository staffDetailRepository;
	
	@Autowired
	private TDCObjectMapper objectMapper;

	@Autowired
	private ImageSaver imageSaver;

	@Override
	public List<StaffDetailDto> getAllStaffDetails() {
		try {
			List<StaffDetailDto> detailBeansList = null;
			List<StaffDetail> dbDetails = staffDetailRepository.findAll();
			if (!CollectionUtils.isEmpty(dbDetails)) {
				detailBeansList = dbDetails.stream().map(detail -> {

					return objectMapper.mapEntityToDto(detail, StaffDetailDto.class);

				}).collect(Collectors.toList());
			}
			return detailBeansList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public StaffDetailDto getStaffDetailById(int staffDetailId) {
		// TODO Auto-generated method stub

		StaffDetail staffDetail1 = staffDetailRepository.findById(staffDetailId);
		StaffDetailDto staffDetailDto = new StaffDetailDto();

			staffDetailDto.setStaffDetailId(staffDetail1.getStaffDetailId());
			staffDetailDto.setDegreeCertificate(staffDetail1.getDegreeCertificate());
			staffDetailDto.setDegreeCertificate(staffDetail1.getDegreeCertificate());
			staffDetailDto.setExperience(staffDetail1.getExperience());

		//return objectMapper.mapEntityToDto(staffDetailRepository.findById(staffDetailId).get(), StaffDetailDto.class);
   return  staffDetailDto;
	}

	@Override
	public StaffDetailDto saveUpdateStaffDetails(String detailRequest, MultipartFile document,MultipartFile degreeCertificate) {
		StaffDetailRequest request = objectMapper.mapStringToDto(detailRequest,
				StaffDetailRequest.class);
		StaffDetailDto empDetails = null;
		try {
			String doc = imageSaver.saveImageToStorage(document);
			String degree = imageSaver.saveImageToStorage(degreeCertificate);
			request.setUploadDocument(doc);
			request.setDegreeCertificate(degree);
			// Inorder to map dto to entity pass dto object and entity class to same method
			StaffDetail entity = objectMapper.mapEntityToDto(request, StaffDetail.class);
			StaffDetail staffDetail = staffDetailRepository.save(entity);
			empDetails = objectMapper.mapEntityToDto(staffDetail, StaffDetailDto.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empDetails;
	}

	
}
