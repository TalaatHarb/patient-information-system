package net.talaatharb.patientinformationbackend.api;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.web.server.ResponseStatusException;

import net.talaatharb.patientinformationbackend.dtos.OrganizationDTO;

class OrganizationControllerTest {

	private OrganizationController organizationApi;
	
	@BeforeEach
	void setup() {
		organizationApi = new OrganizationController();
	}

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
}
