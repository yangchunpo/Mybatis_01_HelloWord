package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.entities.User;

public interface UserMapper {

	User getUserById(Integer id);
	
	void updateUser(User user);
}
