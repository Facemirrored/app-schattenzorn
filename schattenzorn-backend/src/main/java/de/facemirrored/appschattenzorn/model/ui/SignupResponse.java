package de.facemirrored.appschattenzorn.model.ui;


import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class SignupResponse {

  private static final long serialVersionUID = -4422169581228686255L;

  public SignupResponse(SignupStatus signupStatus) {
    this.signupStatus = signupStatus;
  }

  private SignupStatus signupStatus;
}
