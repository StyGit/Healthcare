package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.app.model.Project;
import com.app.service.IProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {
	@Autowired
	private IProjectService service;

	// 1.show user Registration Page
	@RequestMapping("/register")
	public String showRegPage(ModelMap map) {
		// create ModelAttribute Object
		map.addAttribute("project", new Project());
		return "ProjectRegister";
	}

	// 2.on click submit operation
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertProject(@ModelAttribute Project project, ModelMap map) {
		Integer projId = service.saveProject(project);
		String msg = "Project '" + projId + "' Saved";
		map.addAttribute("message", msg);
		// clear from data
		map.addAttribute("project", new Project());
		return "ProjectRegister";
	}

	// 3.get all User data
	@RequestMapping("/all")
	public String showAllProjects(ModelMap map) {
		List<Project> pojects = service.getAllProjects();
		map.addAttribute("list", pojects);
		return "ProjectData";
	}

	// 4.Delete Data In DB
	@RequestMapping("/delete")
	public String deleteProject(@RequestParam("id") Integer projId, ModelMap map) {
		service.deleteProject(projId);
		String msg = "Project '" + projId + "' Deleted";
		List<Project> projects = service.getAllProjects();
		// add ModelMAp from controller to Ui
		map.addAttribute("list", projects);
		map.addAttribute("message", msg);
		return "ProjectData";
	}

	// 5.show edit form
	@RequestMapping("/edit")
	public String editProject(@RequestParam("id") Integer projId, ModelMap map) {
		Project project = service.getOneProject(projId);
		map.addAttribute("project", project);
		return "ProjectEdit";
	}

	// 6.do Update Record on click submit
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateProject(@ModelAttribute Project project, ModelMap map) {
		service.updateProject(project);
		String msg = "Project '" + project.getProjId() + "' updated";
		// data from database to UI
		List<Project> projects = service.getAllProjects();
		// modelMap from Controller to UI
		map.addAttribute(msg);
		map.addAttribute("list", projects);
		return "ProjectData";
	}
}
