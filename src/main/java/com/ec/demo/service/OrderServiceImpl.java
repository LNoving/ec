package com.ec.demo.service;

import com.ec.demo.cons.CommonConstant;
import com.ec.demo.dao.OrderRepository;
import com.ec.demo.domain.Commodity;
import com.ec.demo.domain.Order;
import com.ec.demo.domain.User;
import com.ec.demo.exception.OrderException;
import com.ec.demo.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author .
 */
@EnableTransactionManagement
@Transactional(rollbackFor = Exception.class)
@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Autowired
    void setOrderRepository(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @Override
    public Order findById(int id){
        return orderRepository.findOne(id);
    }

    @Override
    public List<Order> findAllBySeller(User seller){
        return orderRepository.findAllBySeller(seller);
    }

    @Override
    public List<Order> findAllByBuyer(User buyer){
        return orderRepository.findAllByBuyer(buyer);
    }

    @Override
    public void save(Order order){
        orderRepository.save(order);
    }

    @Override
    public void delete(Order order){
        orderRepository.delete(order);
    }

    @Override
    public void createOrder (User user, Commodity commodity,String address,String tel)throws OrderException {
        if(null==user||null==commodity){
            throw new OrderException("找不到该商品");
        }
        if(null != commodity.getOrder()){
            throw new OrderException("该商品已被购买");
        }
        if(user.getUserId() == commodity.getSeller().getUserId()){
            throw new OrderException("自己不能购买自己的商品");
        }
        Order order = new Order();
        order.setCommodity(commodity);
        order.setBuyer(user);
        order.setSeller(commodity.getSeller());
        order.setDate(new Date());
        order.setAddress(address);
        order.setTel(tel);
        order.setStatus(CommonConstant.ORDER_TO_BE_DELIVERED);
        orderRepository.save(order);
    }

    @Override
    public void confirm(User user,Order order) throws OrderException{
        if (CommonConstant.ORDER_TO_BE_CONFIRMED == order.getStatus()){
            order.setStatus(CommonConstant.ORDER_ACCOMPLISHED);
        }else {
            throw new OrderException("order status error");
        }
    }

}
