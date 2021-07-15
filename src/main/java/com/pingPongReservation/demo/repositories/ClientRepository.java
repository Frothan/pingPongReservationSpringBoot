package com.pingPongReservation.demo.repositories;

import com.pingPongReservation.demo.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
