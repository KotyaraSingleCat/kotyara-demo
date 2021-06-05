package com.kotyara;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAdminServer
@SpringBootApplication
@Slf4j
public class KotyaraApplication extends SpringBootServletInitializer {
	
	@RequestMapping("/")
	@ResponseBody
	String home(){
		return "Hello world!";
	}

	public static void main(String[] args) {
		SpringApplication.run(KotyaraApplication.class, args);
	}
}
