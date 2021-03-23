package com.kotyara;

import com.kotyara.api.dto.UserDTO;
import com.kotyara.api.entity.ActionPoints;
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
//		userService.create(new UserDTO("Karl", "Bash", "karlo4.ev@gmail.com", "123678", 2));
		List<User> users = userService.getAll();
		for(User user: users){
			log.info(String.format("\n Name: %s \n LastName: %s \n E-mail: %s \n Role: %s \n Action Points: ", user.getFirstName(), user.getLastName(), user.getEmail(),user.getRole().getRole()));
			for (ActionPoints actionPoint: user.getRole().getActionPoints()){
				log.info(actionPoint.getPoint().name());
			}
		}
	}
}
