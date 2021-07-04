package de.facemirrored.appschattenzorn.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import de.facemirrored.appschattenzorn.BaseJunitTest;
import de.facemirrored.appschattenzorn.controller.exception.ApplicationException;
import de.facemirrored.appschattenzorn.database.ERole;
import de.facemirrored.appschattenzorn.database.RepoRole;
import de.facemirrored.appschattenzorn.database.RepoUser;
import de.facemirrored.appschattenzorn.database.RoleRepository;
import de.facemirrored.appschattenzorn.database.UserRepository;
import de.facemirrored.appschattenzorn.rest.signIn.SignInRequest;
import de.facemirrored.appschattenzorn.rest.signup.SignUpRequest;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

class AuthServiceTest extends BaseJunitTest {

  private final String testMail = "test@test.de";
  private final String testUsername = "test";
  private final String testPassword = "testtest";
  @Mock UserRepository userRepository;
  @Mock RoleRepository roleRepository;
  @Mock PasswordEncoder passwordEncoder;
  @Mock AuthenticationManager authenticationManager;

  @InjectMocks
  private AuthService classUnderTest;

  private SignInRequest buildSignInRequest() {
    return SignInRequest.builder()
        .username(testUsername).password(testPassword)
        .build();
  }

  private SignUpRequest buildSignUpRequest() {
    return SignUpRequest.builder()
        .email(testMail).username(testUsername).password(testPassword)
        .build();
  }

  private RepoRole buildRole(ERole eRole) {
    return RepoRole.builder().id(0).name(eRole).build();
  }

  private RepoUser buildRepoUser(Set<RepoRole> repoRoles) {
    return RepoUser.builder()
        .email(testMail).username(testUsername).password(testPassword).repoRoles(repoRoles)
        .build();
  }

  @BeforeEach
  void init() {
    when(passwordEncoder.encode(anyString())).thenAnswer(invocation -> invocation.getArgument(0));
  }

  @Test
  void signUpUserPositiveTest() {
    // prepare
    var request = buildSignUpRequest();
    var userRole = buildRole(ERole.ROLE_USER);
    var roles = new HashSet<>(Collections.singletonList(userRole));
    var verifyRepoUser = buildRepoUser(roles);

    when(roleRepository.findByName(ERole.ROLE_USER)).thenReturn(Optional.of(userRole));

    // action
    classUnderTest.signUpUser(request);

    // assert
    verify(userRepository, times(1)).save(verifyRepoUser);
  }

  @Test
  void signUpUserRoleNotExistsThrowsApplicationException() {
    // prepare
    var request = buildSignUpRequest();
    when(roleRepository.findByName(ERole.ROLE_USER)).thenReturn(Optional.empty());

    // action
    Exception exception = Assertions
        .assertThrows(ApplicationException.class, () -> classUnderTest.signUpUser(request));

    // TODO: assert message after refactoring auth service / repo like user repo
    assertNotNull(exception);
  }
}
