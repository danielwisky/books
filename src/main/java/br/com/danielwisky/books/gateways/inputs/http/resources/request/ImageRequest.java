package br.com.danielwisky.books.gateways.inputs.http.resources.request;

import static java.util.Optional.ofNullable;

import br.com.danielwisky.books.domains.Image;
import br.com.danielwisky.books.domains.enums.ImageType;
import java.io.Serial;
import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Data
public class ImageRequest implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @URL
  @NotBlank
  private String url;
  @NotBlank
  private String type;

  public Image toDomain() {
    return Image.builder()
        .url(this.url)
        .type(ofNullable(this.type)
            .map(ImageType::valueOf)
            .orElse(null))
        .build();
  }
}