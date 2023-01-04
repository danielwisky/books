package br.com.danielwisky.books.usecases;

import static br.com.danielwisky.books.domains.enums.Status.PENDING;

import br.com.danielwisky.books.domains.Book;
import br.com.danielwisky.books.gateways.outputs.BookAsyncGateway;
import br.com.danielwisky.books.gateways.outputs.BookDataGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreateBook {

  private final BookDataGateway bookDataGateway;
  private final BookAsyncGateway bookAsyncGateway;

  public Book execute(final Book book) {
    log.debug("create book: {}", book);
    book.setStatus(PENDING);

    final Book bookCreated = bookDataGateway.save(book);
    bookAsyncGateway.sendToFill(bookCreated);
    return bookCreated;
  }
}
