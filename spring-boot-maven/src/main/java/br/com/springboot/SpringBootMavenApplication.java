package br.com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Inicializa a aplicação Spring.
 */
@SpringBootApplication
public class SpringBootMavenApplication {

    /**
     * @param args
     *            Argumento via linha de comando
     */
    public static void main(final String[] args) {
        SpringApplication.run(SpringBootMavenApplication.class, args);
    }
}
