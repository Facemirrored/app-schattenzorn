package de.facemirrored.appschattenzorn.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "roles")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class RepoRole {

  @Id
  @GeneratedValue
  private Integer id;

  @Enumerated(EnumType.STRING)
  @Column(length = 20)
  private ERole name;

  public RepoRole(ERole name) {
    this.name = name;
  }

  public RepoRole() {

  }
}
