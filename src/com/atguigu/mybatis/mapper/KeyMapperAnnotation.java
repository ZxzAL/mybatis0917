package com.atguigu.mybatis.mapper;

import org.apache.ibatis.annotations.Select;

import com.atguigu.mybatis.entities.Key;

public interface KeyMapperAnnotation
{
	@Select("select * from tbl_key where id=#{id}")
	public Key getKeyById(Integer id);
}
