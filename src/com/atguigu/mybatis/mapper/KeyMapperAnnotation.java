package com.atguigu.mybatis.mapper;

import org.apache.ibatis.annotations.Insert;

import com.atguigu.mybatis.entities.Key;

public interface KeyMapperAnnotation {

	@Insert("select id, keyName from hj_ycp.tb_key where id=#{id};")
	Key getKeyById(Integer id);
}
