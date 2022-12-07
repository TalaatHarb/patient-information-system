package net.talaatharb.patientinformationbackend.api;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.core.JsonProcessingException;

import net.talaatharb.patientinformationbackend.dtos.OrganizationDTO;

class OrganizationAPIIT extends AbstractAPIIT {

	@Test
	void testCreateOrganization() throws JsonProcessingException, Exception {
		// Arrange
		// Organization details
		OrganizationDTO inputOrganizationDto = new OrganizationDTO();
		inputOrganizationDto.setName("Test organization");

		// Act
		// Call the API for creating organization
		ResultActions result = mockMVC
				.perform(post("/api/v1/organizations").content(objectMapper.writeValueAsString(inputOrganizationDto))
						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));

		// Assert
		// Creation is successful and the created organization information is sent back
		// with correct information
		result.andExpect(status().isCreated()) // status
				.andExpect(jsonPath("$.id", notNullValue())) // id set
				.andExpect(jsonPath("$.creationDate", notNullValue())) // creation date
				.andExpect(jsonPath("$.updateDate", notNullValue())); // update date
	}

	@Test
	void testGetOrganizations() throws Exception {
		// Arrange
		// Page details
		String page = "0";
		String size = "10";

		// Act
		// Call the API for getting page of organizations
		ResultActions result = mockMVC.perform(get("/api/v1/organizations").param("page", page).param("size", size)
				.accept(MediaType.APPLICATION_JSON));

		// Assert
		// Get is successful
		result.andExpect(status().isOk()) // status
				.andExpect(jsonPath("$['pageable']['paged']").value("true")); // Pagination
	}
}
