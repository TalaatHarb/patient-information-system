package net.talaatharb.patientinformationbackend.services;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import net.talaatharb.patientinformationbackend.entities.Organization;
import net.talaatharb.patientinformationbackend.repositories.OrganizationRepository;

@ExtendWith(MockitoExtension.class)
class OrganizationServiceImplTest {
	
	@InjectMocks
	private OrganizationServiceImpl organizationService;
	
	@Mock
	private OrganizationRepository organizationRepository;

	@Test
	void testCreateOrganizationSavesToDB() {
		// Arrange
		final Organization organizationToCreate = new Organization();
		
		// Act
		organizationService.createOrganization(organizationToCreate);
		
		// Assert
		verify(organizationRepository).save(organizationToCreate);
	}
}
