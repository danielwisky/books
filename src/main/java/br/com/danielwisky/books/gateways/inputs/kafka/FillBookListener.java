package br.com.danielwisky.books.gateways.inputs.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FillBookListener {

  @KafkaListener(topics = "fill-book-input")
  public void receive(final String message) {

  }
}