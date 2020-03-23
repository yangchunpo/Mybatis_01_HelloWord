package com.atguigu.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.atguigu.mybatis.entities.Person;

public interface PersonMapperAnnotation {

	// 常见常用的5个增删改查的方法

	/**
	 * 增
	 * Options: @Insert具体的参数设置
	 *          useGeneratedKeys： 使用自增产生的主键     
	            keyProperty：指定自增主键对应的java类里的字段名
	                               通过上述两个设置，即可获取插入数据的自增主键值
	 * @param person
	 */
	@Insert("insert into hj_ycp.tb_person(name,age,birth,registerTime,salary) values(#{name},#{age},#{birth},#{registerTime},#{salary});")
	@Options(useGeneratedKeys=true,keyProperty="id")
	public void add(Person person);

	/**
	 * 删
	 * 
	 * @param id
	 */
	@Delete("delete from hj_ycp.tb_person where id = #{id};")
	public void delete(Integer id);

	/**
	 * 改
	 * 
	 * @param person
	 */
	@Update("update hj_ycp.tb_person set name=#{name},age=#{age},birth=#{birth},registerTime=#{registerTime},salary=#{salary} where id = #{id};")
	public void update(Person person);

	/**
	 * 查：单一
	 * 
	 * @param id
	 * @return
	 */
	@Select("select * from hj_ycp.tb_person where id = #{id};")
	public Person getPersonById(Integer id);

	/**
	 * 查： 整体
	 * 
	 * @return
	 */
	@Select("select * from hj_ycp.tb_person;")
	public List<Person> getAll();

}
