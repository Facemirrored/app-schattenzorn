package de.facemirrored.appschattenzorn.controller.exception;

public class RepoDataNotFoundException extends Exception {

  public RepoDataNotFoundException() {
    super();
  }

  public RepoDataNotFoundException(String msg) {
    super(msg);
  }

  public RepoDataNotFoundException(String msg, Throwable cause) {
    super(msg, cause);
  }
}
