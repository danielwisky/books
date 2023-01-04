package br.com.danielwisky.books.gateways.outputs.kafka;

import br.com.danielwisky.books.domains.Book;
import br.com.danielwisky.books.gateways.outputs.BookAsyncGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookAsyncGatewayImpl implements BookAsyncGateway {

  private final KafkaTemplate<String, String> kafkaTemplate;

  @Override
  public void sendToFill(final Book book) {
    kafkaTemplate.send("fill-book-input", book.getId());
  }
}