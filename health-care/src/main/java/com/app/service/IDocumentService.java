package com.app.service;

import java.util.List;

import com.app.model.Document;

public interface IDocumentService {
public int saveDocument(Document doc);
public List<Object[]> getDocumentNameAndId();
public Document getOneDocumentById(int docId);
}
