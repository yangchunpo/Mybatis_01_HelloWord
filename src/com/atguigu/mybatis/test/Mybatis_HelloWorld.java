package com.atguigu.mybatis.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.naming.InitialContext;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.atguigu.mybatis.entities.Person;
import com.atguigu.mybatis.mapper.PersonMapper;

public class Mybatis_HelloWorld {

	private SqlSessionFactory sqlSessionFactory = null;
	
	@Before
	public void init() throws IOException{
		
		//Resources 类：Mybatis特有的资源类
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		/*SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		builder.build(inputStream);*/
	}
	
	@Test // 架子，orm框架都是这样的架子
	public void test(){
		
		//声明会话session
		SqlSession sqlSession = null;
		
		try {
			//给会话session赋值
			sqlSession = sqlSessionFactory.openSession();
			
			//通过dao接口，操作数据库
			PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
			
			//调用dao接口的方法，对数据库 增删改查
			//mapper.
			
			//提交事务
			sqlSession.commit();
		} catch (Exception e) {
			//捕获异常
			e.printStackTrace();
		}finally{
			//关闭数据库连接
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	@Test
	public void testGetAll(){
		
		SqlSession sqlSession = null;
		
		try {
			sqlSession = sqlSessionFactory.openSession();
			PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
			
			List<Person> personList = mapper.getAll();
			
			for (Person person : personList) {
				System.out.println(person);
			}
			
			//查询不需要提交事务
			//sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	@Test
	public void testGetPersonById(){
		
		SqlSession sqlSession = null;
		
		try {
		sqlSession = sqlSessionFactory.openSession();
		PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
		
		Person person = mapper.getPersonById(9);
		System.out.println(person);
		
		//查询不需要提交事务
		//sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	@Test
	public void testUpdate(){
		
		SqlSession sqlSession = null;
		
		try {
			sqlSession = sqlSessionFactory.openSession();
			PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
			
			Person person = new Person(3, "女儿国国王", 18, new Date(), new Date(), 3200.32);
			mapper.update(person);
			
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	@Test
	public void testDelete(){
		
		SqlSession sqlSession = null;
		
		try {
			sqlSession = sqlSessionFactory.openSession();
			
			PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
			
			mapper.delete(1);
			
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	@Test
	public void testAdd() {
		
		//操作sql的源头
		SqlSession sqlSession = null;
		
		try {
			//获得一个sqlSession
			sqlSession = sqlSessionFactory.openSession();
			//获得具体的接口
			PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
			//准备参数
			Person person = new Person(null, "张莹莹2", 22, new Date(), new Date(), 4500.22);
			//接口方法 --> 操作数据库
			mapper.add(person);
			
			//获得自增主键
			System.out.println(person.getId());
			
			//提交事务
			sqlSession.commit();
		} catch (Exception e) {
			//打印异常信息
			e.printStackTrace();
		}finally{
			//关闭sqlSession
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
}
