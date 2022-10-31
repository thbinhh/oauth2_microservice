package com.example.oauthserver;

import com.example.oauthserver.repository.ClientRepository;
import com.example.oauthserver.service.CustomClientDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.provider.ClientRegistrationException;

@EnableEurekaClient
@SpringBootApplication
public class OauthserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthserverApplication.class, args);
	}

}
