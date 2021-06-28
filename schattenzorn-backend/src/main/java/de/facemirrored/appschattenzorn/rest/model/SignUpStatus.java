package de.facemirrored.appschattenzorn.rest.model;

public enum SignUpStatus {

  SUCCESS("SUCCESS"),
  FAILED_EMAIL_TAKEN("FAILED_EMAIL_TAKEN"),
  FAILED_USERNAME_TAKEN("FAILED_USERNAME_TAKEN");

  private static final long serialVersionUID = 4577072031902899728L;

  private final String status;

  SignUpStatus(String status) {
    this.status = status;
  }

  public String getStatus() {
    return status;
  }
}
