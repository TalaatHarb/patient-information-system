package net.talaatharb.patientinformationbackend.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import net.talaatharb.patientinformationbackend.dtos.OrganizationDTO;

@CrossOrigin
@RequestMapping("/api/v1/organizations")
public interface OrganizationAPIs {

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public OrganizationDTO createOrganization(@RequestBody OrganizationDTO organizationToCreate);

	@GetMapping("")
	@ResponseStatus(HttpStatus.OK)
	public Page<OrganizationDTO> getOrganizations(Pageable pageable);
}
