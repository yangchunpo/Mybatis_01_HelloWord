package com.atguigu.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javassist.expr.NewArray;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.atguigu.mybatis.entities.Student;
import com.atguigu.mybatis.mapper.StudentMapper;

public class Test_DynamicSQL {
	
	SqlSessionFactory factory = null;
	
	@Before
	public void init() throws IOException{
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		factory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void testUpdateStudent_Set() {
		
		SqlSession sqlSession = null;
		
		try {
			sqlSession = factory.openSession();
			
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("name", "王昭君1");
			//map.put("age", 18);
			//map.put("score", "60.0");
			//map.put("birth", new Date());
			map.put("id", 1);
			
			studentMapper.updateStudent_Set(map);
			
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	/**
	 * 动态sql条件： trim ，拼装insert语句
	 */
	@Test
	public void testInsertStudent_Trim() {
		
		SqlSession sqlSession = null;
		
		try {
			sqlSession = factory.openSession();
			
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("name", "诸葛亮");
			map.put("age", 22);
			map.put("score", 100.0);
			map.put("birth", new Date());
			
			studentMapper.insertStudent_Trim(map);
			
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	/**
	 * 动态sql条件： trim ，可以代替 where条件
	 */
	@Test
	public void testGetStudent_Trim() {
		
		SqlSession sqlSession = null;
		
		try {
			sqlSession = factory.openSession();
			
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("name", "li4");
			
			List<Student> studentList = studentMapper.getStudent_Trim(map);
			
			for (Student element : studentList) {
				System.out.println(element);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	/**
	 * 动态sql条件： foreach 相当于sql语句中的 in(xx,xx,xx)
	 */
	@Test
	public void testGetStudent_Foreach() {
		
		SqlSession sqlSession = null;
		
		try {
			sqlSession = factory.openSession();
			
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("ages", Arrays.asList(22,23,24));
			
			List<Student> studentList = studentMapper.getStudent_Foreach(map);
			
			for (Student element : studentList) {
				System.out.println(element);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	/**
	 * 动态sql语句条件：  choose/when/otherwise，
	 *                 类似于java中的switch/case，
	 *                   只取一个条件，只要前面的一个条件满足，后面的条件不再考虑
	 */
	@Test
	public void testGetStudent_Choose_when_otherwise() {
		
		SqlSession sqlSession = null;
		
		try {
			sqlSession = factory.openSession();
			
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			
			Map<String, Object> map = new HashMap<String, Object>();
			//map.put("name", "li4");
			map.put("name", null);
			//map.put("age", 22);
			map.put("age", 0);
			
			List<Student> studentList = studentMapper.getStudent_Choose_when_otherwise(map);
			
			for (Student element : studentList) {
				System.out.println(element);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	/**
	 * 动态sql条件： where
	 */
	@Test
	public void testGetStudent_Where() {
		
		SqlSession sqlSession = null;
		
		try {
			sqlSession = factory.openSession();
			
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			
			Student student = new Student(null, "li4", 60.00, new Date(), 22);
			//Student student = new Student(null, null, 60.00, new Date(), -22);
			
			List<Student> studentList = studentMapper.getStudent_Where(student);
			
			for (Student element : studentList) {
				System.out.println(element);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	/**
	 * 动态sql条件：  if
	 */
	@Test
	public void testGetByAge_if() {
		
		SqlSession sqlSession = null;
		
		try {
			sqlSession = factory.openSession();
			
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			
			List<Student> studentList = studentMapper.getByAge_if(23);
			
			for (Student student : studentList) {
				System.out.println(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	/**
	 * 普通例子，不涉及 动态sql
	 */
	@Test
	public void testGetByAge() {
		
		SqlSession sqlSession = null;
		
		try {
			sqlSession = factory.openSession();
			
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			
			List<Student> studentList = studentMapper.getByAge(23);
			
			for (Student student : studentList) {
				System.out.println(student);
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
