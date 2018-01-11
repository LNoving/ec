package com.ec.demo.web;

import com.ec.demo.domain.Commodity;
import com.ec.demo.domain.Order;
import com.ec.demo.domain.User;
import com.ec.demo.exception.OrderException;
import com.ec.demo.service.CommoditySvsImpl;
import com.ec.demo.service.OrderServiceImpl;
import com.ec.demo.service.interfaces.CommodityService;
import com.ec.demo.service.interfaces.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author .
 */
@Controller
public class PurchaseController extends BaseController{

    @Resource
    private CommodityService commodityService = new CommoditySvsImpl();

    @Resource
    private OrderService orderService = new OrderServiceImpl();


    @PostMapping("/purchase/{commodityId}")
    public ModelAndView purchase(HttpServletRequest request,@PathVariable int commodityId,Order order){
        ModelAndView view = new ModelAndView();
        view.setViewName("redirect:/user/information");
        User user = getSessionUser(request);
        Commodity commodity = commodityService.findCommodityById(commodityId);
        try {
            orderService.createOrder(user,commodity,order.getAddress(),order.getTel());
        }catch (OrderException e){
            e.printStackTrace();
            view.addObject("exception",e);
            view.setViewName("error_page");
        }
        view.addObject(commodity);
        return view;
    }

    @RequestMapping(value = "/commodity/{commodityId}")
    public ModelAndView commodity(@PathVariable int commodityId){
        Commodity commodity = commodityService.findCommodityById(commodityId);
        ModelAndView view = new ModelAndView();
        if(null!=commodity.getOrder()){
            view.addObject("error",new OrderException("该商品已被购买"));
            view.setViewName("error_page");
            return view;
        }
        view.setViewName("commodity");
        view.addObject("commodity",commodity);
        System.out.println(commodity);
        view.addObject("seller",commodity.getSeller());
        return view;
    }


}
