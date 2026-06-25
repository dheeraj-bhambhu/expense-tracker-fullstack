package com.dheeraj.expensetracker.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI expenseTrackerAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("Expense Tracker API")
                        .version("1.0")
                        .description("REST API for Expense Tracker Application")
                        .contact(new Contact()
                                .name("Dheeraj Bhambhu")
                                .email("dheeraj@gmail.com")
                        ));
    }
}