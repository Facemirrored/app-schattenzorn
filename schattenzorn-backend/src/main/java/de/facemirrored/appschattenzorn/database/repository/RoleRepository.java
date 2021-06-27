package de.facemirrored.appschattenzorn.database.repository;

import de.facemirrored.appschattenzorn.database.model.ERole;
import de.facemirrored.appschattenzorn.database.model.Role;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}