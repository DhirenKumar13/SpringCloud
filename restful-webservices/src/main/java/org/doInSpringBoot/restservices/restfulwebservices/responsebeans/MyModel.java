package org.doInSpringBoot.restservices.restfulwebservices.responsebeans;

public class MyModel {
	
	private String name;

	public MyModel(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MyModel [name=" + name + "]";
	}
	
}
