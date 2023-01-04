package br.com.danielwisky.books.gateways.outputs.http.client.resources.response;

import br.com.danielwisky.books.domains.Book;
import br.com.danielwisky.books.domains.Image;
import br.com.danielwisky.books.domains.enums.ImageType;
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

  public Book toDomain() {
    return Book.builder()
        .isbn(this.isbn)
        .title(this.title)
        .subtitle(this.subtitle)
        .publisher(this.publisher)
        .synopsis(this.synopsis)
        .authors(this.authors)
        .images(List.of(Image.builder().type(ImageType.COVER).url(this.coverUrl).build()))
        .pageCount(this.pageCount)
        .build();
  }
}
