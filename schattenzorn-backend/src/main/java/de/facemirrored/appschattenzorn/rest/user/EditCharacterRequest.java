package de.facemirrored.appschattenzorn.rest.user;

import de.facemirrored.appschattenzorn.rest.model.Character;
import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EditCharacterRequest implements Serializable {

  private static final long serialVersionUID = -3919799824557002315L;

  private Character newCharacter;

  private Character oldCharacter;
}
