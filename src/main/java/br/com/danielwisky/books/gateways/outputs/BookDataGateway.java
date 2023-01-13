package br.com.danielwisky.books.gateways.outputs;

import br.com.danielwisky.books.domains.Book;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookDataGateway {

  Book save(Book Book);

  Optional<Book> findById(String id);

  Page<Book> findAll(Pageable pageable);
}