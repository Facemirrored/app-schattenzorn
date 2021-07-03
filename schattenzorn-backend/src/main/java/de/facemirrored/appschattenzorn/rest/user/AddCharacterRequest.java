package de.facemirrored.appschattenzorn.rest.user;

import de.facemirrored.appschattenzorn.rest.model.Character;
import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddCharacterRequest implements Serializable {

  private static final long serialVersionUID = -1605691456904006571L;

  private Character character;
}
