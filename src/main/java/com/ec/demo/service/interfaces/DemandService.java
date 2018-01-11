package com.ec.demo.service.interfaces;

import com.ec.demo.domain.Demand;
import com.ec.demo.domain.User;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author .
 */

public interface DemandService {

    List<Demand> findAllByUser (User user);

    List<Demand> findAll ();

    Page<Demand> pagedDemands (int page,int size);

    void save(Demand demand);
}
