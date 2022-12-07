package net.talaatharb.patientinformationbackend.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.talaatharb.patientinformationbackend.entities.Organization;
import net.talaatharb.patientinformationbackend.repositories.OrganizationRepository;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService{
	
	private final OrganizationRepository organizationRepository;

	@Override
	public Organization createOrganization(Organization organization) {
		return organizationRepository.save(organization);
	}

	@Override
	public Page<Organization> getOrganizations(Pageable pageable) {
		return organizationRepository.findAll(pageable);
	}

}
