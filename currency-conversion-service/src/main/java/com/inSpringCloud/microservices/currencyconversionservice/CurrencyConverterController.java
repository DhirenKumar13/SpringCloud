package com.inSpringCloud.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConverterController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CurrencyExchangeServiceProxy proxy;

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);

		ResponseEntity<CurrencyConversionBean> currencyConversionBeanResponse = new RestTemplate().getForEntity(
				"http://localhost:9000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,
				uriVariables);

		CurrencyConversionBean reponse = currencyConversionBeanResponse.getBody();
		
		if(reponse != null) {
			
			BigDecimal calculatedValue = reponse.getConversionMultiple().multiply(quantity);

			return new CurrencyConversionBean(reponse.getId(), from, to, reponse.getConversionMultiple(), quantity,
					calculatedValue, reponse.getServerPort());
			
		}else {
			
			BigDecimal calculatedValue = BigDecimal.valueOf(65).multiply(quantity);

			return new CurrencyConversionBean("ID", from, to, BigDecimal.valueOf(65), quantity,
					calculatedValue, 8000);
		}

	}
	
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		CurrencyConversionBean response = proxy.retrieveExchangeValue(from, to);
		
		logger.info("{} <-------" , response);
		
		if(response != null) {
			
			BigDecimal calculatedValue = response.getConversionMultiple().multiply(quantity);

			return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
					calculatedValue, response.getServerPort());
			
		}else {
			
			BigDecimal calculatedValue = BigDecimal.valueOf(65).multiply(quantity);

			return new CurrencyConversionBean("ID", from, to, BigDecimal.valueOf(65), quantity,
					calculatedValue, 8000);
		}

	}

}
