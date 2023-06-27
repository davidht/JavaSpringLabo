package com.javaspringlabo.monproject.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MonProjectConfig {
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
