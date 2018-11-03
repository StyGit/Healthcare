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

import com.app.model.User;
import com.app.service.IUserService;
import com.app.view.UserExcelView;
import com.app.view.UserPdfView;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService service;

	//1.show user Registration Page!
	@RequestMapping("/register")
	public String showRegPage(ModelMap map) {

		// create ModelAttribute Object
		map.addAttribute("user", new User());
		return "UserRegister";
	}
	//2.on click submit operation
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insertUser(@ModelAttribute User user,ModelMap map)
	{
		Integer userId=service.saveUser(user);
		String msg="User '"+userId+"' Saved";
		map.addAttribute("message",msg);
		//clear from data
		map.addAttribute("user",new User());
		return "UserRegister";
	}
	//3.get all User data
	@RequestMapping("/all")
	public String showAllusers(ModelMap map)
	{
		List<User> users=service.getAllUsers();
		map.addAttribute("list",users);
		return "UserData";
	}
	//4.Delete Data In DB
	@RequestMapping("/delete")
	public String deleteUser(@RequestParam("id") Integer userId,ModelMap map)
	{
		service.deleteUser(userId);
		String msg="User '"+userId+"' Deleted";
		List<User> users=service.getAllUsers();
		//add ModelMAp from controller to Ui
		map.addAttribute("list",users);
		map.addAttribute("message",msg);
		return "UserData";
	}
	//5.show edit form
	@RequestMapping("/edit")
	public String editUser(@RequestParam("id") Integer userId,ModelMap map)
	{
		User user=service.getOneUser(userId);
		map.addAttribute("user",user);
		return "UserEdit";
	}
	//6.do Update Record on click submit
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateUser(@ModelAttribute User user,ModelMap map)
	{
		service.updateUser(user);
		String msg="User '"+user.getUserId()+"' updated";
		//data from database to UI
		List<User> users=service.getAllUsers();
				//modelMap from Controller to UI
		map.addAttribute(msg);
		map.addAttribute("list",users);
		return "UserData";
	}
	//7.export data to Excel file
		@RequestMapping("/excel")
		public ModelAndView showExcel() {
			List<User> users=service.getAllUsers();
			ModelAndView m=new ModelAndView();
			m.setView(new UserExcelView());
			m.addObject("users",users);
			return m;
		}
		//8.export data to Pdf file
		@RequestMapping("/pdf")
		public ModelAndView showPdf()
		{
			List<User> users=service.getAllUsers();
			ModelAndView m=new ModelAndView();
			m.setView(new UserPdfView());
			m.addObject("users",users);
			return m;
		}
}
