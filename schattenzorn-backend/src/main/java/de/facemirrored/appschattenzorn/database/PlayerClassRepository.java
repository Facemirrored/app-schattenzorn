package de.facemirrored.appschattenzorn.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerClassRepository extends JpaRepository<RepoPlayerClass, Long> {

}
