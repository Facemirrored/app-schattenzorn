package de.facemirrored.appschattenzorn.rest;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignInRequest {

  private static final long serialVersionUID = -6662800587812474376L;

  private String username;

  private String password;
}
