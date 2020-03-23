package com.atguigu.mybatis.mapper;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.atguigu.mybatis.entities.Dept;
import com.atguigu.mybatis.entities.Emp;

public interface DeptMapperAnnotation {

	@Select("select * from hj_ycp.tb_dept where id=#{id};")
	@Results({
		@Result(id=true,property="id",column="id"),
		@Result(property="deptName",column="deptName"),
		@Result(property="locAdd",column="locAdd"),
		@Result(property="emps",column="id",many=@Many(select="com.atguigu.mybatis.mapper.EmpMapperAnnotation.getEmpByDeptId"))
	})
	public Dept getDeptById(Integer id);
}
