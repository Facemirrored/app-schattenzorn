package de.facemirrored.appschattenzorn.rest.user;

import de.facemirrored.appschattenzorn.database.ERole;
import de.facemirrored.appschattenzorn.rest.model.Character;
import de.facemirrored.appschattenzorn.rest.model.RaceClassCombination;
import de.facemirrored.appschattenzorn.rest.model.User;
import java.io.Serializable;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoadProfileResponse implements Serializable {

  private static final long serialVersionUID = 8442327248843750759L;

  ERole role;

  private User user;

  private List<Character> characters;

  private List<RaceClassCombination> raceClassCombinations;
}
