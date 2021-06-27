package de.facemirrored.appschattenzorn.model.ui;


import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class SignUpResponse {

  private static final long serialVersionUID = -4422169581228686255L;

  public SignUpResponse(SignUpStatus signupStatus) {
    this.signupStatus = signupStatus;
  }

  private SignUpStatus signupStatus;
}
