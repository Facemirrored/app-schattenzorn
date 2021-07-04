package de.facemirrored.appschattenzorn.controller;

import de.facemirrored.appschattenzorn.rest.user.AddCharacterRequest;
import de.facemirrored.appschattenzorn.rest.user.AddCharacterResponse;
import de.facemirrored.appschattenzorn.rest.user.EditCharacterRequest;
import de.facemirrored.appschattenzorn.rest.user.EditCharacterResponse;
import de.facemirrored.appschattenzorn.rest.user.LoadProfileResponse;
import de.facemirrored.appschattenzorn.rest.user.RemoveCharacterRequest;
import de.facemirrored.appschattenzorn.rest.user.RemoveCharacterResponse;
import de.facemirrored.appschattenzorn.services.user.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
@PreAuthorize("hasRole('USER')")
@RequiredArgsConstructor
@Slf4j
public class UserController {

  private final UserServiceImpl userServiceImpl;

  @GetMapping("/getProfile")
  public ResponseEntity<LoadProfileResponse> getUser(Authentication authentication) {
    return ResponseEntity.ok(userServiceImpl.getProfile(authentication.getName()));
  }

  @PostMapping("/addCharacter")
  public ResponseEntity<AddCharacterResponse> addCharacter(AddCharacterRequest request) {
    return ResponseEntity.ok(userServiceImpl.addCharacter(request));
  }

  @DeleteMapping("/removeCharacter")
  public ResponseEntity<RemoveCharacterResponse> removeCharacter(RemoveCharacterRequest request) {
    return ResponseEntity.ok(userServiceImpl.removeCharacter(request));
  }

  @PutMapping("/putCharacter")
  public ResponseEntity<EditCharacterResponse> editCharacter(EditCharacterRequest request) {
    return ResponseEntity.ok(userServiceImpl.editCharacter(request));
  }
}
