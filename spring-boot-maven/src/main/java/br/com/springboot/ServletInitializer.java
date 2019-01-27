package br.com.springboot;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Inicializa a aplicação Spring para deploy externo.
 */
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected final SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(SpringBootMavenApplication.class);
    }

}
