package net.talaatharb.patientinformationbackend.api;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.micrometer.common.util.StringUtils;
import net.talaatharb.patientinformationbackend.dtos.OrganizationDTO;

@RestController
public class OrganizationController implements OrganizationAPIs{

	@Override
	public OrganizationDTO createOrganization(OrganizationDTO organizationToCreate) {
		if(organizationToCreate == null || StringUtils.isBlank(organizationToCreate.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		organizationToCreate.setId(UUID.randomUUID());
		return organizationToCreate;
	}
}
