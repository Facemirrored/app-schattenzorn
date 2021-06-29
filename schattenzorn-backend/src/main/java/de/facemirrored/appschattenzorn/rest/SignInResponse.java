package de.facemirrored.appschattenzorn.rest;

import de.facemirrored.appschattenzorn.rest.model.SignInStatus;
import de.facemirrored.appschattenzorn.rest.model.User;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class SignInResponse {

  private static final long serialVersionUID = -2442166907467798882L;

  private SignInStatus signInStatus;

  private User user;

  private String token;
}
