package com.applaudo.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableJpaAuditing
@EnableResourceServer
public class SnackStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnackStoreApplication.class, args);
	}
}
