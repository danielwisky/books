package br.com.danielwisky.books.gateways.outputs.mongodb.repositories;

import br.com.danielwisky.books.gateways.outputs.mongodb.documents.BookDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookMongoRepository extends MongoRepository<BookDocument, String> {

}
