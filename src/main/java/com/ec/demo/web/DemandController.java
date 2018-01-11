package com.ec.demo.web;

import com.ec.demo.domain.Demand;
import com.ec.demo.domain.User;
import com.ec.demo.service.DemandServiceImpl;
import com.ec.demo.service.interfaces.DemandService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author .
 */
@Controller
public class DemandController extends BaseController {

    @Resource
    private DemandService demandService = new DemandServiceImpl();

    @GetMapping("/demands")
    public String demands(){
        return "forward:/demands/0";
    }

    @GetMapping("/demands/{page}")
    public String demandsList (Model model, @PathVariable int page){

        Page<Demand> pagedDemands = demandService.pagedDemands( page,5);
        model.addAttribute("demands",pagedDemands);

        int[] pages = { page ,pagedDemands.getTotalPages()};
        model.addAttribute("pages",pages);

        return "demand_list";
    }


    @GetMapping("/postDemand")
    public String postDemand (){
        return "do_demand";
    }

    @PostMapping("/doDemand")
    public ModelAndView doDemand(HttpServletRequest request,Demand demand){
        ModelAndView view = new ModelAndView();
        view.setViewName("redirect:/user/information");
        User user = getSessionUser(request);
        demand.setDateTime(new Date());
        demand.setUser(user);
        demandService.save(demand);

        return view;
    }

}
