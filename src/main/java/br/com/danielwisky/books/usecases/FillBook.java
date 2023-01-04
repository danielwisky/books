package br.com.danielwisky.books.usecases;

import br.com.danielwisky.books.domains.Book;
import br.com.danielwisky.books.gateways.outputs.BookDataGateway;
import br.com.danielwisky.books.gateways.outputs.ExternalBookGateway;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class FillBook {

  private final BookDataGateway bookDataGateway;
  private final ExternalBookGateway externalBookGateway;

  public void execute(final String bookId) {
    bookDataGateway.findById(bookId).ifPresent(book -> {
      Optional<Book> externalBook = externalBookGateway.findByIsbn(book.getIsbn());
      log.info("external book: {}", externalBook.get());
    });
  }
}
