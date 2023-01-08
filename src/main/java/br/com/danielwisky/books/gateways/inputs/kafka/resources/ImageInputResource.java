package br.com.danielwisky.books.gateways.inputs.kafka.resources;

import static java.util.Optional.ofNullable;

import br.com.danielwisky.books.domains.Image;
import br.com.danielwisky.books.domains.enums.ImageType;
import java.io.Serial;
import java.io.Serializable;
import lombok.Data;

@Data
public class ImageInputResource implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private String url;
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
