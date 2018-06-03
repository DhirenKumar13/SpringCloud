package org.doInSpringBoot.restservices.restfulwebservices.responsebeans;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFilter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonFilter("UserBeanFilter")
@ApiModel(description= "User Model Class")
public class UserBean {
	
	private Integer id;
	
	@NotEmpty
	@Size(min=2 , message="Name should be greater than 2 characters")
	@ApiModelProperty(notes = "Name should be greater than 2 characters")
	private String name;
	
	@PastOrPresent(message = "Should be atleast a date before today's")
	@ApiModelProperty(notes = "Should be atleast a date before today's")
	private Date dateOfBirth;
	
	public UserBean() {	}
	
	public UserBean(Integer id, String name, Date dateOfBirth) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + "]";
	}
	
}
