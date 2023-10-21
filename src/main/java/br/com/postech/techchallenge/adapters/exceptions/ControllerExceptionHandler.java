package br.com.postech.techchallenge.adapters.exceptions;

import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.substringAfter;

import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;


@ControllerAdvice
@AllArgsConstructor
public class ControllerExceptionHandler {

  private static final Logger LOGGER = LoggerFactory.getLogger(ControllerExceptionHandler.class);
  private static final String ERROR_LABEL = "Error: Status Code: %s, with stack trace: {}";
  private static final String WARN_LABEL = "Warn: Status Code: %s, with stack trace: {}";
  private static final String STACK_TRACE_LABEL = "Internal error with stack trace: {}";


  @ExceptionHandler(NoHandlerFoundException.class)
  public ResponseEntity<ApiError> noHandlerFoundException(
      HttpServletRequest req, NoHandlerFoundException ex) {
    ApiError apiError =
        new ApiError(
            "route_not_found",
            format("Route %s not found", req.getRequestURI()),
            HttpStatus.NOT_FOUND.value());
    return ResponseEntity.status(apiError.getStatus()).body(apiError);
  }


  @ExceptionHandler(ApiException.class)
  protected ResponseEntity<ApiError> handleApiException(ApiException e) {
    Integer statusCode = e.getStatusCode();
    boolean expected = HttpStatus.INTERNAL_SERVER_ERROR.value() > statusCode;
    var stackTrace = ExceptionUtils.getStackTrace(e);
    String message;
    if (expected) {
      message = format(WARN_LABEL, statusCode);
      LOGGER.warn(message, stackTrace);
    } else {
      message = format(ERROR_LABEL, statusCode);
      LOGGER.error(message, stackTrace);
    }

    ApiError apiError = new ApiError(e.getCode(), e.getDescription(), statusCode);
    return ResponseEntity.status(apiError.getStatus()).body(apiError);
  }

  @ExceptionHandler(Exception.class)
  protected ResponseEntity<ApiError> handleUnknownException(Exception e) {
    var stackTrace = ExceptionUtils.getStackTrace(e);
    LOGGER.error(STACK_TRACE_LABEL, stackTrace);

    ApiError apiError = new ApiError(
        "internal_error", e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    return ResponseEntity.status(apiError.getStatus()).body(apiError);
  }


  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<List<ValidationError>> handleValidationExceptions(
      MethodArgumentNotValidException ex) {
    List<ValidationError> errors = new ArrayList<>();

    ex.getBindingResult().getAllErrors().forEach(currentError -> {
      ValidationError error = new ValidationError();
      error.setField(((FieldError) currentError).getField());
      error.setMessage(currentError.getDefaultMessage());
      if (((FieldError) currentError).getRejectedValue() != null) {
        error.setRejectedValue(((FieldError) currentError).getRejectedValue().toString());
      }
      errors.add(error);
    });
    var stacktrace = ExceptionUtils.getStackTrace(ex);
    var message = format(ERROR_LABEL, HttpStatus.BAD_REQUEST);
    LOGGER.error(message, stacktrace);
    return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<List<ValidationError>> handleConstraintValidationExceptions(
      ConstraintViolationException ex) {
    List<ValidationError> errors = new ArrayList<>();
    ex.getConstraintViolations().forEach(currentError -> {
      ValidationError error = new ValidationError();
      error.setField(substringAfter(currentError.getPropertyPath().toString(), "."));
      error.setMessage(currentError.getMessage());
      error.setRejectedValue(currentError.getInvalidValue().toString());
      errors.add(error);
    });
    var stacktrace = ExceptionUtils.getStackTrace(ex);
    var message = format(ERROR_LABEL, HttpStatus.BAD_REQUEST);
    LOGGER.error(message, stacktrace);
    return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
  }
}
