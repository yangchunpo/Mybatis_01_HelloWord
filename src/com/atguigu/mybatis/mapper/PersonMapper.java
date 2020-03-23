package com.atguigu.mybatis.mapper;

import java.util.List;

import com.atguigu.mybatis.entities.Person;

public interface PersonMapper {
	
	//常见常用的5个增删改查的方法
	
	/**
	 * 增
	 * @param person
	 */
	public void add(Person person);
	/**
	 * 删
	 * @param id
	 */
	public void delete(Integer id);
	/**
	 * 改
	 * @param person
	 */
	public void update(Person person);
	/**
	 * 查：单一
	 * @param id
	 * @return
	 */
	public Person getPersonById(Integer id);
	
	/**
	 * 查询： 根据多个条件
	 * @param id
	 * @param name
	 * @param age
	 * @param salary
	 * @return
	 */
	public Person getPerson(Integer id, String name, int age, double salary);
	
	/**
	 * 查： 整体
	 * @return
	 */
	public List<Person> getAll();

}
