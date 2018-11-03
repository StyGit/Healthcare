package com.app.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.app.dao.IDeveloperDao;
import com.app.model.Developer;
@Repository
public class DeveloperDaoImpl implements IDeveloperDao{

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public int saveDeveloper(Developer d) {
		return (Integer)ht.save(d);
	}

	@Override
	public void updateDeveloper(Developer d) {
		ht.update(d);
	}

	@Override
	public void deleteDeveloper(Integer did) {
		ht.delete(new Developer(did));
	}

	@Override
	public Developer getOneDeveloper(Integer did) {
		return ht.get(Developer.class, did);
	}

	@Override
	public List<Developer> getAllDevelopers() {
		return ht.loadAll(Developer.class);
	}

}
