package net.talaatharb.patientinformationbackend.facades;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.talaatharb.patientinformationbackend.dtos.OrganizationDTO;

public interface OrganizationFacade {
	public OrganizationDTO createOrganization(OrganizationDTO organizationToCreate);

	public Page<OrganizationDTO> getOrganizations(Pageable pageable);
}
