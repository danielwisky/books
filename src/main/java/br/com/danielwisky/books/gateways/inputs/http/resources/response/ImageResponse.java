package br.com.danielwisky.books.gateways.inputs.http.resources.response;

import static java.util.Optional.ofNullable;

import br.com.danielwisky.books.domains.Image;
import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageResponse implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private String url;
  private String type;

  public ImageResponse(final Image image) {
    this.url = image.getUrl();
    this.type = ofNullable(image.getType())
        .map(Enum::name)
        .orElse(null);
  }
}
