package com.atguigu.mybatis.entities;

public class Dog {

	private Integer id;
	private String dogName;
	private int dogWeight;

	public Dog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dog(Integer id, String dogName, int dogWeight) {
		super();
		this.id = id;
		this.dogName = dogName;
		this.dogWeight = dogWeight;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDogName() {
		return dogName;
	}

	public void setDogName(String dogName) {
		this.dogName = dogName;
	}

	public int getDogWeight() {
		return dogWeight;
	}

	public void setDogWeight(int dogWeight) {
		this.dogWeight = dogWeight;
	}

	@Override
	public String toString() {
		return "Dog [id=" + id + ", dogName=" + dogName + ", dogWeight="
				+ dogWeight + "]";
	}

}
