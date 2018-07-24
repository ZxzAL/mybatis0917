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

public class Test_HelloMapper
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
			
			PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
			
			Person person = new Person();
			person.setAge(22);
			person.setBirth(new Date());
			person.setName("z11");
			person.setRegisterTime(new Date());
			person.setSalary(9500.35);
			
			mapper.add(person);
			
			System.out.println("#########OID: "+person.getId());
			
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
			
			PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
			mapper.delete(1);
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
			
			PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
			Person person = new Person();
			person.setAge(27);
			person.setBirth(new Date());
			person.setName("z4");
			person.setRegisterTime(new Date());
			person.setSalary(9500.35);
			person.setId(2);
			
			mapper.update(person);
			
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
			
			PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
			
			Person person = mapper.getPersonById(2);
			System.out.println(person.toString());
			
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
			
			PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
			
			List<Person> list = mapper.getAll();
			for (Person person : list)
			{
				System.out.println(person.toString());
			}
			sqlSession.commit();
		} catch (Exception e){
			e.printStackTrace();
		}finally{
			if(null != sqlSession) sqlSession.close();
		}
		
	}		
	
	
}
