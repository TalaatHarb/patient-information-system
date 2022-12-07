package net.talaatharb.patientinformationbackend.services;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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

	@Test
	void testGetOrganizationsFetchesFromDB() {
		// Arrange
		int page = 0;
		int size = 10;
		Pageable pageable = PageRequest.of(page, size);
		
		// Act
		organizationService.getOrganizations(pageable);
		
		// Assert
		verify(organizationRepository).findAll(pageable);
	}
}
