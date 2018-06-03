package com.inSpringCloud.microservices.limitsservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limits-service")
public class Configuration {
	
	private Integer minimum;
	private Integer maximum;
	
	public void setMinimum(Integer minimum) {
		this.minimum = minimum;
	}
	public void setMaximum(Integer maximum) {
		this.maximum = maximum;
	}
	public Integer getMinimum() {
		return minimum;
	}
	public Integer getMaximum() {
		return maximum;
	}
	
}
