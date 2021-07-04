package de.facemirrored.appschattenzorn.services;

import de.facemirrored.appschattenzorn.controller.exception.ApplicationException;
import de.facemirrored.appschattenzorn.controller.exception.RepoDataNotFoundException;
import de.facemirrored.appschattenzorn.database.ERole;
import de.facemirrored.appschattenzorn.database.RepoRole;
import de.facemirrored.appschattenzorn.database.RepoUser;
import de.facemirrored.appschattenzorn.database.RoleRepository;
import de.facemirrored.appschattenzorn.database.UserRepository;
import de.facemirrored.appschattenzorn.rest.model.Status;
import de.facemirrored.appschattenzorn.rest.signIn.SignInRequest;
import de.facemirrored.appschattenzorn.rest.signIn.SignInResponse;
import de.facemirrored.appschattenzorn.rest.signup.SignUpRequest;
import de.facemirrored.appschattenzorn.config.security.UserDetailsImpl;
import de.facemirrored.appschattenzorn.config.security.authtokenfilter.JwtUtils;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

  private static final Logger logger = LogManager.getLogger(AuthService.class);

  private final String repoNotFoundMessage;

  private final AuthenticationManager authenticationManager;

  private final PasswordEncoder encoder;

  private final UserRepository userRepository;

  private final RoleRepository roleRepository;

  private final JwtUtils jwtUtils;

  public AuthService(
      @Value("${message.error.repositoryDataNotFound}") String repoNotFoundMessage,
      AuthenticationManager authenticationManager,
      PasswordEncoder encoder, UserRepository userRepository,
      RoleRepository roleRepository,
      JwtUtils jwtUtils) {
    this.repoNotFoundMessage = repoNotFoundMessage;
    this.authenticationManager = authenticationManager;
    this.encoder = encoder;
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
    this.jwtUtils = jwtUtils;
  }

  public SignInResponse authenticateUser(SignInRequest request) {
    try {
      // authenticate user and generate auth-token
      var authentication = authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
      // create jwt-token with auth-token
      SecurityContextHolder.getContext().setAuthentication(authentication);
      String jwt = jwtUtils.generateJwtToken(authentication);
      // get authenticated user data
      UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
      List<String> roles = userDetails.getAuthorities().stream()
          .map(GrantedAuthority::getAuthority)
          .collect(Collectors.toList());

      return SignInResponse.builder()
          .signInStatus(Status.SUCCESS)
          .token(jwt)
          .user(de.facemirrored.appschattenzorn.rest.model.User.builder()
              .username(userDetails.getUsername()).email(userDetails.getEmail()).roles(roles)
              .build())
          .build();

    } catch (AuthenticationException e) {

      logger.info("User authentication in login process has failed");
      return SignInResponse.builder().signInStatus(Status.FAILED).build();

    }
  }

  public void signUpUser(SignUpRequest request) {
    // initialize database user
    var user =
        new RepoUser(request.getUsername(), request.getEmail(),
            encoder.encode((request.getPassword())));
    Set<RepoRole> repoRoles = new HashSet<>();

    final var userRole = roleRepository.findByName(ERole.ROLE_USER)
        .orElseThrow(() -> new ApplicationException(repoNotFoundMessage,
            new RepoDataNotFoundException("Error: Role 'USER' is not found.")));
    repoRoles.add(userRole);
    user.setRepoRoles(repoRoles);

    // save user
    userRepository.save(user);
  }
}
