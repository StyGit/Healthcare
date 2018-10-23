package com.app.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "emptab")
public class Employee {
	@Id
	@GeneratedValue
	@Column(name = "eId")
	private Integer empId;
	@Column(name = "eName")
	private String empName;
	@Column(name = "eGen")
	private String empGen;
	@Column(name = "eAddr")
	private String empAddr;
	@Column(name = "eCntry")
	private String empCntry;
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(joinColumns = @JoinColumn(name = "eId"))
	@OrderColumn(name = "pos")
	@Column(name = "data")
	private List<String> empLangs;
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpGen() {
		return empGen;
	}
	public void setEmpGen(String empGen) {
		this.empGen = empGen;
	}
	public String getEmpAddr() {
		return empAddr;
	}
	public void setEmpAddr(String empAddr) {
		this.empAddr = empAddr;
	}
	public String getEmpCntry() {
		return empCntry;
	}
	public void setEmpCntry(String empCntry) {
		this.empCntry = empCntry;
	}
	public List<String> getEmpLangs() {
		return empLangs;
	}
	public void setEmpLangs(List<String> empLangs) {
		this.empLangs = empLangs;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empGen=" + empGen + ", empAddr=" + empAddr
				+ ", empCntry=" + empCntry + ", empLangs=" + empLangs + "]";
	}
	public Employee(Integer empId) {
		super();
		this.empId = empId;
	}
	public Employee() {
		super();
	}
}
