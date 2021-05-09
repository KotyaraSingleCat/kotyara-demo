package com.kotyara;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@EnableAdminServer
@SpringBootApplication
@Slf4j
public class KotyaraApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(KotyaraApplication.class, args);
	}
}
