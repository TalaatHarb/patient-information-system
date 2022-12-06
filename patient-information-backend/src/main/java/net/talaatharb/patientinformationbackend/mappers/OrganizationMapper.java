package net.talaatharb.patientinformationbackend.mappers;

import org.mapstruct.Mapper;

import net.talaatharb.patientinformationbackend.dtos.OrganizationDTO;
import net.talaatharb.patientinformationbackend.entities.Organization;

@Mapper
public interface OrganizationMapper extends DefaultMapper<Organization, OrganizationDTO> {
}
