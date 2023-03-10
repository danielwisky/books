package br.com.danielwisky.books.usecases;

import static br.com.danielwisky.books.domains.enums.ErrorKey.BOOK_NOT_FOUND;

import br.com.danielwisky.books.domains.Book;
import br.com.danielwisky.books.domains.exceptions.i18n.I18NResourceNotFoundException;
import br.com.danielwisky.books.gateways.outputs.BookDataGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindBook {

  private final BookDataGateway bookDataGateway;

  public Book execute(final String id) {
    return bookDataGateway.findById(id)
        .orElseThrow(() -> new I18NResourceNotFoundException(BOOK_NOT_FOUND));
  }
}
