package de.facemirrored.appschattenzorn.model.ui;

import javax.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequest {

  private static final long serialVersionUID = -6662800587812474376L;

  @NotBlank
  private String username;

  @NotBlank
  private String password;
}
