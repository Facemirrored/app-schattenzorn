package de.facemirrored.appschattenzorn.services.user;

import de.facemirrored.appschattenzorn.controller.exception.ApplicationException;
import de.facemirrored.appschattenzorn.controller.exception.RepoDataNotFoundException;
import de.facemirrored.appschattenzorn.rest.model.Character;
import de.facemirrored.appschattenzorn.rest.model.Status;
import de.facemirrored.appschattenzorn.rest.user.AddCharacterRequest;
import de.facemirrored.appschattenzorn.rest.user.AddCharacterResponse;
import de.facemirrored.appschattenzorn.rest.user.EditCharacterRequest;
import de.facemirrored.appschattenzorn.rest.user.EditCharacterResponse;
import de.facemirrored.appschattenzorn.rest.user.LoadProfileResponse;
import de.facemirrored.appschattenzorn.rest.user.RemoveCharacterRequest;
import de.facemirrored.appschattenzorn.rest.user.RemoveCharacterResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

  private final String repoNotFoundMessage;
  private final UserServiceMapper userServiceMapper;
  private final UserServiceRepoManager userServiceRepoManager;

  public UserServiceImpl(
      @Value("${message.error.repositoryDataNotFound}") String repoNotFoundMessage,
      UserServiceMapper userServiceMapper,
      UserServiceRepoManager userServiceRepoManager) {
    this.repoNotFoundMessage = repoNotFoundMessage;
    this.userServiceMapper = userServiceMapper;
    this.userServiceRepoManager = userServiceRepoManager;
  }

  public LoadProfileResponse getProfile(final String username) {
    try {

      // first load user
      var repoUser = userServiceRepoManager.getUserByUsername(username);
      // now load corresponding characters
      var repoCharacters = userServiceRepoManager.getAllCharactersByUserId(repoUser.getId());
      // get race class combinations
      var repoRaceClassCombinations = userServiceRepoManager.getAllRaceClassCombinations();

      // mapping
      var raceClassCombination =
          userServiceMapper
              .mapRepoRaceClassCombinationToUiRaceClassCombination(repoRaceClassCombinations);
      var user = userServiceMapper.mapRepoUserToUiUser(repoUser);
      var characters = userServiceMapper.mapRepoCharactersToUiCharacters(repoCharacters);

      // response
      return LoadProfileResponse.builder()
          .raceClassCombinations(raceClassCombination)
          .user(user)
          .characters(characters)
          .build();

    } catch (RepoDataNotFoundException e) {
      log.error(repoNotFoundMessage, e);
      throw new ApplicationException();
    }
  }

  public AddCharacterResponse addCharacter(AddCharacterRequest addCharacterRequest) {
    try {
      // validate (character should not be present in repo)
      userServiceRepoManager
          .getCharacterByName(addCharacterRequest.getCharacter().getCharacterName());
      userServiceRepoManager.saveCharacter(
          userServiceMapper
              .mapUiCharacterToRepoCharacter(addCharacterRequest.getCharacter(), true));
      return AddCharacterResponse.builder()
          .character(addCharacterRequest.getCharacter())
          .status(Status.SUCCESS)
          .build();

    } catch (RepoDataNotFoundException e) {

      return AddCharacterResponse.builder()
          .status(Status.USERNAME_TAKEN)
          .build();

    }
  }

  @Override
  public EditCharacterResponse editCharacter(EditCharacterRequest editCharacterRequest) {
    final var oldCharacter = editCharacterRequest.getOldCharacter();
    final var newCharacter = editCharacterRequest.getNewCharacter();

    // get mapped character from repo
    var newRepoCharacter = userServiceMapper.mapUiCharacterToRepoCharacter(newCharacter, true);
    var oldRepoCharacter = userServiceMapper.mapUiCharacterToRepoCharacter(oldCharacter, false);
    // update
    newRepoCharacter.setId(oldRepoCharacter.getId());
    // save new character
    userServiceRepoManager.saveCharacter(newRepoCharacter);

    return EditCharacterResponse.builder().character(newCharacter).status(Status.SUCCESS).build();
  }

  @Override
  public RemoveCharacterResponse removeCharacter(
      RemoveCharacterRequest removeCharacterRequest) {

    userServiceRepoManager
        .deleteCharacterByName(removeCharacterRequest.getCharacter().getCharacterName());

    return RemoveCharacterResponse.builder().status(Status.SUCCESS).build();
  }
}
