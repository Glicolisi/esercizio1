package co.develhope.bugtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.develhope.bugtracker.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
