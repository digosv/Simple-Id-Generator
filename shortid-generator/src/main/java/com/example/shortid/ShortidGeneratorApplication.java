package com.example.shortid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.example.shortid")
public class ShortidGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShortidGeneratorApplication.class, args);
	}

}
