package Kolleg.ProductManager.Controller;

import Kolleg.ProductManager.Model.Producer;
import Kolleg.ProductManager.Service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ProducerController {

    @Autowired
    private ProducerService service;

    @RequestMapping("/show/{id}")
    public ModelAndView showNewProductForm(@PathVariable(name = "id")int id){
        ModelAndView mav = new ModelAndView("showProducer");

        Producer producer = service.get(id);
        mav.addObject("producer", producer);

        return mav;
    }
}
