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

import com.ojolali.isale.dao.SaleTransactionDao;
import com.ojolali.isale.model.SaleTransaction;



/**
 * @author mwiyono
 */
@Controller
public class SaleTransactionController {
	private final Logger logger = LoggerFactory.getLogger(SaleTransactionController.class);
	
	@Autowired
	private SaleTransactionDao saleTransactionDao;

    @RequestMapping("/transaction/list")
    public ModelMap list(){
    	ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("saleTransaction", saleTransactionDao.findAll());
      return modelMap;
    }

    @RequestMapping(value = "/transaction/form", method = RequestMethod.GET)
    public ModelMap showForm(@RequestParam(value = "id", required = false) SaleTransaction saleTransaction) {
      if (saleTransaction == null) {
    	  saleTransaction = new SaleTransaction();
	  }
	  return new ModelMap("saleTransaction", saleTransaction);
    }
    

    @RequestMapping(value = "/transaction/form", method = RequestMethod.POST)
    public String prosesForm(@ModelAttribute @Valid SaleTransaction saleTransaction, BindingResult err, SessionStatus status) {
    	logger.info("Save {} ",saleTransaction);
        if (err.hasErrors()) {
        	logger.error("ERROR {} ",saleTransaction);
            return "/transaction/form";
        }
        try {
        	saleTransactionDao.save(saleTransaction);
		} catch (Exception e) {
			e.printStackTrace();
		}
        status.setComplete();
        logger.info("Finish {} ",saleTransaction);
        return "redirect:/transaction/list";
    }
    

    @GetMapping("/transaction/delete")
    public ModelMap deleteConfirm(@RequestParam(value = "id", required = true) SaleTransaction saleTransaction) {
        return new ModelMap("saleTransaction", saleTransaction);
    }

    @PostMapping("/transaction/delete")
    public Object delete(@ModelAttribute SaleTransaction saleTransaction, SessionStatus status) {
        try{
            saleTransactionDao.delete(saleTransaction);
        } catch (DataIntegrityViolationException exception) {
            status.setComplete();
            return new ModelAndView("error/errorDelete")
                    .addObject("entityId", saleTransaction.getId())
                    .addObject("entityName", "SaleTransaction")
                    .addObject("errorCause", exception.getRootCause().getMessage())
                    .addObject("backLink","/transaction/list");
        }
        status.setComplete();
        return "redirect:/transaction/list";
    }
}
