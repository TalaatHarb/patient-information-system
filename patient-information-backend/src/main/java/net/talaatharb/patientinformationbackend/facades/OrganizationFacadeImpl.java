package net.talaatharb.patientinformationbackend.facades;

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

}
