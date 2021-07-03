package de.facemirrored.appschattenzorn.database;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRaceRepository extends JpaRepository<RepoPlayerRace, Long> {

  Optional<RepoPlayerRace> findByName(String name);
}
