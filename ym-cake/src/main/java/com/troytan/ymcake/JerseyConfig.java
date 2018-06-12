package com.troytan.ymcake;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.troytan.ymcake.controller.AddrController;
import com.troytan.ymcake.controller.CommentController;
import com.troytan.ymcake.controller.ContactController;
import com.troytan.ymcake.controller.OrderController;
import com.troytan.ymcake.controller.ProductController;
import com.troytan.ymcake.controller.ShopcartController;
import com.troytan.ymcake.controller.UserController;
import com.troytan.ymcake.filter.JacksonObjectMapperProvider;

@Component
@ApplicationPath("/rest")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig(){

        // packages("com.troytan.ymcake.controller","com.troytan.ymcake.filter");
        register(AddrController.class);
        register(CommentController.class);
        register(ContactController.class);
        register(OrderController.class);
        register(ProductController.class);
        register(ShopcartController.class);
        register(UserController.class);
        register(JacksonObjectMapperProvider.class);
        register(JacksonJaxbJsonProvider.class);
    }
}
