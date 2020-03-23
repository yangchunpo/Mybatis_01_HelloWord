package com.atguigu.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.atguigu.mybatis.entities.Student;

public interface StudentMapper {
	
	public List<Student> getByAge(int age);
	
	public List<Student> getByAge_if(@Param("age") int age);
	
	public List<Student> getStudent_Where(Student student);
	
	public List<Student> getStudent_Choose_when_otherwise(Map<String, Object> map);
	
	public List<Student> getStudent_Foreach(Map<String, Object> map);
	
	public List<Student> getStudent_Trim(Map<String, Object> map);
	
	public void insertStudent_Trim(Map<String, Object> map);
	
	public void updateStudent_Set(Map<String, Object> map);
	
}
