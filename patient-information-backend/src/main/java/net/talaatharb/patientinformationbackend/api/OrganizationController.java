package net.talaatharb.patientinformationbackend.api;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import net.talaatharb.patientinformationbackend.dtos.OrganizationDTO;

@RestController
@RequestMapping("/api/v1/organizations")
public class OrganizationController {

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public OrganizationDTO createOrganization(@RequestBody OrganizationDTO organizationToCreate) {
		organizationToCreate.setId(UUID.randomUUID());
		return organizationToCreate;
	}
}
