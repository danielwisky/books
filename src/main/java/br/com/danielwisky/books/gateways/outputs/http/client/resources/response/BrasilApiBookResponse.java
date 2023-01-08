package br.com.danielwisky.books.gateways.outputs.http.client.resources.response;

import static br.com.danielwisky.books.domains.enums.ImageType.COVER;
import static java.util.Optional.ofNullable;

import br.com.danielwisky.books.domains.Book;
import br.com.danielwisky.books.domains.Image;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BrasilApiBookResponse implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private String isbn;
  private String title;
  private String subtitle;
  private List<String> authors;
  private String publisher;
  private String synopsis;
  private Integer year;
  private String format;
  @JsonProperty("page_count")
  private Integer pageCount;
  @JsonProperty("cover_url")
  private String coverUrl;

  private static Image buildCoverImage(final String url) {
    return Image.builder()
        .type(COVER)
        .url(url)
        .build();
  }

  public Book toDomain() {
    return Book.builder()
        .isbn(this.isbn)
        .title(this.title)
        .subtitle(this.subtitle)
        .publisher(this.publisher)
        .synopsis(this.synopsis)
        .authors(this.authors)
        .images(ofNullable(this.coverUrl)
            .map(BrasilApiBookResponse::buildCoverImage)
            .map(List::of)
            .orElse(null))
        .pageCount(this.pageCount)
        .build();
  }
}
