package com.atguigu.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.atguigu.mybatis.entities.Dog;
import com.atguigu.mybatis.mapper.DogMapper;

public class Test_ResultMap
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
	public void testGetDogByName()
	{
		SqlSession sqlSession = null;
		try
		{
			sqlSession = sqlSessionFactory.openSession();
			DogMapper mapper = sqlSession.getMapper(DogMapper.class);
			
			List<Dog> list = mapper.getDogByName("%ww%");
			for (Dog dog : list)
			{
				System.out.println(dog.toString());
			}
		} catch (Exception e){
			e.printStackTrace();
		}finally{
			if(null != sqlSession) sqlSession.close();
		}
	}		

}
