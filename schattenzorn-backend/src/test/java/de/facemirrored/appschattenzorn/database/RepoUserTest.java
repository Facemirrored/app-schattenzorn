package de.facemirrored.appschattenzorn.database;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import de.facemirrored.appschattenzorn.BaseJunitTest;
import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class RepoUserTest extends BaseJunitTest {

  private static final Long id = 33L;
  private static final String email = "test@test.de";
  private static final String username = "username";
  private static final String password = "password";
  private static final RepoRole USER_REPO_ROLE = RepoRole.builder().id(44).name(ERole.ROLE_USER).build();
  private static final RepoRole ADMIN_REPO_ROLE = RepoRole.builder().id(45).name(ERole.ROLE_ADMIN).build();
  private static final HashSet<RepoRole>
      ROLES_WITH_USER = new HashSet<>(Collections.singletonList(USER_REPO_ROLE));
  private static final HashSet<RepoRole>
      ROLES_WITH_ADMIN = new HashSet<>(Collections.singletonList(ADMIN_REPO_ROLE));
  private static final String WRONG = "WRONG";

  @Test
  void repoUserTypeEqualsTest() {
    // prepare
    var baseRepoUser = RepoUser.builder()
        .id(id).email(email).username(username).password(password).repoRoles(ROLES_WITH_USER).build();
    var equalRepoUser = RepoUser.builder()
        .id(id).email(email).username(username).password(password).repoRoles(ROLES_WITH_USER).build();

    // action
    final boolean equal = baseRepoUser.equals(equalRepoUser);

    assertTrue(equal);
  }

  @ParameterizedTest
  @MethodSource("providerRepoUser")
  void repoUserTypeNotEqualTest(RepoUser repoUser) {
    // prepare
    var baseRepoUser = RepoUser.builder()
        .id(id).email(email).username(username).password(password).repoRoles(ROLES_WITH_USER).build();

    // action
    final boolean equal = baseRepoUser.equals(repoUser);

    // assert
    assertFalse(equal);
  }

  private static Stream<RepoUser> providerRepoUser() {
    return Stream.of(
        RepoUser.builder()
            .id(0L).email(email).username(username).password(password).repoRoles(ROLES_WITH_USER).build(),
        RepoUser.builder()
            .id(id).email(WRONG).username(username).password(password).repoRoles(ROLES_WITH_USER).build(),
        RepoUser.builder()
            .id(id).email(email).username(WRONG).password(password).repoRoles(ROLES_WITH_USER).build(),
        RepoUser.builder()
            .id(id).email(email).username(username).password(WRONG).repoRoles(ROLES_WITH_USER).build(),
        RepoUser.builder()
            .id(id).email(email).username(username).password(password).repoRoles(ROLES_WITH_ADMIN).build());
  }
}
