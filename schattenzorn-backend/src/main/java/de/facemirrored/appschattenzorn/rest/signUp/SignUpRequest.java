package de.facemirrored.appschattenzorn.rest.signUp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignUpRequest {

  private static final long serialVersionUID = -8398323363172976070L;

  private String password;

  private String username;

  private String email;
}
