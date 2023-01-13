package br.com.danielwisky.books.domains.exceptions.i18n;

import br.com.danielwisky.books.domains.enums.ErrorKey;
import java.io.Serial;
import java.io.Serializable;
import org.springframework.http.HttpStatus;

public class I18NBusinessLogicException extends I18NRuntimeException implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  public I18NBusinessLogicException(final ErrorKey errorKey, final Object... params) {
    super(errorKey, params);
  }

  @Override
  public HttpStatus getHttpStatus() {
    return HttpStatus.BAD_REQUEST;
  }
}