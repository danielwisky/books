package br.com.danielwisky.books.gateways.outputs.kafka.resources;

import static java.util.Optional.ofNullable;
import static org.apache.commons.collections4.CollectionUtils.emptyIfNull;

import br.com.danielwisky.books.domains.Book;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class BookOutputResource implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private String id;
  private String isbn;
  private String title;
  private String subtitle;
  private String publisher;
  private String synopsis;
  private List<String> authors;
  private List<ImageOutputResource> images;
  private Integer pageCount;
  private String status;
  private LocalDateTime createdDate;
  private LocalDateTime lastModifiedDate;

  public BookOutputResource(final Book book) {
    this.id = book.getId();
    this.isbn = book.getIsbn();
    this.title = book.getTitle();
    this.subtitle = book.getSubtitle();
    this.publisher = book.getPublisher();
    this.synopsis = book.getSynopsis();
    this.authors = book.getAuthors();
    this.images = emptyIfNull(book.getImages())
        .stream()
        .map(ImageOutputResource::new)
        .toList();
    this.pageCount = book.getPageCount();
    this.status = ofNullable(book.getStatus())
        .map(Enum::name)
        .orElse(null);
    this.createdDate = book.getCreatedDate();
    this.lastModifiedDate = book.getLastModifiedDate();
  }
}
