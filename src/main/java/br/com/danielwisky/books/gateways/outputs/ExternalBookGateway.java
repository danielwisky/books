package br.com.danielwisky.books.gateways.outputs;

import br.com.danielwisky.books.domains.Book;
import java.util.Optional;

public interface ExternalBookGateway {

  Optional<Book> findByIsbn(String isbn);
}