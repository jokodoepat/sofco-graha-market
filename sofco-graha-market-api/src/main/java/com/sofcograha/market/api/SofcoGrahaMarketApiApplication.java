package com.sofcograha.market.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
		scanBasePackages = {
				"com.sofcograha.market.api",
				"com.sofcograha.market.model"
		}
)

@ComponentScan(
		basePackages = {
				"com.sofcograha.market.api.controller",
				"com.sofcograha.market.model.service",
		}
)
@EnableJpaRepositories(
		basePackages = {
				"com.sofcograha.market.model.repository"
		}
)
@EntityScan(
		basePackages = {
				"com.sofcograha.market.model"
		}
)

public class SofcoGrahaMarketApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SofcoGrahaMarketApiApplication.class, args);
	}

}
