package com.atguigu.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.atguigu.mybatis.entities.Person;
import com.atguigu.mybatis.mapper.PersonMapper;

public class Test_HelloNativeAPI
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
	public void testAdd()
	{
		SqlSession sqlSession = null;
		try
		{
			sqlSession = sqlSessionFactory.openSession();
			
			
			Person person = new Person();
			person.setAge(22);
			person.setBirth(new Date());
			person.setName("z35");
			person.setRegisterTime(new Date());
			person.setSalary(9500.35);
			
			sqlSession.insert("com.atguigu.mybatis.mapper.PersonMapper.add", person);
			
			sqlSession.commit();
		} catch (Exception e){
			e.printStackTrace();
		}finally{
			if(null != sqlSession) sqlSession.close();
		}
		
	}
	
		
	
	@Test
	public void testDelete()
	{
		SqlSession sqlSession = null;
		try
		{
			sqlSession = sqlSessionFactory.openSession();
			//家庭作业
			//sqlSession.delete(arg0, arg1);
			sqlSession.commit();
		} catch (Exception e){
			e.printStackTrace();
		}finally{
			if(null != sqlSession) sqlSession.close();
		}
		
	}	

	
	@Test
	public void testUpdate()
	{
		SqlSession sqlSession = null;
		try
		{
			sqlSession = sqlSessionFactory.openSession();
			//家庭作业
			sqlSession.commit();
		} catch (Exception e){
			e.printStackTrace();
		}finally{
			if(null != sqlSession) sqlSession.close();
		}
		
	}	
	
	
	@Test
	public void testGetPersonById()
	{
		SqlSession sqlSession = null;
		try
		{
			sqlSession = sqlSessionFactory.openSession();
			//家庭作业,
			//sqlSession.selectOne(arg0, arg1);
			sqlSession.commit();
		} catch (Exception e){
			e.printStackTrace();
		}finally{
			if(null != sqlSession) sqlSession.close();
		}
		
	}		
	
	@Test
	public void testGetAll()
	{
		SqlSession sqlSession = null;
		try
		{
			sqlSession = sqlSessionFactory.openSession();
			//家庭作业,
			//sqlSession.selectList(arg0, arg1)
			sqlSession.commit();
		} catch (Exception e){
			e.printStackTrace();
		}finally{
			if(null != sqlSession) sqlSession.close();
		}
		
	}		
	
	
}
