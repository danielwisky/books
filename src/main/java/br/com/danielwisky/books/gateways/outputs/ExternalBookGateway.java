package br.com.danielwisky.books.gateways.outputs;

import br.com.danielwisky.books.domains.Book;

public interface ExternalBookGateway {

  Book findByIsbn(String isbn);
}