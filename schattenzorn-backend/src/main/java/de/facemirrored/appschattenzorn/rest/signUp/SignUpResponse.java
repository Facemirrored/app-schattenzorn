package de.facemirrored.appschattenzorn.rest.signUp;


import de.facemirrored.appschattenzorn.rest.model.SignUpStatus;
import java.io.Serializable;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class SignUpResponse implements Serializable {

  private static final long serialVersionUID = -4422169581228686255L;

  public SignUpResponse(SignUpStatus signupStatus) {
    this.signupStatus = signupStatus;
  }

  private SignUpStatus signupStatus;

}
