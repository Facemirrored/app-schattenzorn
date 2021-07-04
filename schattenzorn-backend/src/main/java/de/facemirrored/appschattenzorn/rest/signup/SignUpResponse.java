package de.facemirrored.appschattenzorn.rest.signup;


import de.facemirrored.appschattenzorn.rest.model.Status;
import java.io.Serializable;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class SignUpResponse implements Serializable {

  private static final long serialVersionUID = -4422169581228686255L;

  public SignUpResponse(Status signupStatus) {
    this.signupStatus = signupStatus;
  }

  private Status signupStatus;

}
