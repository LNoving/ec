package com.ec.demo.web;

import com.ec.demo.domain.User;
import com.ec.demo.exception.CommodityException;
import com.ec.demo.exception.OrderException;
import com.ec.demo.service.CommoditySvsImpl;
import com.ec.demo.service.OrderServiceImpl;
import com.ec.demo.service.UserServiceImpl;
import com.ec.demo.service.interfaces.CommodityService;
import com.ec.demo.service.interfaces.OrderService;
import com.ec.demo.service.interfaces.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author .
 */
@Controller
public class OrderController extends BaseController {

    @Resource
    private OrderService orderService = new OrderServiceImpl();

    @Resource
    private CommodityService commodityService = new CommoditySvsImpl();


    @RequestMapping("/confirm/{orderId}")
    public String confirm(HttpServletRequest request, @PathVariable int orderId){
        User user = getSessionUser(request);
        try{
            orderService.confirm(user,orderService.findById(orderId));
        }catch (OrderException e){
            e.printStackTrace();
            return "redirect:/error_page";
        }
        return "forward:/user/information";
    }

    @RequestMapping("/deliver/{commodityId}")
    public String  deliver(HttpServletRequest request,@PathVariable int commodityId){
        User user = getSessionUser(request);
        try{
            commodityService.deliver(user,commodityService.findCommodityById(commodityId));
        }catch (CommodityException e){
            e.printStackTrace();
            return "redirect:/error_page";
        }
        return "redirect:/user/information";
    }

}
