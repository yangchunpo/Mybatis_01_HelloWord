package com.atguigu.mybatis.mapper;

import java.util.List;

import com.atguigu.mybatis.entities.Dog;

public interface DogMapper {

	public List<Dog> getDogByDogName(String dogName);
	
	public List<Dog> getDogByDogNameAlias(String dogName);
	
	public List<Dog> getDogByDogNameResultMap(String dogName);

}
