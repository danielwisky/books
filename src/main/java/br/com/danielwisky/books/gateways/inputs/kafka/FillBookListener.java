package br.com.danielwisky.books.gateways.inputs.kafka;

import br.com.danielwisky.books.gateways.inputs.kafka.resources.BookInputResource;
import br.com.danielwisky.books.usecases.FillBook;
import br.com.danielwisky.books.utils.JsonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class FillBookListener {

  private final JsonUtils jsonUtils;
  private final FillBook fillBook;

  @KafkaListener(topics = "${spring.kafka.topics.fill-book}")
  public void receive(final String message) {
    try {
      log.info("reading the message: {}", message);
      final var resource = jsonUtils.toObject(message, BookInputResource.class);
      fillBook.execute(resource.toDomain());
    } catch (Exception ex) {
      log.error("error processing message: {}", message, ex);
    }
  }
}