package net.talaatharb.patientinformationbackend.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Organization {

	@Id
	private UUID id;
	
	private String name;
}
