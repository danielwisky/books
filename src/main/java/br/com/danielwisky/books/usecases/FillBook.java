package br.com.danielwisky.books.usecases;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import br.com.danielwisky.books.domains.Book;
import br.com.danielwisky.books.gateways.outputs.BookDataGateway;
import br.com.danielwisky.books.gateways.outputs.ExternalBookGateway;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class FillBook {

  private final BookDataGateway bookDataGateway;
  private final ExternalBookGateway externalBookGateway;

  public void execute(final Book book) {

    if (isNotBlank(book.getIsbn())) {

      Optional<Book> byIsbn = externalBookGateway.findByIsbn(book.getIsbn());

      BeanUtils.copyProperties(byIsbn, book);
      log.info("book: {}", book);
      log.info("byIsbn: {}", byIsbn);

    }

  }
}
