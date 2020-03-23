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

import com.atguigu.mybatis.entities.Dog;
import com.atguigu.mybatis.mapper.DogMapper;

public class Test_DogMapper {

	SqlSessionFactory factory = null;

	@Before
	public void Init() throws IOException {
		InputStream inputStream = Resources
				.getResourceAsStream("mybatis-config.xml");
		factory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void testGetDogByDogNameResultMap() {
		SqlSession sqlSession = null;

		try {
			sqlSession = factory.openSession();

			DogMapper dogMapper = sqlSession.getMapper(DogMapper.class);

			List<Dog> dogList = dogMapper.getDogByDogNameResultMap("%ww%");

			for (Dog dog : dogList) {
				System.out.println(dog);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	@Test
	public void testGetDogByDogNameAlias() {
		SqlSession sqlSession = null;

		try {
			sqlSession = factory.openSession();

			DogMapper dogMapper = sqlSession.getMapper(DogMapper.class);

			List<Dog> dogList = dogMapper.getDogByDogNameAlias("%ww%");

			for (Dog dog : dogList) {
				System.out.println(dog);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	@Test
	public void testGetDogByDogName() {
		SqlSession sqlSession = null;

		try {
			sqlSession = factory.openSession();

			DogMapper dogMapper = sqlSession.getMapper(DogMapper.class);

			List<Dog> dogList = dogMapper.getDogByDogName("%ww%");

			for (Dog dog : dogList) {
				System.out.println(dog);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
}
