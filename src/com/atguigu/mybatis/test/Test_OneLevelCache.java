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

public class Test_OneLevelCache
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
	public void testOneLevelCache()
	{
		SqlSession sqlSession = null;
		try
		{
			sqlSession = sqlSessionFactory.openSession();

			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

			User user = userMapper.getUserById(1);
			System.out.println(user.toString());

			/**
			 * 一级缓存默认会被使用,执行下面的结果可以看到，User user2，但是sql还是一条
			 
			User user2 = userMapper.getUserById(1);
			System.out.println(user2.toString());*/

			/**
			 * 1必须是同样的查询条件
			 User user2 = userMapper.getUserById(2);
			 System.out.println(user2.toString());*/
			 

			/**
			 * 2必须是同一个sqlSession，如果关闭过一次，那就另外算了。
			 sqlSession.close(); 
			 sqlSession = sqlSessionFactory.openSession(); 
			 userMapper = sqlSession.getMapper(UserMapper.class); 
			 User user2 = userMapper.getUserById(1); 
			 System.out.println(user2.toString());*/
			 

			/**
			 * 3没有执行过sqlSession.clearCache(); 
			 sqlSession.clearCache(); 
			 User user2 = userMapper.getUserById(1);
			 System.out.println(user2.toString());*/
			 

			/**
			 * 
			 * 4没有执行过增删改 */
			 userMapper.updateUser(new User(1,"lisi",363));
			 sqlSession.commit(); 
			 user = userMapper.getUserById(1);
			 System.out.println(user.toString());
			 

		} catch (Exception e){
			e.printStackTrace();
		} finally{
			if (null != sqlSession)
				sqlSession.close();
		}

	}
}
