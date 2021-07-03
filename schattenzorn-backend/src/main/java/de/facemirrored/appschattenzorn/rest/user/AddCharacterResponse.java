package de.facemirrored.appschattenzorn.rest.user;

import de.facemirrored.appschattenzorn.rest.model.AddCharacterResponseStatus;
import de.facemirrored.appschattenzorn.rest.model.Character;
import java.io.Serializable;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class AddCharacterResponse implements Serializable {

  private static final long serialVersionUID = -8695144393324300287L;

  private AddCharacterResponseStatus status;

  private Character character;
}
