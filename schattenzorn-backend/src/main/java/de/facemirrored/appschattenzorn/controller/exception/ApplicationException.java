package de.facemirrored.appschattenzorn.controller.exception;

public class ApplicationException extends RuntimeException {

  public ApplicationException() {
    super();
  }

  public ApplicationException(String msg) {
    super(msg);
  }

  public ApplicationException(String msg, Throwable cause) {
    super(msg, cause);
  }

}
