package com.ojolali.isale.controller;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.ojolali.isale.dao.ProductDao;
import com.ojolali.isale.model.Product;



/**
 * @author mwiyono
 */
@Controller
public class ProductController {
	private final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductDao productDao;

    @RequestMapping("/product/list")
    public ModelMap list(){
    	ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("product", productDao.findAll());
      return modelMap;
    }

    @RequestMapping(value = "/product/form", method = RequestMethod.GET)
    public ModelMap showForm(@RequestParam(value = "id", required = false) Product product) {
      if (product == null) {
    	  product = new Product();
	  }
	  return new ModelMap("product", product);
    }
    

    @RequestMapping(value = "/product/form", method = RequestMethod.POST)
    public String prosesForm(@ModelAttribute @Valid Product product, BindingResult err, SessionStatus status) {
    	logger.info("Save {} ",product);
        if (err.hasErrors()) {
        	logger.error("ERROR {} ",product);
            return "/product/form";
        }
        try {
        	productDao.save(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
        status.setComplete();
        logger.info("Finish {} ",product);
        return "redirect:/product/list";
    }
    

    @GetMapping("/product/delete")
    public ModelMap deleteConfirm(@RequestParam(value = "id", required = true) Product product) {
        return new ModelMap("product", product);
    }

    @PostMapping("/product/delete")
    public Object delete(@ModelAttribute Product product, SessionStatus status) {
        try{
            productDao.delete(product);
        } catch (DataIntegrityViolationException exception) {
            status.setComplete();
            return new ModelAndView("error/errorDelete")
                    .addObject("entityId", product.getId())
                    .addObject("entityName", "Product")
                    .addObject("errorCause", exception.getRootCause().getMessage())
                    .addObject("backLink","/product/list");
        }
        status.setComplete();
        return "redirect:/product/list";
    }
}
