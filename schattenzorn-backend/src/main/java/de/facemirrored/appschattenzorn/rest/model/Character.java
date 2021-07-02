package de.facemirrored.appschattenzorn.rest.model;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Character implements Serializable {

  private static final long serialVersionUID = -3184351242992380191L;

  private String characterName;

  private boolean male;

  private int level;

  private String notes;
}
