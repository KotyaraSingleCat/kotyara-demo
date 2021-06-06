package com.kotyara;

import com.kotyara.api.dto.MessageDTO;
import com.kotyara.configuration.BroadcastConfig;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import java.util.Date;


@EnableAdminServer
@SpringBootApplication
@Slf4j
public class KotyaraApplication extends SpringBootServletInitializer {
	private static String ROUTING_KEY_USER_IMPORTANT_WARN = "user.important.warn";
	private static String ROUTING_KEY_USER_IMPORTANT_ERROR = "user.important.error";

	public static void main(String[] args) {
		SpringApplication.run(KotyaraApplication.class, args);
	}

	@Bean
	public ApplicationRunner runner(RabbitTemplate rabbitTemplate) {
		MessageDTO message = new MessageDTO("1", "Hello world!", new Date(1, 1, 2011));
		return args -> {
			rabbitTemplate.convertAndSend(BroadcastConfig.FANOUT_EXCHANGE_NAME, "", message.toString());
			rabbitTemplate.convertAndSend(BroadcastConfig.TOPIC_EXCHANGE_NAME, ROUTING_KEY_USER_IMPORTANT_WARN, "topic important warn" + message);
			rabbitTemplate.convertAndSend(BroadcastConfig.TOPIC_EXCHANGE_NAME, ROUTING_KEY_USER_IMPORTANT_ERROR, "topic important error" + message);
		};
	}
}
