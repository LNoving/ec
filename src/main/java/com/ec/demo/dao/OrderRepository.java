package com.ec.demo.dao;

import com.ec.demo.domain.Order;
import com.ec.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

    List<Order> findAllBySeller(User seller);

    List<Order> findAllByBuyer(User buyer);

}
