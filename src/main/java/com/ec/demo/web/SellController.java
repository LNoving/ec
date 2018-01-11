package com.ec.demo.web;

import com.ec.demo.domain.Commodity;
import com.ec.demo.domain.User;
import com.ec.demo.service.CommoditySvsImpl;
import com.ec.demo.service.interfaces.CommodityService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class SellController extends BaseController {

    @Resource
    private CommodityService commoditySvs = new CommoditySvsImpl();

    @GetMapping("/sell")
    public String doSell(){
        return "sell";
    }

    @PostMapping("/doSell")
    public ModelAndView sell(HttpServletRequest request, Commodity commodity){
        ModelAndView view = new ModelAndView();
        view.setViewName("redirect:/user/information");
        User user = getSessionUser(request);
        commodity.setDate(new Date());
        commodity.setSeller(user);
        commoditySvs.save(commodity);


        return view;
    }

}
