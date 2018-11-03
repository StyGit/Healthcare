package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IProjectDao;
import com.app.model.Project;
@Repository
public class ProjectDaoImpl implements IProjectDao {
	@Autowired
	private HibernateTemplate ht;
	@Override
	public int saveProject(Project p) {
		System.out.println("ProjectDaoImpl.saveProject()");
		System.out.println("dao:return"+p);
		return (Integer)ht.save(p) ;
		
	}

	@Override
	public void updateProject(Project p) {
		ht.update(p);
	}

	@Override
	public void deleteProject(Integer projId) {
		ht.delete(new Project(projId));
	}

	@Override
	public Project getOneProject(Integer projId) {
		return ht.get(Project.class, projId);
	}

	@Override
	public List<Project> getAllProjects() {
		return ht.loadAll(Project.class);
	}

}
