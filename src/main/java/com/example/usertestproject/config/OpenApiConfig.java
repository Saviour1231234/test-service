package com.example.usertestproject.config;


import io.swagger.v3.oas.models.media.StringSchema;
import org.bson.types.ObjectId;
import org.springdoc.core.SpringDocUtils;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    static {
        SpringDocUtils.getConfig().replaceWithSchema(ObjectId.class, new StringSchema());
    }

}