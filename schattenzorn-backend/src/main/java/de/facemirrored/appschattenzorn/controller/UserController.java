package de.facemirrored.appschattenzorn.controller;

import de.facemirrored.appschattenzorn.rest.profile.LoadProfileResponse;
import de.facemirrored.appschattenzorn.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
@PreAuthorize("hasRole('USER')")
@RequiredArgsConstructor
@Slf4j
public class UserController {

  private final UserService userService;

  @GetMapping("/getUser")
  public ResponseEntity<LoadProfileResponse> getUser(Authentication authentication) {
    return ResponseEntity.ok(userService.getProfile(authentication.getName()));
  }
}
