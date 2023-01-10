package br.com.danielwisky.books.gateways.outputs.http.client;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class BrasilApiConfiguration {

  @Bean
  public ErrorDecoder errorDecoder() {
    return new BrasilApiErrorDecoder();
  }
}
