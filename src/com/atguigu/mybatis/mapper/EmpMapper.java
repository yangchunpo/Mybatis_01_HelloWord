package com.atguigu.mybatis.mapper;

import java.util.List;

import com.atguigu.mybatis.entities.Emp;

public interface EmpMapper {
	
	List<Emp> getEmpByDeptId(Integer id);
	
	Emp getEmpById(Integer id);

}
