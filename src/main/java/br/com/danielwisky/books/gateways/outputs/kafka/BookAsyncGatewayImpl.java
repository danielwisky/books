package br.com.danielwisky.books.gateways.outputs.kafka;

import br.com.danielwisky.books.domains.Book;
import br.com.danielwisky.books.gateways.outputs.BookAsyncGateway;
import br.com.danielwisky.books.gateways.outputs.kafka.resources.BookOutputResource;
import br.com.danielwisky.books.utils.JsonUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookAsyncGatewayImpl implements BookAsyncGateway {

  private final KafkaTemplate<String, String> kafkaTemplate;
  private final JsonUtils jsonUtils;
  @Value("${spring.kafka.topics.fill-book}")
  private String topicFillBook;

  @Override
  public void sendToFill(final Book book) {
    final String message = jsonUtils.toJson(new BookOutputResource(book));
    kafkaTemplate.send(topicFillBook, book.getId(), message);
  }
}