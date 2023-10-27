package br.com.postech.techchallenge.application.core.exceptions;

import br.com.postech.techchallenge.adapters.exceptions.ApiException;
import org.springframework.http.HttpStatus;


public class ConflictException extends ApiException {

  public ConflictException(Throwable e) {
    super(
        HttpStatus.CONFLICT.name(),
        HttpStatus.CONFLICT.getReasonPhrase(),
        HttpStatus.CONFLICT.value(),
        e);
  }

  public ConflictException(String message) {
    super(
        HttpStatus.CONFLICT.name(),
        message,
        HttpStatus.CONFLICT.value());
  }

  public ConflictException(String message, Throwable e) {
    super(HttpStatus.BAD_REQUEST.name(), message, HttpStatus.CONFLICT.value(), e);
  }


}
