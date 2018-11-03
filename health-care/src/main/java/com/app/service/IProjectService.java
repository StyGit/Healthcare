package com.app.service;

import java.util.List;

import com.app.model.Project;

public interface IProjectService {
	public int saveProject(Project p);
	public void updateProject(Project p);
	public void deleteProject(Integer projId);
	public Project getOneProject(Integer projId);
	public List<Project> getAllProjects();
}
