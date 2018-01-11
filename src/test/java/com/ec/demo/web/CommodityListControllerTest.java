package com.ec.demo.web;

import com.ec.demo.service.interfaces.CommodityService;
import com.ec.demo.service.CommoditySvsImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class CommodityListControllerTest {

    private CommodityService commodityService = new CommoditySvsImpl();


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getHello() throws Exception {

    }

}