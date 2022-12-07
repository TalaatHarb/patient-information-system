package net.talaatharb.patientinformationbackend.facades;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import net.talaatharb.patientinformationbackend.dtos.OrganizationDTO;
import net.talaatharb.patientinformationbackend.entities.Organization;
import net.talaatharb.patientinformationbackend.mappers.OrganizationMapper;
import net.talaatharb.patientinformationbackend.services.OrganizationService;

@ExtendWith(MockitoExtension.class)
class OrganizationFacadeImplTest {
	
	@InjectMocks
	private OrganizationFacadeImpl organizationFacade;
	
	@Mock
	private OrganizationMapper organizationMapper;
	
	@Mock
	private OrganizationService organizationService;

	@Test
	void testCreateOrganizationCallsMappersAndServices() {
		// Arrange
		// input organization
		final OrganizationDTO organizationToCreate = new OrganizationDTO();
		
		// mapped organization
		final Organization mappedOrganization = new Organization();
		when(organizationMapper.fromDTOToEntity(organizationToCreate)).thenReturn(mappedOrganization);
		
		// created organization
		final Organization createdOrganizatoin = new Organization();
		when(organizationService.createOrganization(mappedOrganization)).thenReturn(createdOrganizatoin);
		
		// Act
		organizationFacade.createOrganization(organizationToCreate);
		
		// Assert
		verify(organizationMapper).fromDTOToEntity(organizationToCreate);
		verify(organizationService).createOrganization(mappedOrganization);
		verify(organizationMapper).fromEntityToDTO(createdOrganizatoin);
	}

}
