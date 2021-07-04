package de.facemirrored.appschattenzorn.rest.user;

import de.facemirrored.appschattenzorn.rest.model.Character;
import de.facemirrored.appschattenzorn.rest.model.Status;
import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddCharacterResponse implements Serializable {

  private static final long serialVersionUID = -8695144393324300287L;

  private Status status;

  private Character character;
}
