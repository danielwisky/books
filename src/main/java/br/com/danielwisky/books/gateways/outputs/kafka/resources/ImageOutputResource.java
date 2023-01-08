package br.com.danielwisky.books.gateways.outputs.kafka.resources;

import static java.util.Optional.ofNullable;

import br.com.danielwisky.books.domains.Image;
import java.io.Serial;
import java.io.Serializable;
import lombok.Data;

@Data
public class ImageOutputResource implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private String url;
  private String type;

  public ImageOutputResource(final Image image) {
    this.url = image.getUrl();
    this.type = ofNullable(image.getType())
        .map(Enum::name)
        .orElse(null);
  }
}
