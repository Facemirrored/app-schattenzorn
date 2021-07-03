package de.facemirrored.appschattenzorn.services.user;

import de.facemirrored.appschattenzorn.controller.exception.RepoDataNotFoundException;
import de.facemirrored.appschattenzorn.database.CharacterRepository;
import de.facemirrored.appschattenzorn.database.PlayerClassRepository;
import de.facemirrored.appschattenzorn.database.PlayerRaceRepository;
import de.facemirrored.appschattenzorn.database.RaceClassCombinationRepository;
import de.facemirrored.appschattenzorn.database.RepoCharacter;
import de.facemirrored.appschattenzorn.database.RepoPlayerClass;
import de.facemirrored.appschattenzorn.database.RepoPlayerRace;
import de.facemirrored.appschattenzorn.database.RepoRaceClassCombination;
import de.facemirrored.appschattenzorn.database.RepoUser;
import de.facemirrored.appschattenzorn.database.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserServiceRepoManager {

  private final UserRepository userRepository;
  private final CharacterRepository characterRepository;
  private final RaceClassCombinationRepository raceClassCombinationRepository;
  private final PlayerClassRepository playerClassRepository;
  private final PlayerRaceRepository playerRaceRepository;

  public RepoCharacter saveCharacter(RepoCharacter repoCharacter) {
    return characterRepository.save(repoCharacter);
  }

  public RepoCharacter getCharacterByName(final String name) throws RepoDataNotFoundException {
    return characterRepository.findByCharacterName(name)
        .orElseThrow(() -> new RepoDataNotFoundException(
            "Could not find Character from CharacterRepository by name '" + name + "'"));
  }

  public RepoPlayerClass getPlayerClassByName(final String name) throws RepoDataNotFoundException {
    return playerClassRepository.findByName(name).orElseThrow(() -> new RepoDataNotFoundException(
        "Could not find PlayerClass from PlayerClassRepository by name '" + name + "'"));
  }

  public RepoPlayerRace getPlayerRaceByName(final String name) throws RepoDataNotFoundException {
    return playerRaceRepository.findByName(name).orElseThrow(() -> new RepoDataNotFoundException(
        "Could not find PlayerRace from PlayerRaceRepository by name '" + name + "'"));
  }

  public RepoUser getUserByUsername(final String name) throws RepoDataNotFoundException {
    return userRepository.findByUsername(name).orElseThrow(() -> new RepoDataNotFoundException(
        "Could not find Character from CharacterRepository by name '" + name + "'"));
  }

  public List<RepoCharacter> getAllCharactersByUserId(final Long id) {
    return characterRepository.findAllByUserId(id);
  }

  public List<RepoRaceClassCombination> getAllRaceClassCombinations() {
    return raceClassCombinationRepository.findAll();
  }

  public RepoPlayerRace getPlayerRaceById(final Long id) throws RepoDataNotFoundException {
    return playerRaceRepository.findById(id).orElseThrow(() -> new RepoDataNotFoundException(
        "Could not find PlayerRace from PlayerRaceRepository by id '" + id + "'"));
  }

  public RepoPlayerClass getPlayerClassById(final Long id) throws RepoDataNotFoundException {
    return playerClassRepository.findById(id).orElseThrow(() -> new RepoDataNotFoundException(
        "Could not find PlayerClass from PlayerClassRepository by id '" + id + "'"));
  }
}
