package com.java.jersey.custom;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

/**
 * Cabecalho customizado.
 */
public class SetHeader implements ContainerResponseFilter {

    @Override
    public final void filter(final ContainerRequestContext requestContext,
            final ContainerResponseContext responseContext) throws IOException {
        System.out.println("This is my filter.");
        responseContext.getHeaders().add("Custom-Header", "My App");
    }

}
