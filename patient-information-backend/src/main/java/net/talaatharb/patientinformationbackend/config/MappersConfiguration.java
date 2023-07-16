package net.talaatharb.patientinformationbackend.config;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.talaatharb.patientinformationbackend.mappers.OrganizationMapper;

@Configuration
public class MappersConfiguration {
	
	@Bean
	OrganizationMapper organizationMapper() {
		return Mappers.getMapper(OrganizationMapper.class);
	}

}
