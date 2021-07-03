package de.facemirrored.appschattenzorn.database;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerClassRepository extends JpaRepository<RepoPlayerClass, Long> {
  Optional<RepoPlayerClass> findByName(String name);
}
