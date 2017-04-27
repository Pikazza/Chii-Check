package com.haochii.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class HaochiiApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(HaochiiApplication.class, args);
    }

    /**
     * This file is use to generate jar file for the spring boot class
     * 
     * @return SpringApplicationBuilder
     */
    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder application) {
        return application.sources(HaochiiApplication.class);
    }

    
}
