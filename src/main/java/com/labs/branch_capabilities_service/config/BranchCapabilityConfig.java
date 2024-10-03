package com.labs.branch_capabilities_service.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BranchCapabilityConfig {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
