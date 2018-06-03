package org.doInSpringBoot.restservices.restfulwebservices.controller;

import org.doInSpringBoot.restservices.restfulwebservices.responsebeans.Name;
import org.doInSpringBoot.restservices.restfulwebservices.responsebeans.PeopleVersion1;
import org.doInSpringBoot.restservices.restfulwebservices.responsebeans.PeopleVersion2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

	@GetMapping("/person/v1")
	public PeopleVersion1 urlPersonV1() {
		return new PeopleVersion1("Dhiren Kumar",24);
	}
	
	@GetMapping("/person/v2")
	public PeopleVersion2 urlPersonV2() {
		return new PeopleVersion2(new Name("Dhiren", "Kumar"),24);
	}
	
	@GetMapping(value = "/person/version" , params="version-1")
	public PeopleVersion1 parameterPersonV1() {
		return new PeopleVersion1("Dhiren Kumar",24);
	}
	
	@GetMapping(value = "/person/version" , params="version-2")
	public PeopleVersion2 parameterPersonV2() {
		return new PeopleVersion2(new Name("Dhiren", "Kumar"),24);
	}
	
	@GetMapping(value = "/person/header" , headers="API_PERSON_VERSION=V1")
	public PeopleVersion1 headerPersonV1() {
		return new PeopleVersion1("Dhiren Kumar",24);
	}
	
	@GetMapping(value = "/person/header" , headers="API_PERSON_VERSION=V2")
	public PeopleVersion2 headerPersonV2() {
		return new PeopleVersion2(new Name("Dhiren", "Kumar"),24);
	}
	
	@GetMapping(value = "/person/produces" , produces="application/vnd.person-v1+json")
	public PeopleVersion1 prodecesPersonV1() {
		return new PeopleVersion1("Dhiren Kumar",24);
	}
	
	@GetMapping(value = "/person/produces" , produces="application/person.v2+json")
	public PeopleVersion2 prodecesPersonV2() {
		return new PeopleVersion2(new Name("Dhiren", "Kumar"),24);
	}
	
}
