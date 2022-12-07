package net.talaatharb.patientinformationbackend.api;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.server.ResponseStatusException;

import net.talaatharb.patientinformationbackend.dtos.OrganizationDTO;
import net.talaatharb.patientinformationbackend.facades.OrganizationFacade;

@ExtendWith(MockitoExtension.class)
class OrganizationControllerTest {

	@InjectMocks
	private OrganizationController organizationApi;

	@Mock
	private OrganizationFacade organizationFacade;

	@Test
	void testCreateOrganizationFailsIfTheOrgnaizationHasNoName() {
		// Arrange
		// Fill in the details for an organization with no Name
		OrganizationDTO organizationToCreate = new OrganizationDTO();
		organizationToCreate.setName("");

		// Act
		// Call create organization
		Executable executable = () -> organizationApi.createOrganization(organizationToCreate);

		// Assert
		// An exception should be thrown
		assertThrows(ResponseStatusException.class, executable);
	}

	@Test
	void testCreateOrganizationCallsCorrespondingFacadeMethod() {
		// Arrange
		// Fill in the details for an organization
		OrganizationDTO organizationToCreate = new OrganizationDTO();
		organizationToCreate.setName("Test Organization");

		// Act
		// Call create organization
		organizationApi.createOrganization(organizationToCreate);

		// Assert
		// Facade create organization will be called
		verify(organizationFacade).createOrganization(organizationToCreate);
	}

	@Test
	void testGetOrganizationsCallsCorrespondingFacadeMethod() {
		// Arrange
		int page = 0;
		int size = 10;
		Pageable pageable = PageRequest.of(page, size);
		
		// Act
		organizationApi.getOrganizations(pageable);
		
		// Assert
		verify(organizationFacade).getOrganizations(pageable);
	}
}
