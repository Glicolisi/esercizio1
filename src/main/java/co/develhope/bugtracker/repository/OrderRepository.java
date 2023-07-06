package co.develhope.bugtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.develhope.bugtracker.entity.Ordine;

@Repository
public interface OrderRepository extends JpaRepository<Ordine, Integer> {

}
