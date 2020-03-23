package com.atguigu.mybatis.mapper;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.atguigu.mybatis.entities.Lock;

public interface LockMapperAnnotation {

	@Select("select * from hj_ycp.tb_lock where id=#{id};")
	@Results({
		@Result(id=true,property="id",column="id"),
		@Result(property="lockName", column="lockName"),
		@Result(property="key",column="key_id", one=@One(select="com.atguigu.mybatis.mapper.KeyMapper.getKeyById") )
	})
	Lock getLockById2(Integer id);
}
