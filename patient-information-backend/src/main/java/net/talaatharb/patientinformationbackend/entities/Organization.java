package net.talaatharb.patientinformationbackend.entities;

import java.util.UUID;

import lombok.Data;

@Data
public class Organization {

	private UUID id;
	
	private String name;
}
