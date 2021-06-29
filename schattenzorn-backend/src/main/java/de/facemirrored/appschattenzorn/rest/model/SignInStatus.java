package de.facemirrored.appschattenzorn.rest.model;

public enum SignInStatus {

  SUCCESS("SUCCESS"),
  FAILED("FAILED");

  private static final long serialVersionUID = -3279565259230027281L;

  private final String status;

  SignInStatus(String status) {
    this.status = status;
  }

  public String getStatus() {
    return status;
  }
}
