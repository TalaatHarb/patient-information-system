package net.talaatharb.patientinformationbackend.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import org.mapstruct.factory.Mappers;

import net.talaatharb.patientinformationbackend.dtos.OrganizationDTO;
import net.talaatharb.patientinformationbackend.entities.Organization;

class OrganizationMapperTest implements DefaultMapperTest<Organization, OrganizationDTO> {
	
	private static final UUID ORGANIZATION_ID = UUID.randomUUID();
	
	private OrganizationMapper organizationMapper = Mappers.getMapper(OrganizationMapper.class);

	@Override
	public void assertEqualEntityAndDto(Organization organization, OrganizationDTO organizationDTO) {
		assertEquals(organizationDTO.getId(), organization.getId());
		assertEquals(organizationDTO.getName(), organization.getName());
	}

	@Override
	public OrganizationDTO createDTO() {
		final OrganizationDTO organizationDTO = new OrganizationDTO();
		
		organizationDTO.setName("Test Organization");
		organizationDTO.setId(ORGANIZATION_ID);
		
		return organizationDTO;
	}

	@Override
	public Organization createEntity() {
		final Organization organization = new Organization();
		
		organization.setName("Test Organization");
		organization.setId(ORGANIZATION_ID);
		
		return organization;
	}

	@Override
	public DefaultMapper<Organization, OrganizationDTO> getMapper() {
		return organizationMapper;
	}
}
