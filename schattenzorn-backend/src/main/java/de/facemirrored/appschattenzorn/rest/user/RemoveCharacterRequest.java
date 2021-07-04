package de.facemirrored.appschattenzorn.rest.user;

import de.facemirrored.appschattenzorn.rest.model.Character;
import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RemoveCharacterRequest implements Serializable {

  private static final long serialVersionUID = 2359212369677273435L;

  Character character;
}
