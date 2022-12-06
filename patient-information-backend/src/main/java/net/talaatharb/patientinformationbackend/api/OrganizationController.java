package net.talaatharb.patientinformationbackend.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import net.talaatharb.patientinformationbackend.dtos.OrganizationDTO;
import net.talaatharb.patientinformationbackend.facades.OrganizationFacade;

@RestController
@RequiredArgsConstructor
public class OrganizationController implements OrganizationAPIs {

	private final OrganizationFacade organizationFacade;

	@Override
	public OrganizationDTO createOrganization(OrganizationDTO organizationToCreate) {
		if (isNotValidOrganizationDTO(organizationToCreate)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return organizationFacade.createOrganization(organizationToCreate);
	}

	private boolean isNotValidOrganizationDTO(OrganizationDTO organizationToCreate) {
		return organizationToCreate == null || StringUtils.isBlank(organizationToCreate.getName());
	}
}
