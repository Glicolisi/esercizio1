package co.develhope.bugtracker.repository;

import java.util.List;
import java.util.Optional;

import co.develhope.bugtracker.controller.dto.UserAspirapolvereResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.develhope.bugtracker.entity.Utente;

@Repository
public interface UserRepository extends JpaRepository<Utente, Integer> {

	Optional<Utente> findByUsername(String username);

	@Query(value = "SELECT U.* FROM UTENTE U INNER JOIN ORDINE O ON  U.ID = O.UTENTE_ID WHERE O.ITEM = 'ASPIRAPOLVERE' ",nativeQuery = true)//Per dire che è sql non hql
	public List<Utente> getAspirapolvere();


}
