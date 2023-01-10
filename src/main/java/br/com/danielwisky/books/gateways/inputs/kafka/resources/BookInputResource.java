package br.com.danielwisky.books.gateways.inputs.kafka.resources;

import static java.util.Optional.ofNullable;
import static org.apache.commons.collections4.CollectionUtils.emptyIfNull;

import br.com.danielwisky.books.domains.Book;
import br.com.danielwisky.books.domains.enums.Status;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class BookInputResource implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private String id;
  private String isbn;
  private String title;
  private String subtitle;
  private String publisher;
  private String synopsis;
  private List<String> authors;
  private List<ImageInputResource> images;
  private Integer pageCount;

  private String status;
  private LocalDateTime createdDate;
  private LocalDateTime lastModifiedDate;

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
            .map(ImageInputResource::toDomain)
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
