package de.facemirrored.appschattenzorn.services;

import de.facemirrored.appschattenzorn.database.CharacterRepository;
import de.facemirrored.appschattenzorn.database.UserRepository;
import de.facemirrored.appschattenzorn.rest.model.Character;
import de.facemirrored.appschattenzorn.rest.model.User;
import de.facemirrored.appschattenzorn.rest.user.LoadProfileResponse;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final CharacterRepository characterRepository;

  public LoadProfileResponse getProfile(final String username) {
    var repoUser = userRepository.findByUsername(username).orElseThrow(
        () -> new UsernameNotFoundException("User Not Found with username: " + username));
    var optionalCharacters = characterRepository.findAllByUserId(repoUser.getId());

    return LoadProfileResponse.builder()
        .user(User.builder()
            .username(repoUser.getUsername())
            .email(repoUser.getEmail())
            .roles(repoUser.getRoles().stream().map(role -> role.getName().name())
                .collect(Collectors.toList()))
            .build())
        .characters(optionalCharacters.stream().map(repoChar ->
            Character.builder()
                .characterName(repoChar.getCharacterName())
                .level(repoChar.getLevel())
                .male(repoChar.getMale())
                .notes(repoChar.getNotes())
                .build()).collect(Collectors.toList()))
        .build();
  }
}
