package br.com.danielwisky.books.gateways.outputs.mongodb;

import br.com.danielwisky.books.domains.Book;
import br.com.danielwisky.books.gateways.outputs.BookDataGateway;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookDataMongoGateway implements BookDataGateway {

  @Override
  public Book save(final Book Book) {
    return null;
  }

  @Override
  public Optional<Book> findById(final String id) {
    return Optional.empty();
  }
}