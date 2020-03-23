package com.atguigu.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.atguigu.mybatis.entities.Dept;
import com.atguigu.mybatis.entities.Emp;
import com.atguigu.mybatis.mapper.DeptMapper;
import com.atguigu.mybatis.mapper.EmpMapper;

public class Test_One2Many {
	
	private SqlSessionFactory sqlSessionFactory = null;
	
	@Before
	public void init() throws IOException{
		
		//Resources 类：Mybatis特有的资源类
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
	}
	
	//
	@Test
	public void testMany2One() {
		SqlSession sqlSession = null;
		
		try {
			sqlSession = sqlSessionFactory.openSession();
			EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
			Emp emp = empMapper.getEmpById(1);
			System.out.println(emp.getName());
			
			Dept dept = emp.getDept();
			System.out.println(dept);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (sqlSession != null) {
				sqlSession.close();
			}
			
		}
		
	}

	@Test
	public void testOne2Many() {
		SqlSession sqlSession = null;
		
		try {
			sqlSession = sqlSessionFactory.openSession();
			DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
			Dept dept = deptMapper.getDeptById(1);
			System.out.println(dept.getDeptName());
			List<Emp> emps = dept.getEmps();
			for (Emp emp : emps) {
				System.out.println(emp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (sqlSession != null) {
				sqlSession.close();
			}
			
		}
		
	}

}
