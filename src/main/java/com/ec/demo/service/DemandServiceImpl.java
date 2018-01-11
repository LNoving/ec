package com.ec.demo.service;

import com.ec.demo.dao.DemandRepository;
import com.ec.demo.domain.Demand;
import com.ec.demo.domain.User;
import com.ec.demo.service.interfaces.DemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author .
 */
@EnableTransactionManagement
@Transactional(rollbackFor = Exception.class)
@Service
public class DemandServiceImpl implements DemandService {

    private DemandRepository demandRepository;

    @Autowired
    public void setDemandRepository(DemandRepository demandRepository){
        this.demandRepository = demandRepository;
    }

    @Override
    public void save(Demand demand){
        demandRepository.save(demand);
    }


    @Override
    public List<Demand> findAllByUser (User user){
        return demandRepository.findAllByUser(user);
    }

    @Override
    public List<Demand> findAll (){
        return demandRepository.findAll();
    }

    @Override
    public Page<Demand> pagedDemands (int page, int size){
        return demandRepository.findAll(new PageRequest( page, size));
    }


}
