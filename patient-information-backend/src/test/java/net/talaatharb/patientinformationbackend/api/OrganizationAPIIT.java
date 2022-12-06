package net.talaatharb.patientinformationbackend.api;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.talaatharb.patientinformationbackend.dtos.OrganizationDTO;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(profiles = "test")
@Tag("integration")
class OrganizationAPIIT {

	@Autowired
	private MockMvc mockMVC;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void testCreateOrganization() throws JsonProcessingException, Exception {
		// Arrange
		// Organization details
		OrganizationDTO inputOrganizationDto = new OrganizationDTO();

		// Act
		// Call the API for creating organization
		ResultActions result = mockMVC
				.perform(post("/api/v1/organizations").content(objectMapper.writeValueAsString(inputOrganizationDto))
						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));

		// Assert
		// Creation is successful and the created organization information is sent back with correct information
		result.andExpect(status().isCreated()).andExpect(jsonPath("$.id", notNullValue()));

	}
}
