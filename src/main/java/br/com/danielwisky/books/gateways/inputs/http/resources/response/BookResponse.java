package br.com.danielwisky.books.gateways.inputs.http.resources.response;

import br.com.danielwisky.books.domains.Book;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private String id;
  private String isbn;
  private String title;
  private String subtitle;
  private String publisher;
  private String synopsis;
  private List<String> authors;
  private List<String> images;
  private Integer pageCount;
  private LocalDateTime createdDate;
  private LocalDateTime lastModifiedDate;

  public BookResponse(final Book book) {
    this.id = book.getId();
    this.isbn = book.getIsbn();
    this.title = book.getTitle();
    this.subtitle = book.getSubtitle();
    this.publisher = book.getPublisher();
    this.synopsis = book.getSynopsis();
    this.authors = book.getAuthors();
    this.images = book.getImages();
    this.pageCount = book.getPageCount();
    this.createdDate = book.getCreatedDate();
    this.lastModifiedDate = book.getLastModifiedDate();
  }
}