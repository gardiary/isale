package com.ojolali.isale.controller;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.ojolali.isale.dao.EmployeeDao;
import com.ojolali.isale.model.Employee;


@Controller
public class EmployeeController {
	private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeDao employeeDao;

    @RequestMapping("/employee/list")
    public ModelMap daftarDosen(){
    	ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("employee", employeeDao.findAll());
      return modelMap;
    }

    @RequestMapping(value = "/employee/form", method = RequestMethod.GET)
    public ModelMap showForm(@RequestParam(value = "id", required = false) Employee employee) {
      if (employee == null) {
    	  employee = new Employee();
	  }
	  return new ModelMap("employee", employee);
    }
    

    @RequestMapping(value = "/employee/form", method = RequestMethod.POST)
    public String prosesForm(@ModelAttribute @Valid Employee employee, BindingResult err, SessionStatus status) {
    	logger.info("Save {} ",employee);
        if (err.hasErrors()) {
        	logger.error("ERROR {} ",employee);
            return "/employee/form";
        }
        try {
        	employeeDao.save(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
        status.setComplete();
        logger.info("Finish {} ",employee);
        return "redirect:/employee/list";
    }
}