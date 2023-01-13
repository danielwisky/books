package br.com.danielwisky.books.domains.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ErrorKey {
  FIELD_REQUIRED("msg.field.required"),
  PARAMETER_TYPE_MISMATCH_MESSAGE_KEY("msg.parameter.invalid.or.malformed"),
  BOOK_ALREADY_EXISTING("msg.book.already.existing"),
  BOOK_NOT_FOUND("msg.book.not.found");

  @Getter
  private final String key;
}