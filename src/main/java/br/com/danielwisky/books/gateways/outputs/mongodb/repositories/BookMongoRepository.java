package br.com.danielwisky.books.gateways.outputs.mongodb.repositories;

import br.com.danielwisky.books.gateways.outputs.mongodb.documents.BookDocument;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookMongoRepository extends MongoRepository<BookDocument, String> {

  Optional<BookDocument> findByIsbn(String isbn);

}
