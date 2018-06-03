package com.inSpringCloud.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, String> {
	
	public ExchangeValue findByFromAndTo(String from,String to);
	
}
