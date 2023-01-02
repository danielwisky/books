package br.com.danielwisky.books.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {

  @Bean
  public OpenAPI apiInfo() {
    return new OpenAPI().info(new Info().title("Books").version("1.0.0"));
  }
}