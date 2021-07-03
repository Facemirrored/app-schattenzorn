package de.facemirrored.appschattenzorn.services;

import de.facemirrored.appschattenzorn.controller.exception.RepoDataNotFoundException;
import de.facemirrored.appschattenzorn.database.CharacterRepository;
import de.facemirrored.appschattenzorn.database.PlayerClassRepository;
import de.facemirrored.appschattenzorn.database.PlayerRaceRepository;
import de.facemirrored.appschattenzorn.database.RaceClassCombinationRepository;
import de.facemirrored.appschattenzorn.database.RepoRaceClassCombination;
import de.facemirrored.appschattenzorn.database.UserRepository;
import de.facemirrored.appschattenzorn.rest.model.Character;
import de.facemirrored.appschattenzorn.rest.model.RaceClassCombination;
import de.facemirrored.appschattenzorn.rest.model.User;
import de.facemirrored.appschattenzorn.rest.profile.LoadProfileResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final CharacterRepository characterRepository;
  private final RaceClassCombinationRepository raceClassCombinationRepository;
  private final PlayerClassRepository playerClassRepository;
  private final PlayerRaceRepository playerRaceRepository;

  public LoadProfileResponse getProfile(final String username) {
    // first load user
    var repoUser = userRepository.findByUsername(username).orElseThrow(
        () -> new UsernameNotFoundException("User Not Found with username: " + username));

    // now load corresponding characters
    var repoOptionalCharacters = characterRepository.findAllByUserId(repoUser.getId());
    // get race class combinations
    var repoRaceClassCombinations = raceClassCombinationRepository.findAll();

    return LoadProfileResponse.builder()
        .raceClassCombinations(
            mapRepoRaceClassCombinationToUiRaceClassCombination(repoRaceClassCombinations))
        .user(User.builder()
            .username(repoUser.getUsername())
            .email(repoUser.getEmail())
            .roles(repoUser.getRoles().stream().map(role -> role.getName().name())
                .collect(Collectors.toList()))
            .build())
        .characters(repoOptionalCharacters.stream().map(repoChar ->
            Character.builder()
                .characterName(repoChar.getCharacterName())
                .level(repoChar.getLevel())
                .male(repoChar.getMale())
                .notes(repoChar.getNotes())
                .playerRace(playerRaceRepository.findById(repoChar.getPlayerRace())
                    .orElseThrow(() -> new RepoDataNotFoundException(
                        "Player race from repository not found. PlayerRaceId:"
                            + repoChar.getPlayerRace()))
                    .getName())
                .playerClass(playerClassRepository.findById(repoChar.getPlayerClass())
                    .orElseThrow(() -> new RepoDataNotFoundException(
                        "Player class from repository not found. PlayerClassId:"
                            + repoChar.getPlayerClass()))
                    .getName())
                .build()).collect(Collectors.toList()))
        .build();
  }


  private List<RaceClassCombination> mapRepoRaceClassCombinationToUiRaceClassCombination(
      List<RepoRaceClassCombination> repoRaceClassCombinations) {
    return repoRaceClassCombinations.stream()
        .map(repoRaceClassCombination ->
            RaceClassCombination.builder()
                .playerClass(
                    playerClassRepository.findById(repoRaceClassCombination.getPlayerClassId())
                        .orElseThrow(() -> new RepoDataNotFoundException(
                            "Player class from repository not found. PlayerClassId:"
                                + repoRaceClassCombination
                                .getPlayerClassId()))
                        .getName())
                .playerRace(
                    playerRaceRepository.findById(repoRaceClassCombination.getPlayerRaceId())
                        .orElseThrow(() -> new RepoDataNotFoundException(
                            "Player race from repository not found. PlayerRaceId:"
                                + repoRaceClassCombination
                                .getPlayerRaceId()))
                        .getName())
                .build())
        .collect(Collectors.toList());
  }
}
