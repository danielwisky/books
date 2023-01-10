package br.com.danielwisky.books.usecases;

import static br.com.danielwisky.books.domains.enums.Status.ERROR;
import static br.com.danielwisky.books.domains.enums.Status.NOT_FILLED;
import static br.com.danielwisky.books.domains.enums.Status.SUCCESS;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

import br.com.danielwisky.books.domains.Book;
import br.com.danielwisky.books.gateways.outputs.BookDataGateway;
import br.com.danielwisky.books.gateways.outputs.ExternalBookGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class FillBook {

  private final BookDataGateway bookDataGateway;
  private final ExternalBookGateway externalBookGateway;

  public void execute(final Book book) {
    if (isNotBlank(book.getIsbn())) {
      fillBook(book);
    } else {
      book.setStatus(NOT_FILLED);
      book.setErrorMessage(null);
      bookDataGateway.save(book);
    }
  }

  private void fillBook(final Book book) {
    try {
      final var externalBook = externalBookGateway.findByIsbn(book.getIsbn());
      final var bookMerged = book.merge(externalBook);
      bookMerged.setStatus(SUCCESS);
      bookMerged.setErrorMessage(null);
      bookDataGateway.save(bookMerged);
    } catch (Exception ex) {
      book.setStatus(ERROR);
      book.setErrorMessage(ex.getMessage());
      bookDataGateway.save(book);
    }
  }
}
