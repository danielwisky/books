package br.com.danielwisky.books.domains.exceptions;

import java.io.Serial;
import java.io.Serializable;

public class ResourceNotFoundException extends RuntimeException implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  public ResourceNotFoundException(final String message) {
    super(message);
  }
}