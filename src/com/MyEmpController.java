package com;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyEmpController {
	
	@Autowired
	EmployeeDao empDao; //dao ref
	
	@Autowired
	private LocalValidatorFactoryBean validator;	//for validation

	//bind and validate data
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    binder.setValidator(validator);
	}
	
	//redirects to /addEmpForm form
	@RequestMapping(value = "/addEmp", method = RequestMethod.GET)
	public String add(Model model) {
        model.addAttribute("emp", new Employee());
        return "addEmpForm";
    }
	//validate data and store addEmpForm data and redirects to /viewEmpForm form
	@RequestMapping(value = "/saveData", method = RequestMethod.POST)
	public String saveEmployee(@Valid @ModelAttribute("emp") Employee emp,BindingResult result,Map<String, Object> model) {
	
		if(result.hasErrors()){
			return "addEmpForm";
		}
		empDao.save(emp);
		return "redirect:/viewEmp";
	}
	
	//fetch all employees data and redirects to /viewEmpForm form
	@RequestMapping(value = "/viewEmp")
	public ModelAndView viewEmployee() {
		List<Employee> list = empDao.getEmployees();
		return new ModelAndView("viewEmpForm", "list", list);
	}
	
	//fetch specific employee data based on id and redirects to /editEmpForm form
	@RequestMapping(value = "/editEmp/{id}")
	public ModelAndView edit(@PathVariable int id) {
		Employee emp = empDao.getEmpById(id);
		return new ModelAndView("editEmpForm", "command", emp);
	}
	
		//save editEmpForm data and redirects to /viewEmp from 
	  @RequestMapping(value="/editsave",method = RequestMethod.POST)  
	    public ModelAndView editsave(@ModelAttribute("emp") Employee emp){  
		  empDao.updateEmployee(emp);  
	        return new ModelAndView("redirect:/viewEmp");  
	    }  
	   
	  /* It deletes record for the given id in URL and redirects to /viewemp */  
	    @RequestMapping(value="/deleteEmp/{id}",method = RequestMethod.GET)  
	    public ModelAndView delete(@PathVariable int id){
	    	Employee emp = empDao.getEmpById(id);
	    	empDao.deleteEmployee(emp);  
	        return new ModelAndView("redirect:/viewEmp");  
	    } 
}
