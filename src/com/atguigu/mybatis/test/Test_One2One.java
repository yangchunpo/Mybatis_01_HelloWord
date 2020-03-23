package com.atguigu.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.atguigu.mybatis.entities.Key;
import com.atguigu.mybatis.entities.Lock;
import com.atguigu.mybatis.mapper.KeyMapper;
import com.atguigu.mybatis.mapper.LockMapper;
import com.atguigu.mybatis.mapper.LockMapperAnnotation;

public class Test_One2One {
	
	private SqlSessionFactory sqlSessionFactory = null;
	
	@Before
	public void init() throws IOException{
		
		//Resources 类：Mybatis特有的资源类
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		/*SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		builder.build(inputStream);*/
	}
	
	/**
	 * 一对一   一个lock对应一个key  实现懒加载
	 */
	@Test
	public void testGetLockById_byselect_annotation(){
		
		SqlSession sqlSession = null;
		
		try {
			sqlSession = sqlSessionFactory.openSession();
			LockMapperAnnotation mapper = sqlSession.getMapper(LockMapperAnnotation.class);
			
			Lock lock = mapper.getLockById2(1);
			System.out.println(lock.getLockName());
			
			Key key = lock.getKey();
			System.out.println(key.getKeyName());

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	/**
	 * 一对一   一个lock对应一个key  实现懒加载
	 */
	@Test
	public void testGetLockById_byselect(){
		
		SqlSession sqlSession = null;
		
		try {
			sqlSession = sqlSessionFactory.openSession();
			LockMapper mapper = sqlSession.getMapper(LockMapper.class);
			
			Lock lock = mapper.getLockById2(1);
			System.out.println(lock.getLockName());
			
			Key key = lock.getKey();
			System.out.println(key.getKeyName());

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	/**
	 * 一对一   一个lock对应一个key 
	 */
	@Test
	public void testGetLockById(){
		
		SqlSession sqlSession = null;
		
		try {
			sqlSession = sqlSessionFactory.openSession();
			LockMapper mapper = sqlSession.getMapper(LockMapper.class);
			
			Lock lock = mapper.getLockById(1);
			
			Key key = lock.getKey();
			
			System.out.println(lock.getLockName());
			System.out.println(key.getKeyName());

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	@Test
	public void testGetKeyById(){
		
		SqlSession sqlSession = null;
		
		try {
			sqlSession = sqlSessionFactory.openSession();
			KeyMapper mapper = sqlSession.getMapper(KeyMapper.class);
			
			Key key = mapper.getKeyById(1);
			
			System.out.println(key);

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

}
