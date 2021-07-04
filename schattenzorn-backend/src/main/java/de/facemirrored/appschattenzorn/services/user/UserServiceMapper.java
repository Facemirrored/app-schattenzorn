package de.facemirrored.appschattenzorn.services.user;

import de.facemirrored.appschattenzorn.controller.exception.ApplicationException;
import de.facemirrored.appschattenzorn.controller.exception.RepoDataNotFoundException;
import de.facemirrored.appschattenzorn.database.RepoCharacter;
import de.facemirrored.appschattenzorn.database.RepoRaceClassCombination;
import de.facemirrored.appschattenzorn.database.RepoUser;
import de.facemirrored.appschattenzorn.rest.model.Character;
import de.facemirrored.appschattenzorn.rest.model.RaceClassCombination;
import de.facemirrored.appschattenzorn.rest.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserServiceMapper {

  private final String repoNotFoundMessage;

  private final UserServiceRepoManager userServiceRepoManager;

  public UserServiceMapper(
      @Value("${message.error.repositoryDataNotFound}") String repoNotFoundMessage,
      UserServiceRepoManager userServiceRepoManager) {
    this.repoNotFoundMessage = repoNotFoundMessage;
    this.userServiceRepoManager = userServiceRepoManager;
  }

  public User mapRepoUserToUiUser(RepoUser repoUser) {
    return User.builder()
        .username(repoUser.getUsername())
        .email(repoUser.getEmail())
        .roles(repoUser.getRepoRoles()
            .stream()
            .map(role -> role.getName().name())
            .collect(Collectors.toList()))
        .build();
  }


  public RepoCharacter mapUiCharacterToRepoCharacter(final Character character,
      final boolean dirty) {
    try {
      // get repo ids from ui strings
      final Long playerClassId =
          userServiceRepoManager.getPlayerClassByName(character.getCharacterName()).getId();
      final Long playerRaceId =
          userServiceRepoManager.getPlayerRaceByName(character.getCharacterName()).getId();
      // build character
      var repoCharacter = new RepoCharacter();
      repoCharacter.setCharacterName(character.getCharacterName());
      repoCharacter.setLevel(character.getLevel());
      repoCharacter.setMale(character.isMale());
      repoCharacter.setNotes(character.getNotes());
      repoCharacter.setPlayerClass(playerClassId);
      repoCharacter.setPlayerRace(playerRaceId);

      if (!dirty) {
        // get repo character id
        final Long characterId =
            userServiceRepoManager.getCharacterByName(character.getCharacterName()).getId();
        repoCharacter.setId(characterId);
      }

      return repoCharacter;
    } catch (RepoDataNotFoundException e) {
      log.error(repoNotFoundMessage, e);
      throw new ApplicationException();
    }
  }

  public List<Character> mapRepoCharactersToUiCharacters(
      final List<RepoCharacter> repoCharacters) {

    var characters = new ArrayList<Character>();

    repoCharacters.forEach(repoCharacter -> {
      try {
        characters.add(Character.builder()
            .characterName(repoCharacter.getCharacterName())
            .level(repoCharacter.getLevel())
            .male(repoCharacter.getMale())
            .notes(repoCharacter.getNotes())
            .playerRace(
                userServiceRepoManager.getPlayerRaceById(repoCharacter.getPlayerRace()).getName())
            .playerClass(
                userServiceRepoManager.getPlayerClassById(repoCharacter.getPlayerClass()).getName())
            .build());
      } catch (RepoDataNotFoundException e) {
        throw new ApplicationException(repoNotFoundMessage, e);
      }
    });

    return characters;
  }

  public List<RaceClassCombination> mapRepoRaceClassCombinationToUiRaceClassCombination(
      List<RepoRaceClassCombination> repoRaceClassCombinations) {

    var raceClassCombinations = new ArrayList<RaceClassCombination>();

    repoRaceClassCombinations.forEach(repoRaceClassCombination -> {
      try {

        raceClassCombinations.add(RaceClassCombination.builder()
            .playerClass(userServiceRepoManager.getPlayerClassById(repoRaceClassCombination.getId())
                .getName())
            .playerRace(
                userServiceRepoManager.getPlayerRaceById(repoRaceClassCombination.getPlayerRaceId())
                    .getName())
            .build());

      } catch (RepoDataNotFoundException e) {
        throw new ApplicationException(repoNotFoundMessage, e);
      }
    });

    return raceClassCombinations;
  }
}
