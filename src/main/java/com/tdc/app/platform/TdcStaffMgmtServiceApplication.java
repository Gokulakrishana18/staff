package com.tdc.app.platform;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TdcStaffMgmtServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TdcStaffMgmtServiceApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}

}
