package com.atguigu.mybatis.mapper;

import java.util.List;
import java.util.Map;

import com.atguigu.mybatis.entities.Cat;

public interface CatMapper {

	//入参为 实体类
	List<Cat> getCatByConditions(Cat cat);
	
	//入参为实体类
	List<Cat> getCatByObject(Cat cat);
	
	//入参为 字符串
	List<Cat> getCatByCatName(String catName);
	
	//入参为 map
	List<Cat> getCatByMap(Map<String, Object> map);
	
	//入参为map，返回list集合里也是map
	List<Map<String, Object>> getCatByMap2(Map<String, Object> map);
	
}
