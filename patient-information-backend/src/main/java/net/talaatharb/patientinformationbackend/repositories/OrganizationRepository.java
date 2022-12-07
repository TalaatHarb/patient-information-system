package net.talaatharb.patientinformationbackend.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.talaatharb.patientinformationbackend.entities.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, UUID>{

}
