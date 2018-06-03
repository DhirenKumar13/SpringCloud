package org.doInSpringBoot.restservices.restfulwebservices.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.doInSpringBoot.restservices.restfulwebservices.dao.UserDao;
import org.doInSpringBoot.restservices.restfulwebservices.exceptions.UserNotFoundException;
import org.doInSpringBoot.restservices.restfulwebservices.responsebeans.User;
import org.doInSpringBoot.restservices.restfulwebservices.responsebeans.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class UserController {
	
	@Autowired
	private UserDao service;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	@GetMapping("/users-filtered")
	public MappingJacksonValue retrieveAllUsersWithFilter(){
		List<UserBean> user = service.findAllUserBean();
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id","name");
		FilterProvider provider = new SimpleFilterProvider().addFilter("UserBeanFilter", filter);
		MappingJacksonValue valueMapper = new MappingJacksonValue(user);
		valueMapper.setFilters(provider);
		return valueMapper;
	}
	
	//Filtering the response by removing extra fields like (Dob)
	@GetMapping("/user/filtered/{id}")
	public MappingJacksonValue retrieveFilteredUser(@PathVariable Integer id) {
		UserBean user = service.findOneBean(id);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id","name");
		FilterProvider provider = new SimpleFilterProvider().addFilter("UserBeanFilter", filter);
		MappingJacksonValue valueMapper = new MappingJacksonValue(user);
		valueMapper.setFilters(provider);
		
		if("Default".equals(user.getName()))
			throw new UserNotFoundException("id-"+id);
		else {
			return valueMapper;
		}
	}
	
	@GetMapping("/user/{id}")
	public Resource<User> retrieveUser(@PathVariable Integer id) {
		User user = service.findOne(id);
		
		Resource<User> userResource = new Resource<>(user);
		
		if("Default".equals(user.getName()))
			throw new UserNotFoundException("id-"+id);
		else {
			ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
			userResource.add(linkTo.withRel("get-all-users"));
			return userResource;
		}
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable Integer id) {
		User user = service.deleteOne(id);
		if(user == null) {
			throw new UserNotFoundException("_id :"+id);
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user){
		User userSaved =  service.save(user);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
								   .path("/{id}")
								   .buildAndExpand(userSaved.getId())
								   .toUri();
		
		return ResponseEntity.created(uri).build();
	}
}
