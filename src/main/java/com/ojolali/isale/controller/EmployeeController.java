package com.ojolali.isale.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.ojolali.isale.dao.EmployeeDao;
import com.ojolali.isale.model.Employee;



/**
 * @author mwiyono
 */
@Controller
public class EmployeeController {
	private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeDao employeeDao;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {		
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
    @RequestMapping("/employee/list")
    public ModelMap listAll(){
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
    

    @GetMapping("/employee/delete")
    public ModelMap deleteConfirm(@RequestParam(value = "id", required = true) Employee employee) {
        return new ModelMap("employee", employee);
    }

    @PostMapping("/employee/delete")
    public Object delete(@ModelAttribute Employee employee, SessionStatus status) {
        try{
            employeeDao.delete(employee);
        } catch (DataIntegrityViolationException exception) {
            status.setComplete();
            return new ModelAndView("error/errorDelete")
                    .addObject("entityId", employee.getId())
                    .addObject("entityName", "Employee")
                    .addObject("errorCause", exception.getRootCause().getMessage())
                    .addObject("backLink","/employee/list");
        }
        status.setComplete();
        return "redirect:/employee/list";
    }
}
