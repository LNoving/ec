package com.ec.demo.service.interfaces;

import com.ec.demo.domain.Commodity;
import com.ec.demo.domain.Order;
import com.ec.demo.domain.User;
import com.ec.demo.exception.OrderException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface OrderService {

    public List<Order> findAllBySeller(User seller);

    public List<Order> findAllByBuyer(User buyer);

    public void save(Order order);

    public void delete(Order order);

    public void createOrder(User user,Commodity commodity,String address,String tel)throws OrderException;

    public void confirm(User user,Order order) throws OrderException;

    Order findById(int id);

}
