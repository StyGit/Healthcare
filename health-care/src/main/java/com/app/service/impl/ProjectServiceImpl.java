package com.app.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IProjectDao;
import com.app.model.Project;
import com.app.service.IProjectService;

@Service
public class ProjectServiceImpl implements IProjectService {
	@Autowired
	private IProjectDao dao;
	@Transactional
	public int saveProject(Project p) {
		return dao.saveProject(p);
	}

	@Transactional
	public void updateProject(Project p) {
		dao.updateProject(p);
	}

	@Transactional
	public void deleteProject(Integer projId) {
		dao.deleteProject(projId);
	}

	@Transactional(readOnly=true)
	public Project getOneProject(Integer projId) {
		return dao.getOneProject(projId);
	}
	@Transactional(readOnly=true)
	public List<Project> getAllProjects() {
		return dao.getAllProjects();
	}

}
