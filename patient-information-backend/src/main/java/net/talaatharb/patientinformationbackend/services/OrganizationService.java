package net.talaatharb.patientinformationbackend.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.talaatharb.patientinformationbackend.entities.Organization;

public interface OrganizationService {

	public Organization createOrganization(Organization mappedOrganization);

	public Page<Organization> getOrganizations(Pageable pageable);

}
