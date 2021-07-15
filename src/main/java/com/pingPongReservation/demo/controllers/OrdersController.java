package com.pingPongReservation.demo.controllers;

import com.pingPongReservation.demo.models.Order;
import com.pingPongReservation.demo.repositories.OrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@RestController
@RequestMapping("/orders")
public class OrdersController {
    private final OrderRepository orderRepository;

    public OrdersController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity createOrder(@RequestBody Order order) throws URISyntaxException {
        Order savedOrder = orderRepository.save(order);
        return ResponseEntity.created(new URI("/orders/" + savedOrder.getId())).body(savedOrder);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateOrder(@PathVariable Long id, @RequestBody Order order) {
        Order currentOrder = orderRepository.findById(id).orElseThrow(RuntimeException::new);
        currentOrder.setLevel(order.getLevel());
        currentOrder.setRacketName(order.getRacketName());
        currentOrder.setReservationStartDate(order.getReservationStartDate());
        currentOrder.setReservationEndDate(order.getReservationEndDate());
        currentOrder.setWishlist(order.getWishlist());
        currentOrder = orderRepository.save(order);

        return ResponseEntity.ok(currentOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOrder(@PathVariable Long id) {
        orderRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
