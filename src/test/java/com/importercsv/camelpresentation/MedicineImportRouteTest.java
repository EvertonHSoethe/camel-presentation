package com.importercsv.camelpresentation;

import com.importercsv.camelpresentation.service.ImporterService;
import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.junit5.CamelSpringBootTest;
import org.apache.camel.test.spring.junit5.MockEndpoints;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@CamelSpringBootTest
@MockEndpoints("file:output")
class MedicineImportRouteTest {
	@Test
	void contextLoads() {
	}
	@Autowired
	private ImporterService importerService;

	@Autowired
	private ProducerTemplate template;
	@EndpointInject("mock:file:output")
	private MockEndpoint mock;

//	@Test
//	void whenSendBody_thenImportReceivedSuccessfully() throws InterruptedException {
//		mock.expectedBodiesReceived("Hello Baeldung Readers!");
//		template.sendBody("files:Entradas", null);
//		mock.assertIsSatisfied();
//	}
}
