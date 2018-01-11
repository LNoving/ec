package com.ec.demo.web;

import com.ec.demo.domain.Commodity;
import com.ec.demo.service.interfaces.CommodityService;
import com.ec.demo.service.CommoditySvsImpl;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 张昊
 */
@Controller
public class CommodityListController extends BaseController {

    @Resource
    private CommodityService commodityService = new CommoditySvsImpl();

    @GetMapping("/commodities")
    public String commodities(){
        return "forward:/commodities/0";
    }

    @GetMapping("/commodities/{page}")
    public String listCommodities(Model model, @PathVariable int page){

        List<Commodity> commodities = commodityService.findAllByOrder(null);

        Page<Commodity> pagedCommodities = commodityService.pagedUnsoldList(page,5);

        model.addAttribute("commodities",commodities);

        model.addAttribute("paged",pagedCommodities);

        int[] pages = { page ,pagedCommodities.getTotalPages()};
        model.addAttribute("pages",pages);

        return "commodity_list";
    }

}
