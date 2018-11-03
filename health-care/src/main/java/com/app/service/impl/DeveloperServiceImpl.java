package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IDeveloperDao;
import com.app.model.Developer;
import com.app.service.IDeveloperService;

@Service
public class DeveloperServiceImpl implements IDeveloperService {
	@Autowired
	private IDeveloperDao dao;

	@Transactional
	public int saveDeveloper(Developer d) {
		return dao.saveDeveloper(d);
	}

	@Transactional
	public void updateDeveloper(Developer d) {
		dao.updateDeveloper(d);
	}

	@Transactional
	public void deleteDeveloper(Integer did) {
		dao.deleteDeveloper(did);
	}

	@Transactional(readOnly = true)
	public Developer getOneDeveloper(Integer did) {
		return dao.getOneDeveloper(did);
	}

	@Transactional(readOnly = true)
	public List<Developer> getAllDevelopers() {
		return dao.getAllDevelopers();
	}

}
