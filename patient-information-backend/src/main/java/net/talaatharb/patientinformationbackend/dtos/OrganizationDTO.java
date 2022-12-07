package net.talaatharb.patientinformationbackend.dtos;

import java.time.Instant;
import java.util.UUID;

import lombok.Data;

@Data
public class OrganizationDTO {

	private UUID id;
	
	private String name;
	
	private Boolean active = Boolean.TRUE;

	private Instant creationDate;

	private Instant updateDate;
}
