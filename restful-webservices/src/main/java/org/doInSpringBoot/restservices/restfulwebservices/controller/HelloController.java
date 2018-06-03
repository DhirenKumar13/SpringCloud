package org.doInSpringBoot.restservices.restfulwebservices.controller;

import java.util.Locale;

import org.doInSpringBoot.restservices.restfulwebservices.responsebeans.MyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@Autowired
	MessageSource messageSource;
	
	@GetMapping("/hi")
	public String sayHello() {
		return "Hello Dhiren !! From Spring Boot and Clouds " ;
	}
	
	@GetMapping("/hello")
	public MyModel sayHelloToModel() {
		MyModel model = new MyModel("Dhiren");
		return model;
	}
	
	@GetMapping("/hello/{name}")
	public MyModel sayHelloToModel(@PathVariable String name) {
		MyModel model = new MyModel(name);
		return model;
	}
	
	@GetMapping("/hey")
	public String sayHelloInternationalization(@RequestHeader (name="Accept-Language", required= false) Locale locale) {
		return messageSource.getMessage("morning.greeting", null, locale);
	}
	
	@GetMapping("/hey/again")
	public String sayHelloIAgainToInternationalization() {
		return messageSource.getMessage("morning.greeting", null, LocaleContextHolder.getLocale());
	}
	
}
