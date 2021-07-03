package de.facemirrored.appschattenzorn.database;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<RepoCharacter, Long> {

  List<RepoCharacter> findAllByUserId(Long userId);
}
