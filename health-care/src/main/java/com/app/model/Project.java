package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="proj_tab")
public class Project {
	@Id
	@GeneratedValue
	@Column(name="p_id")
	private int projId;
	@Column(name="p_code")
	private String projCode;
	@Column(name="p_name")
	private String projName;
	@Column(name="p_dept")
	private String projDept;
	@Column(name="p_note")
	private String projNote;
	public Project() {
		super();
	}
	public Project(int projId) {
		super();
		this.projId = projId;
	}
	public Project(int projId, String projCode, String projName, String projDept, String projNote) {
		super();
		this.projId = projId;
		this.projCode = projCode;
		this.projName = projName;
		this.projDept = projDept;
		this.projNote = projNote;
	}
	public int getProjId() {
		return projId;
	}
	public String getProjCode() {
		return projCode;
	}
	public String getProjName() {
		return projName;
	}
	public String getProjDept() {
		return projDept;
	}
	public String getProjNote() {
		return projNote;
	}
	public void setProjId(int projId) {
		this.projId = projId;
	}
	public void setProjCode(String projCode) {
		this.projCode = projCode;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	public void setProjDept(String projDept) {
		this.projDept = projDept;
	}
	public void setProjNote(String projNote) {
		this.projNote = projNote;
	}
	@Override
	public String toString() {
		return "Project [projId=" + projId + ", projCode=" + projCode + ", projName=" + projName + ", projDept="
				+ projDept + ", projNote=" + projNote + "]";
	}
	
	
}
