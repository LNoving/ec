package com.ec.demo.dao;

import com.ec.demo.domain.Demand;
import com.ec.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author .
 */
@Repository
public interface DemandRepository extends JpaRepository<Demand,Integer>{

    List<Demand> findAllByUser (User user);

}
