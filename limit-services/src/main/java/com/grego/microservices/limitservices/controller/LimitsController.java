package com.grego.microservices.limitservices.controller;

import com.grego.microservices.limitservices.configuration.Configuration;
import com.grego.microservices.limitservices.domain.Limits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    @Autowired
    private Configuration configuration;

    // CREATE A HARDCODED LIMIT CONTROLLER
    @GetMapping("/limits")
    public Limits retrieveLimits() {
        return new Limits(configuration.getMinimum(), configuration.getMaximum());
        //return new Limits(1, 1000);
    }


}
