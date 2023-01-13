package br.com.danielwisky.books.gateways.outputs.mongodb.documents;

import static java.util.Optional.ofNullable;
import static org.apache.commons.collections4.CollectionUtils.emptyIfNull;

import br.com.danielwisky.books.domains.Book;
import br.com.danielwisky.books.domains.enums.Status;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "books")
public class BookDocument {

  @Id
  private String id;
  @Indexed(unique = true, sparse = true)
  private String isbn;
  private String title;
  private String subtitle;
  private String publisher;
  private String synopsis;
  private List<String> authors;
  private List<ImageDocument> images;
  private Integer pageCount;
  private String status;
  private String errorMessage;
  @CreatedDate
  private LocalDateTime createdDate;
  @LastModifiedDate
  private LocalDateTime lastModifiedDate;

  public BookDocument(final Book book) {
    this.id = book.getId();
    this.isbn = book.getIsbn();
    this.title = book.getTitle();
    this.subtitle = book.getSubtitle();
    this.publisher = book.getPublisher();
    this.synopsis = book.getSynopsis();
    this.authors = book.getAuthors();
    this.images = emptyIfNull(book.getImages())
        .stream()
        .map(ImageDocument::new)
        .toList();
    this.pageCount = book.getPageCount();
    this.status = ofNullable(book.getStatus())
        .map(Enum::name)
        .orElse(null);
    this.errorMessage = book.getErrorMessage();
    this.createdDate = book.getCreatedDate();
    this.lastModifiedDate = book.getLastModifiedDate();
  }

  public Book toDomain() {
    return Book.builder()
        .id(this.id)
        .isbn(this.isbn)
        .title(this.title)
        .subtitle(this.subtitle)
        .publisher(this.publisher)
        .synopsis(this.synopsis)
        .authors(this.authors)
        .images(emptyIfNull(this.images)
            .stream()
            .map(ImageDocument::toDomain)
            .toList())
        .pageCount(this.pageCount)
        .status(ofNullable(this.status)
            .map(Status::valueOf)
            .orElse(null))
        .createdDate(this.createdDate)
        .lastModifiedDate(this.lastModifiedDate)
        .build();
  }
}