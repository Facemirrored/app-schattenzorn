package de.facemirrored.appschattenzorn.database;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RepoRole, Long> {
  Optional<RepoRole> findByName(ERole name);
}