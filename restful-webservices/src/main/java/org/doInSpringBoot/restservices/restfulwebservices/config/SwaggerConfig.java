package org.doInSpringBoot.restservices.restfulwebservices.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	public static final Contact DEFAULT_CONTACT = new Contact(
			"Dhiren Kumar Patra","www.facebook.com/DhirenKumar5","dhirenwipro@gmail.com");
	
	public static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = 
			new HashSet<String>(Arrays.asList("application/json","application/xml"));
	
	public static final ApiInfo API_INFOS = new ApiInfo("RestFul-Webservices", "A Simple Restful Webservice", 
			"V1.0", " termsOfServiceUrl ",
			DEFAULT_CONTACT, "Wipro-Roche-Collaboration", "http:/licenses.wipro.roche.google.scs.ac.in");
	
	public static final Set<String> PROTOCOLS = 
			new HashSet<String>(Arrays.asList("HTTP","HTTPS"));
	
	public SwaggerConfig() {}
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(API_INFOS)
				.produces(DEFAULT_PRODUCES_AND_CONSUMES)
				.consumes(DEFAULT_PRODUCES_AND_CONSUMES)
				.protocols(PROTOCOLS);
	}

}
