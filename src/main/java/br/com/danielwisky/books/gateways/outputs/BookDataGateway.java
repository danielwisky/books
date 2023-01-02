package br.com.danielwisky.books.gateways.outputs;

import br.com.danielwisky.books.domains.Book;
import java.util.Optional;

public interface BookDataGateway {

  Book save(Book Book);

  Optional<Book> findById(String id);
}