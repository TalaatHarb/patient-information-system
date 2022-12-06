package net.talaatharb.patientinformationbackend.facades;

import java.util.UUID;

import org.springframework.stereotype.Service;

import net.talaatharb.patientinformationbackend.dtos.OrganizationDTO;

@Service
public class OrganizationFacadeImpl implements OrganizationFacade {

	@Override
	public OrganizationDTO createOrganization(OrganizationDTO organizationToCreate) {
		organizationToCreate.setId(UUID.randomUUID());
		return organizationToCreate;
	}

}
