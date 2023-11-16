package com.aubbiali.awesomepizza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AwesomePizzaApplication {

	public static void main(String[] args) {

		SpringApplication.run(AwesomePizzaApplication.class, args);
	}

}
