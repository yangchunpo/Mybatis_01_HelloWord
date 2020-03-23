/**
 * 
 */
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

import com.atguigu.mybatis.entities.Cat;
import com.atguigu.mybatis.entities.User;
import com.atguigu.mybatis.mapper.UserMapper;

/**
 * @author
 *
 */
public class Test_TwoLevelCache {

	private SqlSessionFactory factory = null;

	@Before
	public void init() throws IOException {
		InputStream inputStream = Resources
				.getResourceAsStream("mybatis-config.xml");
		factory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void test_TwoLevelCache() {
		SqlSession sqlSession = null;
		try {
			SqlSession sqlSession1 = factory.openSession();
			UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
			User user1 = userMapper1.getUserById(1);
			System.out.println(user1.toString());
			//关闭了会话sqlSession
			sqlSession1.close();

			//重新开启了会话sqlSession
			SqlSession sqlSession2 = factory.openSession();
			UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
			User user2 = userMapper2.getUserById(1);
			System.out.println(user2.toString());
			//关闭了会话sqlSession
			sqlSession2.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != sqlSession)
				sqlSession.close();
		}
	}
	
	@Test
	public void test_TwoLevelCache_disanfang() {
		 SqlSession sqlSession1 = factory.openSession();
	     UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
	     User user1 = userMapper1.getUserById(1);
	     System.out.println(user1.toString());
	     sqlSession1.close();
	     
	     SqlSession sqlSession2 = factory.openSession();
	     UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
	     User user2 = userMapper2.getUserById(1);
	     System.out.println(user2.toString());
	     sqlSession2.close();
	     
	     SqlSession sqlSession3 = factory.openSession();
	     UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);
	     User user3 = userMapper3.getUserById(1);
	     System.out.println(user3.toString());
	     sqlSession3.close();
	     
	     SqlSession sqlSession4 = factory.openSession();
	     UserMapper userMapper4 = sqlSession4.getMapper(UserMapper.class);
	     User user4 = userMapper4.getUserById(1);
	     System.out.println(user4.toString());
	     sqlSession4.close();
	     
	     SqlSession sqlSession5 = factory.openSession();
	     UserMapper userMapper5 = sqlSession5.getMapper(UserMapper.class);
	     User user5 = userMapper5.getUserById(1);
	     System.out.println(user5.toString());
	     sqlSession5.close();     
		
	}
}
