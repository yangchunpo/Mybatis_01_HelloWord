package com.atguigu.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.atguigu.mybatis.entities.Emp;

public interface EmpMapperAnnotation {

	@Select("select * from hj_ycp.tb_emp where deptId=#{deptId};")
	@Results({
		@Result(id=true,property="id",column="id"),
		@Result(property="name",column="name")
	})
	List<Emp> getEmpByDeptId(Integer id);
	
	@Select("select * from hj_ycp.tb_emp where id=#{id};")
	@Results({
		@Result(id=true,property="id",column="id"),
		@Result(property="name",column="name"),
		@Result(property="dept",column="deptId",one=@One(select="com.atguigu.mybatis.mapper.DeptMapperAnnotation.getDeptById"))
	})
	Emp getEmpById(Integer id);
}
