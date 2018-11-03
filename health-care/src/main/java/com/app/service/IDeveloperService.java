package com.app.service;

import java.util.List;

import com.app.model.Developer;

public interface IDeveloperService {


	int saveDeveloper(Developer d);
	void updateDeveloper(Developer d);
	void deleteDeveloper(Integer did);
	Developer getOneDeveloper(Integer did);
	List<Developer> getAllDevelopers();
}
