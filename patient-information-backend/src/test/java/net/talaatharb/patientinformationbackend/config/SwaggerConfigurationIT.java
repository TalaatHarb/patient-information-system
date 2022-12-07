package net.talaatharb.patientinformationbackend.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springdoc.webmvc.api.OpenApiWebMvcResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles(profiles = "test")
@Tag("integration")
class SwaggerConfigurationIT {

	@Autowired
	private OpenApiWebMvcResource openApiDocs;

	@Test
	void testSwaggerIsConfigured() {
		assertNotNull(openApiDocs);
	}
}
