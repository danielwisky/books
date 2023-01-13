package br.com.danielwisky.books.usecases;

import static br.com.danielwisky.books.domains.enums.ErrorKey.BOOK_NOT_FOUND;

import br.com.danielwisky.books.domains.Book;
import br.com.danielwisky.books.domains.exceptions.i18n.I18NResourceNotFoundException;
import br.com.danielwisky.books.gateways.outputs.BookAsyncGateway;
import br.com.danielwisky.books.gateways.outputs.BookDataGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UpdateBook {

  private final BookDataGateway bookDataGateway;
  private final BookAsyncGateway bookAsyncGateway;

  public Book execute(final String id, final Book book) {
    log.debug("update book: {} with id: {}", book, id);
    final var bookData = bookDataGateway.findById(id)
        .orElseThrow(() -> new I18NResourceNotFoundException(BOOK_NOT_FOUND));

    book.setId(bookData.getId());
    book.setCreatedDate(bookData.getCreatedDate());

    final var bookUpdated = bookDataGateway.save(book);
    bookAsyncGateway.sendToFill(bookUpdated);
    return bookUpdated;
  }
}