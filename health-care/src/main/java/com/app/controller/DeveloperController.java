package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Developer;
import com.app.model.Project;
import com.app.service.IDeveloperService;
import com.app.service.IProjectService;

@Controller
@RequestMapping("/developer")
public class DeveloperController {
	@Autowired
	private IDeveloperService service;
	private IProjectService projectService;

	// 1.show user Registration Page!
	@RequestMapping("/register")
	public String showRegPage(ModelMap map) {
		// create ModelAttribute Object
		map.addAttribute("developer", new Developer());
		List<Project> projects = projectService.getAllProjects();
		map.addAttribute("projects", projects);
		return "DeveloperRegister";
	}

	// 2.on click submit operation
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertDeveloper(@ModelAttribute Developer developer, ModelMap map) {
		Integer dId = service.saveDeveloper(developer);
		String msg = "developer '" + dId + "' Saved";
		map.addAttribute("message", msg);
		// clear from data
		map.addAttribute("developer", new Developer());
		List<Project> projects = projectService.getAllProjects();
		map.addAttribute("projects", projects);
		return "DeveloperRegister";
	}

	// 3.get all User data
	@RequestMapping("/all")
	public String showAllDevelopers(ModelMap map) {
		List<Developer> developers = service.getAllDevelopers();
		map.addAttribute("list", developers);
		return "DeveloperData";
	}

	// 4.Delete Data In DB
	@RequestMapping("/delete")
	public String deleteDeveloper(@RequestParam("id") Integer dId, ModelMap map) {
		service.deleteDeveloper(dId);
		String msg = "Developer '" + dId + "' Deleted";
		List<Developer> developers = service.getAllDevelopers();
		// add ModelMAp from controller to Ui
		map.addAttribute("list", developers);
		map.addAttribute("message", msg);
		return "DeveloperData";
	}

	// 5.show edit form
	@RequestMapping("/edit")
	public String editDeveloper(@RequestParam("id") Integer dId, ModelMap map) {
		Developer developer = service.getOneDeveloper(dId);
		map.addAttribute("developer", developer);
		return "DeveloperEdit";
	}

	// 6.do Update Record on click submit
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateDeveloper(@ModelAttribute Developer developer, ModelMap map) {
		service.updateDeveloper(developer);
		String msg = "Developer '" + developer.getDevId() + "' updated";
		// data from database to UI
		List<Developer> developers = service.getAllDevelopers();
		// modelMap from Controller to UI
		map.addAttribute(msg);
		map.addAttribute("list", developers);
		return "DeveloperData";
	}
}
