
package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Employee;
import com.app.service.IEmployeeService;
import com.app.view.EmployeeExcelView;
import com.app.view.EmployeePdfView;
//ctrl+Shift+O(import)
@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private IEmployeeService service;
	
	//1. To Display Register Page
	@RequestMapping("/register")
	public String showRegPage(ModelMap map) {
		//create ModelAttribute Object
		map.addAttribute("employee",new Employee());
		return "EmployeeRegister";
	}
	//2. On Click Submit Button
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String saveData(@ModelAttribute Employee employee,ModelMap map)
	{
		Integer empId=service.saveEmployee(employee);
		String msg="Employee '"+empId+"' saved";
		map.addAttribute("message",msg);
		//clear from data
		map.addAttribute("employee",new Employee());
		return "EmployeeRegister";
	}
	//3.Get Data From DB To UI
	@RequestMapping("/all")
	public String showData(ModelMap map)
	{
		List<Employee> emps=service.getAllEmployees();
		map.addAttribute("list",emps);
		return "EmployeeData";
	}
	//4.Delete Data in db
	@RequestMapping("/delete")
	public String deleteEmployee(@RequestParam("id")Integer empId,ModelMap map) {
		
		service.deleteEmployee(empId);
		String msg="Employee '"+empId+"' Deleted";
		List<Employee> emps=service.getAllEmployees();
		//add ModeMap for controller to UI
		map.addAttribute("message",msg);
		map.addAttribute("list",emps);
		return "EmployeeData";
	}
	
	//5.show Edit Page
	@RequestMapping("/edit")
	public String showEdit(@RequestParam("id")Integer empId,ModelMap map)
	{
		Employee emp=service.getOneEmployee(empId);
		map.addAttribute("employee",emp);
		return "EmployeeEdit";
	}
	//6. do UpdateOperation
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateEmployee(@ModelAttribute Employee employee,ModelMap map)
	{
		service.updateEmployee(employee);
		String msg="Employee '"+employee.getEmpId()+"' Updated";
		List<Employee> emps=service.getAllEmployees();
		map.addAttribute("list",emps);
		map.addAttribute("message",msg);
		return "EmployeeData";
	}
	//7.export data to Excel file
	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		List<Employee> emps=service.getAllEmployees();
		ModelAndView m=new ModelAndView();
		m.setView(new EmployeeExcelView());
		m.addObject("emps",emps);
		return m;
	}
	//8.export data to pdf file
	@RequestMapping("/pdf")
	public ModelAndView showPdf()
	{
		List<Employee> emps=service.getAllEmployees();
		ModelAndView m=new ModelAndView();
		//set View Name
		m.setView(new EmployeePdfView());
		//set model map
		m.addObject("emps",emps);
		return m;
	}
}
