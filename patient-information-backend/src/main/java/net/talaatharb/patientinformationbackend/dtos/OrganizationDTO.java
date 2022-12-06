package net.talaatharb.patientinformationbackend.dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class OrganizationDTO {

	private UUID id;
	
	private String name;
}
