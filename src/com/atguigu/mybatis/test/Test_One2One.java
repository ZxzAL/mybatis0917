package com.atguigu.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.atguigu.mybatis.entities.Lock;
import com.atguigu.mybatis.mapper.LockMapper;
import com.atguigu.mybatis.mapper.LockMapperAnnotaion;

public class Test_One2One
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
	public void testGetLockById()
	{
		SqlSession sqlSession = null;
		try
		{
			sqlSession = sqlSessionFactory.openSession();
			LockMapper mapper = sqlSession.getMapper(LockMapper.class);
			Lock lock = mapper.getLockById(1);
			System.out.println(lock.getLockName());
			System.out.println(lock.getKey().getKeyName());
		} catch (Exception e){
			e.printStackTrace();
		}finally{
			if(null != sqlSession) sqlSession.close();
		}
	}
	
	@Test
	public void testGetLockById2()
	{
		SqlSession sqlSession = null;
		try
		{
			sqlSession = sqlSessionFactory.openSession();
			LockMapper mapper = sqlSession.getMapper(LockMapper.class);
			Lock lock = mapper.getLockById(1);
			System.out.println(lock.getLockName());
			//System.out.println(lock.getKey().getKeyName());
		} catch (Exception e){
			e.printStackTrace();
		}finally{
			if(null != sqlSession) sqlSession.close();
		}
	}	
	

	@Test
	public void testGetLockById_Annotation()
	{
		SqlSession sqlSession = null;
		try
		{
			sqlSession = sqlSessionFactory.openSession();
			LockMapperAnnotaion mapper = sqlSession.getMapper(LockMapperAnnotaion.class);
			Lock lock = mapper.getLockById(1);
			System.out.println(lock.getLockName());
			System.out.println(lock.getKey().getKeyName());
		} catch (Exception e){
			e.printStackTrace();
		}finally{
			if(null != sqlSession) sqlSession.close();
		}
	}	

}
