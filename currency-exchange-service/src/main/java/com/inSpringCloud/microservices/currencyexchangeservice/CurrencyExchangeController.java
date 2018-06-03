package com.inSpringCloud.microservices.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment environment; 
	
	@Autowired
	private ExchangeValueRepository repository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieceExchangeValue(@PathVariable String from ,
			@PathVariable String to) {
		
		String runningPort = environment.getProperty("local.server.port");
		
		ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
		
		logger.info("{} <------------------",exchangeValue);
		
		logger.info("{}", exchangeValue);
		
		exchangeValue.setServerPort(Integer.valueOf(runningPort));
		
		return exchangeValue;
	}
	
}
