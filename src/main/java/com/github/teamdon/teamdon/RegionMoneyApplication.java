package com.github.teamdon.teamdon;

import com.github.teamdon.teamdon.utils.KomoranBuilder;
import kr.co.shineware.nlp.komoran.core.Komoran;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaAuditing
@EnableScheduling
public class RegionMoneyApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegionMoneyApplication.class, args);
	}
}
