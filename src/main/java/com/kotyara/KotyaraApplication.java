package com.kotyara;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Slf4j
public class KotyaraApplication {
	Logger logger = LoggerFactory.getLogger(KotyaraApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KotyaraApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello() {
		logger.info("Hello world, Kotyara!");
		return "Hello world!";
	}
}
