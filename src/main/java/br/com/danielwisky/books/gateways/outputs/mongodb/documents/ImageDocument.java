package br.com.danielwisky.books.gateways.outputs.mongodb.documents;

import static java.util.Optional.ofNullable;

import br.com.danielwisky.books.domains.Image;
import br.com.danielwisky.books.domains.enums.ImageType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ImageDocument {

  private String url;
  private String type;

  public ImageDocument(final Image image) {
    this.url = image.getUrl();
    this.type = ofNullable(image.getType())
        .map(Enum::name)
        .orElse(null);
  }

  public Image toDomain() {
    return Image.builder()
        .url(this.url)
        .type(ofNullable(this.type)
            .map(ImageType::valueOf)
            .orElse(null))
        .build();
  }
}