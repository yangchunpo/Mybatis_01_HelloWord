/**
 * 
 */
package com.atguigu.mybatis.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.naming.InitialContext;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.atguigu.mybatis.entities.Cat;
import com.atguigu.mybatis.mapper.CatMapper;

/**
 * @author
 *
 */
public class Test_CatMapper {
	
	private SqlSessionFactory factory = null;
	
	@Before
	public void init() throws IOException{
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		factory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void testGetCatByMap2(){
		//声明sqlSession会话的引用
		SqlSession sqlSession = null;
		
		try {
			//给sqlSession会话赋值，通过工厂打开一个新的会话
			sqlSession = factory.openSession();
			
			//通过sqlSession会话，得到具体的接口实现类
			//方式类似于 spring里的getBean(xxx.class)
			CatMapper catMapper = sqlSession.getMapper(CatMapper.class);
			
			//准备输入参数map
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("age", 1);
			
			//调用接口实现类的具体方法
			//返回一个list集合
			List<Map<String, Object>> catList = catMapper.getCatByMap2(map);
			
			//遍历结果集list
			//list集合里有多个map
			for (Map<String, Object> elememnt : catList) {
				
				//每一个map里有一个set集合，里面有多个entry对象
				Set<Entry<String,Object>> entrySet = elememnt.entrySet();
				
				//把每一个entry对象放入进Iterator迭代器
				Iterator<Entry<String, Object>> iterator = entrySet.iterator();
				
				//遍历entry对象
				while (iterator.hasNext()) {
					//遍历entry对象
					Entry<String, Object> entry = iterator.next();
					
					//取对应的key和value
					String key = entry.getKey();
					Object value = entry.getValue();
					
					//打印出key和value   \t：制表符
					System.out.println(key + "\t" + value);
				}
				//打印完一个entry，换一行
				System.out.println("============================");
			}
			
		} catch (Exception e) {
			//打印异常信息
			e.printStackTrace();
		}finally{
			//关闭sqlSession会话
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	@Test
	public void testGtCatByMap(){
		
		SqlSession sqlSession = null;
		
		try {
			sqlSession = factory.openSession();
			
			CatMapper catMapper = sqlSession.getMapper(CatMapper.class);
			
			Map<String, Object> map= new HashMap<String, Object>();
			
			map.put("id", 3);
			map.put("age", 3);
			
			List<Cat> catList = catMapper.getCatByMap(map);
			
			for (Cat cat : catList) {
				System.out.println(cat);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	@Test
	public void testGetCatByCatName(){
		
		SqlSession sqlSession = null;
		
		try {
			sqlSession = factory.openSession();
			
			CatMapper catMapper = sqlSession.getMapper(CatMapper.class);
			
			List<Cat> listCat = catMapper.getCatByCatName("Cat");
			
			for (Cat cat : listCat) {
				System.out.println(cat);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	@Test
	public void testGetCatByObject(){
		
		SqlSession sqlSession = null;
		
		try {
			sqlSession = factory.openSession();
			
			CatMapper catMapper = sqlSession.getMapper(CatMapper.class);
			
			Cat cat = new Cat();
			cat.setCatName("%Cat%");
			
			List<Cat> listCat = catMapper.getCatByObject(cat);
			
			for (Cat element : listCat) {
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

	@Test
	public void testGetCatByConditions() {
		
		//声明SqlSession的引用
		SqlSession sqlSession = null;
		
		try {
			//给SqlSession赋值，工厂打开一个新的SqlSession
			sqlSession = factory.openSession();
			
			//SqlSession得到具体的接口实现类
			//方法类似于Spring里的factory.getBean(xxx.class)
			CatMapper catMapper = sqlSession.getMapper(CatMapper.class);
			
			//调用接口实现类的具体方法
			//准备入参
			Cat cat = new Cat(2, null, 5, null);
			
			//调用具体方法返回结果集
			List<Cat> catList = catMapper.getCatByConditions(cat);
			
			//打印结果集
			for (Cat element : catList) {
				System.out.println(element);
			}
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
