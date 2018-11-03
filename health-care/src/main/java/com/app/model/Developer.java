package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="devloper_tab")
public class Developer {

	@Id
	@GeneratedValue
	@Column(name="d_id")
	private int devId;
	@Column(name="d_code")
	private String devCode;
	@Column(name="d_name")
	private String devName;
	@Column(name="d_sal")
	private double devSalary;
	@ManyToOne
	@JoinColumn(name="p_idFk")
	@Column(name="project")
	private Project project;//HAS-A
	
	public Developer() {
		super();
	}
	public Developer(int devId) {
		super();
		this.devId = devId;
	}
	public Developer(int devId, String devCode, String devName, double devSalary, Project project) {
		super();
		this.devId = devId;
		this.devCode = devCode;
		this.devName = devName;
		this.devSalary = devSalary;
		this.project = project;
	}
	public int getDevId() {
		return devId;
	}
	public String getDevCode() {
		return devCode;
	}
	public String getDevName() {
		return devName;
	}
	public double getDevSalary() {
		return devSalary;
	}
	public Project getProject() {
		return project;
	}
	public void setDevId(int devId) {
		this.devId = devId;
	}
	public void setDevCode(String devCode) {
		this.devCode = devCode;
	}
	public void setDevName(String devName) {
		this.devName = devName;
	}
	public void setDevSalary(double devSalary) {
		this.devSalary = devSalary;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	@Override
	public String toString() {
		return "Developer [devId=" + devId + ", devCode=" + devCode + ", devName=" + devName + ", devSalary="
				+ devSalary + ", project=" + project + "]";
	}
	


}
