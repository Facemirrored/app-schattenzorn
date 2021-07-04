package de.facemirrored.appschattenzorn.services.user;

import de.facemirrored.appschattenzorn.rest.user.AddCharacterRequest;
import de.facemirrored.appschattenzorn.rest.user.AddCharacterResponse;
import de.facemirrored.appschattenzorn.rest.user.EditCharacterRequest;
import de.facemirrored.appschattenzorn.rest.user.EditCharacterResponse;
import de.facemirrored.appschattenzorn.rest.user.LoadProfileResponse;
import de.facemirrored.appschattenzorn.rest.user.RemoveCharacterRequest;
import de.facemirrored.appschattenzorn.rest.user.RemoveCharacterResponse;

public interface UserService {

  LoadProfileResponse getProfile(final String username);

  AddCharacterResponse addCharacter(final AddCharacterRequest addCharacterRequest);

  EditCharacterResponse editCharacter(final EditCharacterRequest editCharacterRequest);

  RemoveCharacterResponse removeCharacter(final RemoveCharacterRequest removeCharacterRequest);
}
