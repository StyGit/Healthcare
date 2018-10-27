package com.app.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity(name="documents")
public class Document {
	@Id
	@GeneratedValue
	@Column(name="fid")
	private int fileId;
	@Column(name="fname")
	private String fileName;
	@Column(name="fdata")
	@Lob
	private byte[] fileData;
	@Override
	public String toString() {
		return "Document [fileId=" + fileId + ", fileName=" + fileName + ", fileData=" + Arrays.toString(fileData)
				+ "]";
	}
	public int getFileId() {
		return fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public byte[] getFileData() {
		return fileData;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
	public Document() {
		super();
	}
}