package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		Logger logger = LogManager.getLogger(DemoApplication.class);
		SpringApplication.run(DemoApplication.class, args);
		logger.info("Welcome info");
		logger.warn("Welcome warn");
		logger.debug("Welcome debug");
		logger.error("Welcome error");
		logger.info("Welcome");
	}

}
