package br.com.danielwisky.books.gateways.inputs.kafka;

import br.com.danielwisky.books.usecases.FillBook;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FillBookListener {

  private final FillBook fillBook;

  @KafkaListener(topics = "fill-book-input")
  public void receive(final String message) {
    fillBook.execute(message);
  }
}