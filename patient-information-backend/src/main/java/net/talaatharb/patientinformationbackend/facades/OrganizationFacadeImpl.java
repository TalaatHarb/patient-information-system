package net.talaatharb.patientinformationbackend.facades;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.talaatharb.patientinformationbackend.dtos.OrganizationDTO;
import net.talaatharb.patientinformationbackend.entities.Organization;
import net.talaatharb.patientinformationbackend.mappers.OrganizationMapper;
import net.talaatharb.patientinformationbackend.services.OrganizationService;

@Service
@RequiredArgsConstructor
public class OrganizationFacadeImpl implements OrganizationFacade {

	private final OrganizationMapper organizationMapper;

	private final OrganizationService organizationService;

	@Override
	public OrganizationDTO createOrganization(OrganizationDTO organizationToCreate) {
		Organization organization = organizationMapper.fromDTOToEntity(organizationToCreate);
		organization = organizationService.createOrganization(organization);
		return organizationMapper.fromEntityToDTO(organization);
	}

	@Override
	public Page<OrganizationDTO> getOrganizations(Pageable pageable) {
		return Page.empty();
	}

}
