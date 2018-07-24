package com.atguigu.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.atguigu.mybatis.entities.Dept;
import com.atguigu.mybatis.entities.Emp;
import com.atguigu.mybatis.mapper.DeptMapper;
import com.atguigu.mybatis.mapper.DeptMapperAnnotation;
import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.mapper.EmpMapperAnnotation;

public class Test_One2Many
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
	public void testGetDeptById()
	{
		SqlSession sqlSession = null;
		try
		{
			sqlSession = sqlSessionFactory.openSession();
			DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
			Dept dept = mapper.getDeptById(2);
			System.out.println(dept.getDeptName());
			System.out.println(dept.getEmps().size());
		} catch (Exception e){
			e.printStackTrace();
		}finally{
			if(null != sqlSession) sqlSession.close();
		}
	}
	
	@Test
	public void testGetEmpById()
	{
		SqlSession sqlSession = null;
		try
		{
			sqlSession = sqlSessionFactory.openSession();
			EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
			Emp emp = mapper.getEmpById(1);
			System.out.println(emp.getName());
			System.out.println(emp.getDept().getDeptName());
		} catch (Exception e){
			e.printStackTrace();
		}finally{
			if(null != sqlSession) sqlSession.close();
		}
	}	
	
	@Test
	public void testGetDeptById_Annotation()
	{
		SqlSession sqlSession = null;
		try
		{
			sqlSession = sqlSessionFactory.openSession();
			DeptMapperAnnotation mapper = sqlSession.getMapper(DeptMapperAnnotation.class);
			Dept dept = mapper.getDeptById(2);
			System.out.println(dept.getDeptName());
			System.out.println(dept.getEmps().size());
		} catch (Exception e){
			e.printStackTrace();
		}finally{
			if(null != sqlSession) sqlSession.close();
		}
	}
	
	@Test
	public void testGetEmpById_Annotation()
	{
		SqlSession sqlSession = null;
		try
		{
			sqlSession = sqlSessionFactory.openSession();
			EmpMapperAnnotation mapper = sqlSession.getMapper(EmpMapperAnnotation.class);
			Emp emp = mapper.getEmpById(4);
			System.out.println(emp.getName());
			System.out.println(emp.getDept().getDeptName());
		} catch (Exception e){
			e.printStackTrace();
		}finally{
			if(null != sqlSession) sqlSession.close();
		}
	}
}
