package br.com.danielwisky.books.domains;

import static org.apache.commons.lang3.ObjectUtils.defaultIfNull;
import static org.apache.commons.lang3.StringUtils.defaultString;

import br.com.danielwisky.books.domains.enums.Status;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

  private String id;
  private String isbn;
  private String title;
  private String subtitle;
  private String publisher;
  private String synopsis;
  private List<String> authors;
  private List<Image> images;
  private Integer pageCount;
  private Status status;
  private String errorMessage;
  private LocalDateTime createdDate;
  private LocalDateTime lastModifiedDate;

  public Book merge(final Book book) {
    return Book.builder()
        .id(this.id)
        .isbn(defaultString(this.isbn, book.getIsbn()))
        .title(defaultString(this.title, book.getTitle()))
        .subtitle(defaultString(this.subtitle, book.getSubtitle()))
        .publisher(defaultString(this.publisher, book.getPublisher()))
        .synopsis(defaultString(this.synopsis, book.getSynopsis()))
        .authors(defaultIfNull(this.authors, book.getAuthors()))
        .images(defaultIfNull(this.images, book.getImages()))
        .pageCount(defaultIfNull(this.pageCount, book.getPageCount()))
        .status(this.status)
        .errorMessage(this.errorMessage)
        .createdDate(this.createdDate)
        .lastModifiedDate(this.lastModifiedDate)
        .build();
  }
}
