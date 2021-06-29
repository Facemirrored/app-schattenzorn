package de.facemirrored.appschattenzorn.services;

import de.facemirrored.appschattenzorn.controller.exception.RepoDataNotFoundException;
import de.facemirrored.appschattenzorn.database.model.ERole;
import de.facemirrored.appschattenzorn.database.model.Role;
import de.facemirrored.appschattenzorn.database.model.User;
import de.facemirrored.appschattenzorn.database.repository.RoleRepository;
import de.facemirrored.appschattenzorn.database.repository.UserRepository;
import de.facemirrored.appschattenzorn.rest.SignInRequest;
import de.facemirrored.appschattenzorn.rest.SignInResponse;
import de.facemirrored.appschattenzorn.rest.SignUpRequest;
import de.facemirrored.appschattenzorn.rest.model.SignInStatus;
import de.facemirrored.appschattenzorn.rest.model.SignUpStatus;
import de.facemirrored.appschattenzorn.security.services.UserDetailsImpl;
import de.facemirrored.appschattenzorn.security.services.authtokenfilter.JwtUtils;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

  private static final Logger logger = LogManager.getLogger(AuthService.class.getName());

  private final AuthenticationManager authenticationManager;

  private final PasswordEncoder encoder;

  private final UserRepository userRepository;

  private final RoleRepository roleRepository;

  private final JwtUtils jwtUtils;

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
          .signInStatus(SignInStatus.SUCCESS)
          .token(jwt)
          .user(de.facemirrored.appschattenzorn.rest.model.User.builder()
              .username(userDetails.getUsername()).email(userDetails.getEmail()).roles(roles)
              .build())
          .build();

    } catch (AuthenticationException e) {

      logger.info("User authentication in login process has failed");
      return SignInResponse.builder().signInStatus(SignInStatus.FAILED).build();

    }
  }

  public void signUpUser(SignUpRequest request) {
    // initialize database user
    var user =
        new User(request.getUsername(), request.getEmail(),
            encoder.encode((request.getPassword())));
    Set<Role> roles = new HashSet<>();

    final var userRole = roleRepository.findByName(ERole.ROLE_USER)
        .orElseThrow(() -> new RepoDataNotFoundException("Error: Role 'USER' is not found."));
    roles.add(userRole);
    user.setRoles(roles);

    // save user
    userRepository.save(user);
  }
}
