package com.troytan.ymcake;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

@Component
@ApplicationPath("/rest")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig(){

        packages("com.troytan.ymcake.controller","com.troytan.ymcake.filter");
        register(JacksonJaxbJsonProvider.class);
    }
}
