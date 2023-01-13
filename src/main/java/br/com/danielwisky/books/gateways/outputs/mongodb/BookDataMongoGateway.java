package br.com.danielwisky.books.gateways.outputs.mongodb;

import br.com.danielwisky.books.domains.Book;
import br.com.danielwisky.books.gateways.outputs.BookDataGateway;
import br.com.danielwisky.books.gateways.outputs.mongodb.documents.BookDocument;
import br.com.danielwisky.books.gateways.outputs.mongodb.repositories.BookMongoRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookDataMongoGateway implements BookDataGateway {

  private final BookMongoRepository repository;

  @Override
  public Book save(final Book book) {
    return repository.save(new BookDocument(book)).toDomain();
  }

  @Override
  public Optional<Book> findById(final String id) {
    return repository.findById(id).map(BookDocument::toDomain);
  }

  @Override
  public Page<Book> findAll(final Pageable pageable) {
    return repository.findAll(pageable).map(BookDocument::toDomain);
  }
}