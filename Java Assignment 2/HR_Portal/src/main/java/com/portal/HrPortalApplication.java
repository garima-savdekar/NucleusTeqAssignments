package com.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.portal.model")
@SpringBootApplication
public class HrPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrPortalApplication.class, args);
	}

}
