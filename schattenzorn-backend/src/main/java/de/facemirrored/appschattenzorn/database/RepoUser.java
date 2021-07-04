package de.facemirrored.appschattenzorn.database;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
    })
@Getter
@Setter
@Builder
@AllArgsConstructor
public class RepoUser implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  @NotBlank
  @Size(max = 120)
  private String password;

  @ManyToMany(fetch = FetchType.LAZY)
  private Set<RepoRole> repoRoles = new HashSet<>();

  public RepoUser() {
  }

  public RepoUser(String username, String email, String password) {
    this.username = username;
    this.email = email;
    this.password = password;
  }

  @Override public int hashCode() {
    return super.hashCode();
  }

  @Override public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (this.getClass() != obj.getClass()) {
      return false;
    }
    var repoUser = (RepoUser) obj;
    if (this.id == null) {
      return repoUser.id == null;
    }
    if (this.username == null) {
      return repoUser.username == null;
    }
    if (this.email == null) {
      return repoUser.email == null;
    }
    if (this.password == null) {
      return repoUser.password == null;
    }
    if (repoUser.id == null || repoUser.username == null ||repoUser.password == null || repoUser.email == null) {
      return false;
    }
    return this.email.equals(repoUser.email) && this.username.equals(repoUser.username)
        && this.repoRoles.equals(repoUser.repoRoles)
        && this.password.equals(repoUser.getPassword()) && this.id.intValue() == repoUser.id.intValue();
  }
}
