package br.com.postech.techchallenge.adapters.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends ApiException {

  public NotFoundException(Throwable e) {
    super(
        HttpStatus.NOT_FOUND.name(),
        HttpStatus.NOT_FOUND.getReasonPhrase(),
        HttpStatus.NOT_FOUND.value(),
        e);
  }

  public NotFoundException(String message) {
    super(
        HttpStatus.NOT_FOUND.name(),
        message,
        HttpStatus.NOT_FOUND.value());
  }

  public NotFoundException(String message, Throwable e) {
    super(HttpStatus.NOT_FOUND.name(), message, HttpStatus.NOT_FOUND.value(), e);
  }


}
