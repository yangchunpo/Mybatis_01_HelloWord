package com.atguigu.mybatis.entities;

public class Emp {
	private Integer id;
	private String name;
	private Dept dept;// 后续双向关系的时候记得添加

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emp(Integer id, String name, Dept dept) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name +  "]";
	}

}
