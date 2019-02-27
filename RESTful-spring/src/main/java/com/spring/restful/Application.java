package com.spring.restful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Classe que inicializa aplicacao.
 */
@SpringBootApplication
@ImportResource("classpath*:**/applicationContext.xml")
@EnableScheduling
public class Application {
	
	/**
	 * Begins
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
