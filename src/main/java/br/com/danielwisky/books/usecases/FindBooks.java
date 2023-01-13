package br.com.danielwisky.books.usecases;

import br.com.danielwisky.books.domains.Book;
import br.com.danielwisky.books.gateways.outputs.BookDataGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindBooks {

  private final BookDataGateway bookDataGateway;

  public Page<Book> execute(final Pageable pageable) {
    return bookDataGateway.findAll(pageable);
  }
}