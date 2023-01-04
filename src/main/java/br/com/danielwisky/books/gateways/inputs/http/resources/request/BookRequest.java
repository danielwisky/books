package br.com.danielwisky.books.gateways.inputs.http.resources.request;

import br.com.danielwisky.books.domains.Book;
import java.io.Serial;
import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.ISBN;

@Data
public class BookRequest implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @ISBN
  @NotBlank
  private String isbn;
  private String title;

  public Book toDomain() {
    return Book.builder()
        .isbn(this.isbn)
        .title(this.title)
        .build();
  }
}