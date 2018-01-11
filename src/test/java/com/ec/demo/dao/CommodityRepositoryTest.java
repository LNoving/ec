package com.ec.demo.dao;

import com.ec.demo.domain.Commodity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CommodityRepositoryTest {

    @Autowired
    CommodityRepository commodityRepository;

    @Before
    public void initData(){
        Commodity commodity = new Commodity();

        commodityRepository.save(commodity);

    }
    @Test
    public void commodityTest(){
        initData();
    }

}
