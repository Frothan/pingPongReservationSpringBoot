package com.pingPongReservation.demo.repositories;

import com.pingPongReservation.demo.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
