package com.ec.demo.service;

import com.ec.demo.cons.CommonConstant;
import com.ec.demo.dao.CommodityRepository;
import com.ec.demo.domain.Commodity;
import com.ec.demo.domain.Order;
import com.ec.demo.domain.User;
import com.ec.demo.exception.CommodityException;
import com.ec.demo.service.interfaces.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;

/**
 * @author 张昊
 */

@EnableTransactionManagement
@Transactional(rollbackFor = Exception.class)
@Service
public class CommoditySvsImpl implements CommodityService{

    private CommodityRepository commodityRepository;

    @Autowired
    void setCommodityRepository(CommodityRepository cr){
        this.commodityRepository = cr;
    }

    @Override
    public Commodity findCommodityByName(String name){
        return commodityRepository.findCommodityByName(name);
    }

    @Override
    public Commodity findCommodityById(int id){
        return commodityRepository.findOne(id);
    }

    @Override
    public List<Commodity>findAllBySeller(User seller){
        return commodityRepository.findAllBySeller(seller);
    }

    @Override
    public void save(Commodity commodity){
        commodityRepository.save(commodity);
    }

    @Override
    public void delete(Commodity commodity){
        commodityRepository.delete(commodity);
    }

    @Override
    public List<Commodity> getCommodityList(){
        return commodityRepository.findAll();
    }

    @Override
    public List<Commodity> findAllByOrder(Order order){
        return commodityRepository.findAllByOrder(order);
    }

    @Override
    public void deliver (User user,Commodity commodity) throws CommodityException{
        if (CommonConstant.ORDER_TO_BE_DELIVERED == commodity.getOrder().getStatus()){
            commodity.getOrder().setStatus(CommonConstant.ORDER_TO_BE_CONFIRMED);
        }else {
            throw new CommodityException("order status error");
        }
    }

    @Override
    public Page<Commodity> pagedUnsoldList(int page,int size){
        return commodityRepository.findAll(new PageRequest(page,size));
    }




}
