package de.facemirrored.appschattenzorn.rest.model;

import de.facemirrored.appschattenzorn.database.EPlayerClass;
import de.facemirrored.appschattenzorn.database.EPlayerRace;
import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RaceClassCombination implements Serializable {

  private static final long serialVersionUID = -8951012348214485238L;

  private EPlayerRace playerRace;

  private EPlayerClass playerClass;
}
