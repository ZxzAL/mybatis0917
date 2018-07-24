package com.atguigu.mybatis.mapper;

import java.util.List;

import com.atguigu.mybatis.entities.Dog;

public interface DogMapper
{
	public List<Dog> getDogByName(String dogName);
}
