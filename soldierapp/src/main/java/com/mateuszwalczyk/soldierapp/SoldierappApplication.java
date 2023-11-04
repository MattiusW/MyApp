package com.mateuszwalczyk.soldierapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:barrack.properties")
public class SoldierappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoldierappApplication.class, args);
	}

}
