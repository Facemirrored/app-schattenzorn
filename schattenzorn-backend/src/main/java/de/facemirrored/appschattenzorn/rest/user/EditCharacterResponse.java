package de.facemirrored.appschattenzorn.rest.user;

import de.facemirrored.appschattenzorn.rest.model.Character;
import de.facemirrored.appschattenzorn.rest.model.Status;
import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EditCharacterResponse implements Serializable {

  private static final long serialVersionUID = -1575970750751886533L;

  private Status status;

  private Character character;
}
