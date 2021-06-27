package de.facemirrored.appschattenzorn.model.ui;

public enum SignupStatus {

  SUCCESS("SUCCESS"),
  FAILED_EMAIL_TAKEN("FAILED_EMAIL_TAKEN"),
  FAILED_USERNAME_TAKEN("FAILED_USERNAME_TAKEN");

  private static final long serialVersionUID = 4577072031902899728L;

  private final String status;

  SignupStatus(String status) {
    this.status = status;
  }

  public String getStatus() {
    return status;
  }
}
