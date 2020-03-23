package com.atguigu.mybatis.entities;

import java.util.List;

public class Dept {
	private Integer id;
	private String deptName;
	private String locAdd;
	private List<Emp> emps;

	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dept(Integer id, String deptName, String locAdd, List<Emp> emps) {
		super();
		this.id = id;
		this.deptName = deptName;
		this.locAdd = locAdd;
		this.emps = emps;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getLocAdd() {
		return locAdd;
	}

	public void setLocAdd(String locAdd) {
		this.locAdd = locAdd;
	}

	public List<Emp> getEmps() {
		return emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}

	@Override
	public String toString() {
		return "Dept [id=" + id + ", deptName=" + deptName + ", locAdd="
				+ locAdd + ", emps=" + emps + "]";
	}

}
