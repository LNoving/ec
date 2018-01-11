package com.ec.demo.service.interfaces;

import com.ec.demo.domain.Commodity;
import com.ec.demo.domain.Order;
import com.ec.demo.domain.User;
import com.ec.demo.exception.CommodityException;
import org.springframework.data.domain.Page;

import java.util.List;


public interface CommodityService {

    Commodity findCommodityByName(String name);

    Commodity findCommodityById(int id);

    void save(Commodity commodity);

    void delete(Commodity commodity);

    List<Commodity> getCommodityList();

    List<Commodity> findAllBySeller(User seller);

    List<Commodity> findAllByOrder(Order order);

    Page<Commodity> pagedUnsoldList(int page,int size);

    void deliver (User user,Commodity commodity)throws CommodityException;

}
