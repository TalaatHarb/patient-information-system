package net.talaatharb.patientinformationbackend.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import net.talaatharb.patientinformationbackend.entities.Organization;

@Service
public class OrganizationServiceImpl implements OrganizationService{

	@Override
	public Organization createOrganization(Organization organization) {
		organization.setId(UUID.randomUUID());
		return organization;
	}

}
