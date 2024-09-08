package com.matrimonial.matrimonialapp;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log4j2
public class MatrimonialAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MatrimonialAppApplication.class, args);
		log.info("Matrimonial Application started successfully!");
	}

}

