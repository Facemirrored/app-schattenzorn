package de.facemirrored.appschattenzorn.database;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "player_race")
@Getter
@Setter
public class RepoPlayerRace implements Serializable {

  @Id
  @GeneratedValue
  private Long id;

  @Enumerated(EnumType.STRING)
  public EPlayerRace name;
}
