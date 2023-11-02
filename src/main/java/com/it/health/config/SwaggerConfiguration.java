package com.it.health.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfiguration {
	
	@Bean
	  public OpenAPI trouxOpenAPI() {
	      return new OpenAPI()
	              .info(new Info().title("Health Portal Service")
	              .description("Health Portal Service")
	              .version("v1.0"));
	  }

}