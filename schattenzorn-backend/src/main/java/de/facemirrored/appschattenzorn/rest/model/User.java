package de.facemirrored.appschattenzorn.rest.model;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

  private static final long serialVersionUID = 5016780977960413180L;

  private String username;

  private String email;

  private List<String> roles;
}
