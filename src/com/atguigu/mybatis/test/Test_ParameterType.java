package com.atguigu.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.atguigu.mybatis.entities.Cat;
import com.atguigu.mybatis.mapper.CatMapper;

public class Test_ParameterType
{
	private SqlSessionFactory sqlSessionFactory = null;
	
	@Before
	public void inti() throws IOException
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void testGetCatByConditions()
	{
		SqlSession sqlSession = null;
		try
		{
			sqlSession = sqlSessionFactory.openSession();
			CatMapper mapper = sqlSession.getMapper(CatMapper.class);
			Cat cat = new Cat();
			cat.setId(1);
			cat.setAge(7);
			List<Cat> list = mapper.getCatByConditions(cat);
			for (Cat element : list)
			{
				System.out.println(element.toString());
			}
		} catch (Exception e){
			e.printStackTrace();
		}finally{
			if(null != sqlSession) sqlSession.close();
		}
	}		
	
	@Test
	public void testGetCatByCatName()
	{
		SqlSession sqlSession = null;
		try
		{
			sqlSession = sqlSessionFactory.openSession();
			CatMapper mapper = sqlSession.getMapper(CatMapper.class);
			Cat cat = new Cat();
			cat.setCatName("%Cat%");
			List<Cat> list = mapper.getCatByCatName(cat);
			for (Cat element : list)
			{
				System.out.println(element.toString());
			}
		} catch (Exception e){
			e.printStackTrace();
		}finally{
			if(null != sqlSession) sqlSession.close();
		}
	}	
	
	@Test
	public void testGetCatByCatNameByValue()
	{
		SqlSession sqlSession = null;
		try
		{
			sqlSession = sqlSessionFactory.openSession();
			CatMapper mapper = sqlSession.getMapper(CatMapper.class);
			
			List<Cat> list = mapper.getCatByCatNameByValue("Cat");
			for (Cat element : list)
			{
				System.out.println(element.toString());
			}
		} catch (Exception e){
			e.printStackTrace();
		}finally{
			if(null != sqlSession) sqlSession.close();
		}
	}	
	
	@Test
	public void testGetCatByMap()
	{
		SqlSession sqlSession = null;
		try
		{
			sqlSession = sqlSessionFactory.openSession();
			CatMapper mapper = sqlSession.getMapper(CatMapper.class);
			
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id",1);
			map.put("age",7);
			List<Cat> list = mapper.getCatByMap(map);
			for (Cat element : list)
			{
				System.out.println(element.toString());
			}
		} catch (Exception e){
			e.printStackTrace();
		}finally{
			if(null != sqlSession) sqlSession.close();
		}
	}	
	
	@Test
	public void testGetCatByMapRetMap()
	{
		SqlSession sqlSession = null;
		try
		{
			sqlSession = sqlSessionFactory.openSession();
			CatMapper mapper = sqlSession.getMapper(CatMapper.class);
			
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("age",2);
			 
			List<Map<String,Object>> list = mapper.getCatByMapRetMap(map);
			for (Map<String, Object> element : list)
			{
				Iterator<Map.Entry<String,Object>> it = element.entrySet().iterator();
				while(it.hasNext())
				{
					Map.Entry<String,Object> entry = it.next();
					System.out.println(entry.getKey()+"\t"+entry.getValue());
				}
				System.out.println("=========");
			}
		} catch (Exception e){
			e.printStackTrace();
		}finally{
			if(null != sqlSession) sqlSession.close();
		}
	}		
	//
	
}
