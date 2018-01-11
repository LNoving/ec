package com.ec.demo.dao;

import com.ec.demo.domain.Commodity;
import com.ec.demo.domain.Order;
import com.ec.demo.domain.User;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

/**
 * @author 张昊
 */
@Repository
public interface CommodityRepository extends JpaRepository<Commodity,Integer>{

    Commodity findCommodityByName(String name);

    List<Commodity> findAllBySeller(User seller);

    List<Commodity> findAllByOrder (Order order);

}
