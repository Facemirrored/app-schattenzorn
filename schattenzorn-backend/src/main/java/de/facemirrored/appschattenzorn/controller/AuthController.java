package de.facemirrored.appschattenzorn.controller;

import de.facemirrored.appschattenzorn.database.model.ERole;
import de.facemirrored.appschattenzorn.database.model.Role;
import de.facemirrored.appschattenzorn.database.model.User;
import de.facemirrored.appschattenzorn.database.repository.RoleRepository;
import de.facemirrored.appschattenzorn.database.repository.UserRepository;
import de.facemirrored.appschattenzorn.rest.SignInRequest;
import de.facemirrored.appschattenzorn.rest.SignInResponse;
import de.facemirrored.appschattenzorn.rest.SignUpRequest;
import de.facemirrored.appschattenzorn.rest.SignUpResponse;
import de.facemirrored.appschattenzorn.rest.model.SignInStatus;
import de.facemirrored.appschattenzorn.rest.model.SignUpStatus;
import de.facemirrored.appschattenzorn.security.services.UserDetailsImpl;
import de.facemirrored.appschattenzorn.security.services.authtokenfilter.JwtUtils;
import de.facemirrored.appschattenzorn.services.AuthService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

  private final AuthenticationManager authenticationManager;

  private final UserRepository userRepository;

  private final RoleRepository roleRepository;

  private final PasswordEncoder encoder;

  private final AuthService authService;

  private final JwtUtils jwtUtils;

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
