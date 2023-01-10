package br.com.danielwisky.books.domains.exceptions;

import java.io.Serial;
import java.io.Serializable;

public class InternalServerErrorException extends RuntimeException implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  public InternalServerErrorException(final String message) {
    super(message);
  }
}