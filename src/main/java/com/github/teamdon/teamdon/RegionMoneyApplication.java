package com.github.teamdon.teamdon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RegionMoneyApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegionMoneyApplication.class, args);
	}
}
