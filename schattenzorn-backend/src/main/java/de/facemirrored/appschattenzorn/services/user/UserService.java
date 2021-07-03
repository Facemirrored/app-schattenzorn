package de.facemirrored.appschattenzorn.services.user;

import de.facemirrored.appschattenzorn.controller.exception.ApplicationException;
import de.facemirrored.appschattenzorn.controller.exception.RepoDataNotFoundException;
import de.facemirrored.appschattenzorn.rest.model.AddCharacterResponseStatus;
import de.facemirrored.appschattenzorn.rest.user.AddCharacterRequest;
import de.facemirrored.appschattenzorn.rest.user.AddCharacterResponse;
import de.facemirrored.appschattenzorn.rest.user.LoadProfileResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

  private final UserServiceMapper userServiceMapper;
  private final UserServiceRepoManager userServiceRepoManager;

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
      log.error("Repository data not found.", e);
      throw new ApplicationException();
    }
  }

  public AddCharacterResponse addCharacter(AddCharacterRequest addCharacterRequest) {
    try {
      // validate (character should not be present in repo)
      userServiceRepoManager
          .getCharacterByName(addCharacterRequest.getCharacter().getCharacterName());
      userServiceRepoManager.saveCharacter(
          userServiceMapper.mapUiCharacterToRepoCharacter(addCharacterRequest.getCharacter()));
      return AddCharacterResponse.builder()
          .character(addCharacterRequest.getCharacter())
          .status(AddCharacterResponseStatus.SUCCESS)
          .build();

    } catch (RepoDataNotFoundException e) {

      return AddCharacterResponse.builder()
          .status(AddCharacterResponseStatus.USERNAME_TAKEN)
          .build();

    }
  }
}
