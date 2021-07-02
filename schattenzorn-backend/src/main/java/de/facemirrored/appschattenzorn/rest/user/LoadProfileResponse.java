package de.facemirrored.appschattenzorn.rest.user;

import de.facemirrored.appschattenzorn.rest.model.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoadProfileResponse {

  private static final long serialVersionUID = 8442327248843750759L;

  private User user;
}
