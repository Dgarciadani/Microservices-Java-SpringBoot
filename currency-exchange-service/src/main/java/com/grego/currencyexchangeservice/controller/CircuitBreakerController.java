package com.grego.currencyexchangeservice.controller;

import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
public class CircuitBreakerController {
    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
    // naming with a personalized name
    @Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
    //@Retry(name = "default")
    // by default the method try 3 times
    public String sampleApi(){
        logger.info("Sample API Call");
        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost8080/some-dummy-url", String.class);

        return forEntity.getBody();
    }
// we need to add a parameter Exception
    public String hardcodedResponse(Exception ex){
        return "fallback response";
    }
}
