package de.facemirrored.appschattenzorn.rest.signup;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest implements Serializable {

  private static final long serialVersionUID = -8398323363172976070L;

  private String password;

  private String username;

  private String email;
}
