package br.com.postech.techchallenge.adapters.exceptions;

import lombok.Data;

@Data
public class ApiError {

  private String error;

  private String message;

  private Integer status;

  public ApiError() {
  }

  public ApiError(String error, String message, Integer status) {
    this.error = error;
    this.message = message;
    this.status = status;
  }


}
