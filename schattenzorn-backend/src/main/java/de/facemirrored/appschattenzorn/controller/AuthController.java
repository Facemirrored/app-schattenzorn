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
import de.facemirrored.appschattenzorn.rest.model.SignUpStatus;
import de.facemirrored.appschattenzorn.security.services.UserDetailsImpl;
import de.facemirrored.appschattenzorn.security.services.authtokenfilter.JwtUtils;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.Valid;
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
@RequestMapping("/api/auth")
public class AuthController {

  AuthenticationManager authenticationManager;

  UserRepository userRepository;

  RoleRepository roleRepository;

  PasswordEncoder encoder;

  JwtUtils jwtUtils;

  @Autowired
  public AuthController(
      AuthenticationManager authenticationManager,
      UserRepository userRepository,
      RoleRepository roleRepository,
      PasswordEncoder encoder,
      JwtUtils jwtUtils) {
    this.authenticationManager = authenticationManager;
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
    this.encoder = encoder;
    this.jwtUtils = jwtUtils;
  }

  @PostMapping(path = "/signIn", consumes = "application/json", produces = "application/json")
  public ResponseEntity<SignInResponse> authenticateUser(
      @Valid @RequestBody SignInRequest signInRequest) {
    var authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(signInRequest.getUsername(),
            signInRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);

    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    List<String> roles = userDetails.getAuthorities().stream()
        .map(GrantedAuthority::getAuthority)
        .collect(Collectors.toList());

    return ResponseEntity.ok(SignInResponse.builder()
        .token(jwt)
        .user(de.facemirrored.appschattenzorn.rest.model.User.builder()
            .username(userDetails.getUsername()).email(userDetails.getEmail()).roles(roles)
            .build())
        .build());
  }

  @PostMapping("/signUp")
  public ResponseEntity<SignUpResponse> registerUser(@Valid @RequestBody
      SignUpRequest signUpRequest) {

    if (Boolean.TRUE.equals(userRepository.existsByEmail(signUpRequest.getEmail()))) {
      return ResponseEntity
          .badRequest()
          .body(new SignUpResponse(SignUpStatus.FAILED_EMAIL_TAKEN));
    }

    if (Boolean.TRUE
        .equals(userRepository.existsByUsername(signUpRequest.getUsername()))) {
      return ResponseEntity
          .badRequest()
          .body(new SignUpResponse(SignUpStatus.FAILED_USERNAME_TAKEN));
    }

    // TODO: extract to Service
    // Create new user's account
    var user = new User(signUpRequest.getUsername(),
        signUpRequest.getEmail(),
        encoder.encode(signUpRequest.getPassword()));

    Set<Role> roles = new HashSet<>();
    // TODO: DataNotFoundException (RuntimeException) with ControllerAdvise
    final var userRole = roleRepository.findByName(ERole.ROLE_USER)
        .orElseThrow(() -> new RuntimeException("Error: Role 'USER' is not found."));
    roles.add(userRole);

    user.setRoles(roles);
    userRepository.save(user);

    return ResponseEntity.ok(new SignUpResponse(SignUpStatus.SUCCESS));
  }
}
