package net.talaatharb.patientinformationbackend.facades;

import net.talaatharb.patientinformationbackend.dtos.OrganizationDTO;

public interface OrganizationFacade {
	public OrganizationDTO createOrganization(OrganizationDTO organizationToCreate);
}
