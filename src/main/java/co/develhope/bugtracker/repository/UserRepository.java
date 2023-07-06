package co.develhope.bugtracker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.develhope.bugtracker.entity.Utente;

@Repository
public interface UserRepository extends JpaRepository<Utente, Integer> {

	Optional<Utente> findByUsername(String username);

}
