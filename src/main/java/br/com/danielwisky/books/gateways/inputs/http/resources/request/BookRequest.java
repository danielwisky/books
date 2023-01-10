package br.com.danielwisky.books.gateways.inputs.http.resources.request;

import static org.apache.commons.collections4.CollectionUtils.emptyIfNull;

import br.com.danielwisky.books.domains.Book;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import javax.validation.Valid;
import lombok.Data;
import org.hibernate.validator.constraints.ISBN;

@Data
public class BookRequest implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @ISBN
  private String isbn;
  private String title;
  private String subtitle;
  private String publisher;
  private String synopsis;
  private List<String> authors;
  @Valid
  private List<ImageRequest> images;
  private Integer pageCount;

  public Book toDomain() {
    return Book.builder()
        .isbn(this.isbn)
        .title(this.title)
        .subtitle(this.subtitle)
        .publisher(this.publisher)
        .synopsis(this.synopsis)
        .authors(this.authors)
        .images(emptyIfNull(this.images)
            .stream()
            .map(ImageRequest::toDomain)
            .toList())
        .pageCount(this.pageCount)
        .build();
  }
}