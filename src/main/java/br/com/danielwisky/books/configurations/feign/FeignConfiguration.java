package br.com.danielwisky.books.configurations.feign;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = {"br.com.danielwisky"})
public class FeignConfiguration {

}