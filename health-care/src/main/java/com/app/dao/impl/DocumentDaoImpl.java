package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IDocumentDao;
import com.app.model.Document;
@Repository
public class DocumentDaoImpl implements IDocumentDao {
	private static final String HQL="select fileId,fileName from "+Document.class.getName();
	@Autowired
	private HibernateTemplate ht;
	@Override
	public int saveDocument(Document doc) {
		return (Integer)ht.save(doc);
	}
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Object[]> getDocumentNameAndId() {
		return (List<Object[]>)ht.find(HQL);
	}
	@Override
	public Document getOneDocumentById(int docId) {
		
		return ht.get(Document.class, docId);
	}

}
