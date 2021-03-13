package com.kotyara;

import com.kotyara.api.entity.User;
import com.kotyara.api.entity.UserRole;
import com.kotyara.api.service.AbstractService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
@Slf4j
public class KotyaraApplication {

	@Autowired
	private AbstractService userService;

	public static void main(String[] args) {
		SpringApplication.run(KotyaraApplication.class, args);
	}

	@PostConstruct
	public void postConstruct() {
		List<User> users = userService.getAll();
		for(User user: users){
			log.info(String.format("\n Name: %s \n LastName: %s \n E-mail: %s", user.getFirstName(), user.getSecondName(), user.getEmail()));
		}
	}
}
