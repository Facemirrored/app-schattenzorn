package de.facemirrored.appschattenzorn.model.ui;

import java.util.List;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class SignInResponse {

  private static final long serialVersionUID = -2442166907467798882L;

  private String token;

  private Long id;

  private String username;

  private String email;

  private List<String> role;
}
