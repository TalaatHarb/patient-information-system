package net.talaatharb.patientinformationbackend.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import net.talaatharb.patientinformationbackend.entities.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, UUID>{

}
