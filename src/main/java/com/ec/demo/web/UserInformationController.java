package com.ec.demo.web;

import com.ec.demo.cons.CommonConstant;
import com.ec.demo.domain.Commodity;
import com.ec.demo.domain.Demand;
import com.ec.demo.domain.Order;
import com.ec.demo.domain.User;
import com.ec.demo.exception.OrderException;
import com.ec.demo.service.CommoditySvsImpl;
import com.ec.demo.service.DemandServiceImpl;
import com.ec.demo.service.OrderServiceImpl;
import com.ec.demo.service.UserServiceImpl;
import com.ec.demo.service.interfaces.CommodityService;
import com.ec.demo.service.interfaces.DemandService;
import com.ec.demo.service.interfaces.OrderService;
import com.ec.demo.service.interfaces.UserService;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author -
 */
@Controller
public class UserInformationController extends BaseController{

    @Resource
    private OrderService orderService = new OrderServiceImpl();

    @Resource
    private UserService userService = new UserServiceImpl();

    @Resource
    private CommodityService commodityService = new CommoditySvsImpl();

    @Resource
    private DemandService demandService = new DemandServiceImpl();



    @GetMapping("/user/information")
    public String listCommodities(Model model, HttpServletRequest request){

        List<Order> orders = orderService.findAllByBuyer(getSessionUser(request));

        List<Commodity> commodities = commodityService.findAllBySeller(getSessionUser(request));

        List<Demand> demands = demandService.findAllByUser(getSessionUser(request));

        if(orders.size()>0){
            model.addAttribute("orders",orders);
        }

        for(Commodity commodity:commodities){
            if(null != commodity.getOrder()){
                System.out.println("输出"+commodity.getOrder().getStatus());
            }
        }

        if(!demands.isEmpty()){
            model.addAttribute("demands",demands);
        }

        if(commodities.size()>0){
            model.addAttribute("commodities",commodities);
        }

        return "user_information";
    }


}
