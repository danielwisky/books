package br.com.danielwisky.books.gateways.inputs.http.resources.response;

import static java.util.Optional.ofNullable;
import static org.apache.commons.collections4.CollectionUtils.emptyIfNull;

import br.com.danielwisky.books.domains.Book;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
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
@JsonInclude(Include.NON_EMPTY)
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
  private List<ImageResponse> images;
  private Integer pageCount;
  private String status;
  private String errorMessage;
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
    this.images = emptyIfNull(book.getImages())
        .stream()
        .map(ImageResponse::new)
        .toList();
    this.pageCount = book.getPageCount();
    this.status = ofNullable(book.getStatus())
        .map(Enum::name)
        .orElse(null);
    this.errorMessage = book.getErrorMessage();
    this.createdDate = book.getCreatedDate();
    this.lastModifiedDate = book.getLastModifiedDate();
  }
}