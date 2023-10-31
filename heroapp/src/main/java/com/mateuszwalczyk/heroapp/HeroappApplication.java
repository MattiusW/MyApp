package com.mateuszwalczyk.heroapp;

import com.mateuszwalczyk.heroapp.controller.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HeroappApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeroappApplication.class, args);
	}

}
