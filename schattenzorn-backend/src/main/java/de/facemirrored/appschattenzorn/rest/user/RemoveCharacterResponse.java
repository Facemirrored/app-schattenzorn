package de.facemirrored.appschattenzorn.rest.user;

import de.facemirrored.appschattenzorn.rest.model.Status;
import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RemoveCharacterResponse implements Serializable {

  private static final long serialVersionUID = -4997190332395653472L;

  private Status status;

}
