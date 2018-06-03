package org.doInSpringBoot.restservices.restfulwebservices.responsebeans;

public class PeopleVersion2 {
	
	private Name name;
	private Integer age;

	public PeopleVersion2() {	}

	public PeopleVersion2(Name name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
}
