package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.entities.Lock;

public interface LockMapper {

	Lock getLockById(Integer id);
	
	Lock getLockById2(Integer id);
}
