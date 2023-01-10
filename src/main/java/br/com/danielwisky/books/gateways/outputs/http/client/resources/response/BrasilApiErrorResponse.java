package br.com.danielwisky.books.gateways.outputs.http.client.resources.response;

import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BrasilApiErrorResponse implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private String name;
  private String message;
  private String type;
}
