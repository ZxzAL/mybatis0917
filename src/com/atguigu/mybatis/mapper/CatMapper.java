package com.atguigu.mybatis.mapper;

import java.util.List;
import java.util.Map;

import com.atguigu.mybatis.entities.Cat;

public interface CatMapper
{
	
	public List<Cat> getCatByCatNameByValue(String catName);
	
	public List<Cat> getCatByConditions(Cat cat);
	
	public List<Cat> getCatByCatName(Cat cat);
	
	public List<Cat> getCatByMap(Map<String,Object> map);	
	
	public List<Map<String,Object>> getCatByMapRetMap(Map<String,Object> map);
}
