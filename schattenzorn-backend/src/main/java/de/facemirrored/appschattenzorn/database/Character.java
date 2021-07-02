package de.facemirrored.appschattenzorn.database;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "character",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "characterName"),
    })
@Getter
@Setter
public class Character implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotBlank
  @Size(min = 2, max = 12)
  private String characterName;

  @NotBlank
  private Boolean male;

  @NotBlank
  @Size(min = 1, max = 70)
  private Integer level;

  @Size(max = 500)
  private String notes;

  private Long userId;
}
