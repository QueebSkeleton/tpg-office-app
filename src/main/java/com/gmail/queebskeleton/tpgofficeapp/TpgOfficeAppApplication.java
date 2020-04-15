package com.gmail.queebskeleton.tpgofficeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class TpgOfficeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TpgOfficeAppApplication.class, args);
	}

}
