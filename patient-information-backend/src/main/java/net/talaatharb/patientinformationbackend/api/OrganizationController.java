package net.talaatharb.patientinformationbackend.api;

import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import net.talaatharb.patientinformationbackend.dtos.OrganizationDTO;

@RestController
public class OrganizationController implements OrganizationAPIs{

	@Override
	public OrganizationDTO createOrganization(OrganizationDTO organizationToCreate) {
		organizationToCreate.setId(UUID.randomUUID());
		return organizationToCreate;
	}
}
