package br.com.danielwisky.books.domains;

import br.com.danielwisky.books.domains.enums.ImageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Image {

  private String url;
  private ImageType type;
}
