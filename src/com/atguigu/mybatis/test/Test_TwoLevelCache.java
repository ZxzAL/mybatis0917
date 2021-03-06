package com.atguigu.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.atguigu.mybatis.entities.User;
import com.atguigu.mybatis.mapper.UserMapper;

public class Test_TwoLevelCache
{
	private SqlSessionFactory sqlSessionFactory = null;
	  
	  @Before
	  public void init() throws IOException
	  {
	     String resource = "mybatis-config.xml";
	     InputStream inputStream = Resources.getResourceAsStream(resource);
	     sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	  }
	  
	  @Test
	  public void test_GetUserById()
	  {
	     SqlSession sqlSession1 = sqlSessionFactory.openSession();
	     UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
	     User user1 = userMapper1.getUserById(1);
	     System.out.println(user1.toString());
	     sqlSession1.close();
	     
	     SqlSession sqlSession2 = sqlSessionFactory.openSession();
	     UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
	     User user2 = userMapper2.getUserById(1);
	     System.out.println(user2.toString());
	     sqlSession2.close();
	     
	  }
}
