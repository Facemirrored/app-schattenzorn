package de.facemirrored.appschattenzorn.controller;

import de.facemirrored.appschattenzorn.database.UserRepository;
import de.facemirrored.appschattenzorn.rest.signIn.SignInRequest;
import de.facemirrored.appschattenzorn.rest.signIn.SignInResponse;
import de.facemirrored.appschattenzorn.rest.signUp.SignUpRequest;
import de.facemirrored.appschattenzorn.rest.signUp.SignUpResponse;
import de.facemirrored.appschattenzorn.rest.model.SignUpStatus;
import de.facemirrored.appschattenzorn.services.AuthService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/auth")
public class AuthController {

  private final UserRepository userRepository;

  private final AuthService authService;


  @PostMapping(path = "/signIn", consumes = "application/json", produces = "application/json")
  public ResponseEntity<SignInResponse> authenticateUser(
      @Valid @RequestBody SignInRequest signInRequest) {
    return ResponseEntity.ok(authService.authenticateUser(signInRequest));
  }

  @PostMapping("/signUp")
  public ResponseEntity<SignUpResponse> registerUser(@Valid @RequestBody
      SignUpRequest signUpRequest) {

    if (Boolean.TRUE.equals(userRepository.existsByEmail(signUpRequest.getEmail()))) {
      return ResponseEntity
          .ok(new SignUpResponse(SignUpStatus.FAILED_EMAIL_TAKEN));
    }

    if (Boolean.TRUE
        .equals(userRepository.existsByUsername(signUpRequest.getUsername()))) {
      return ResponseEntity
          .ok(new SignUpResponse(SignUpStatus.FAILED_USERNAME_TAKEN));
    }

    authService.signUpUser(signUpRequest);

    return ResponseEntity.ok(new SignUpResponse(SignUpStatus.SUCCESS));
  }
}
