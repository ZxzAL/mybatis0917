package com.atguigu.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.atguigu.mybatis.entities.Student;
import com.atguigu.mybatis.mapper.StudentMapper;

public class Test_DynamicSQL
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
	public void testGetByAge()
	{
		SqlSession sqlSession = null;
		try
		{
			sqlSession = sqlSessionFactory.openSession();
			StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
			
			List<Student> list = mapper.getByAge(20);
			for (Student student : list)
			{
				System.out.println(student.toString());
			}
		} catch (Exception e){
			e.printStackTrace();
		}finally{
			if(null != sqlSession) sqlSession.close();
		}
	}		
	
	@Test
	public void testGetByAge_If()
	{
		SqlSession sqlSession = null;
		try
		{
			sqlSession = sqlSessionFactory.openSession();
			StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
			
			List<Student> list = mapper.getByAge_If(22);
			for (Student student : list)
			{
				System.out.println(student.toString());
			}
		} catch (Exception e){
			e.printStackTrace();
		}finally{
			if(null != sqlSession) sqlSession.close();
		}
	}
	@Test
	public void testGetStudent_Where()
	{
		SqlSession sqlSession = null;
		try
		{
			sqlSession = sqlSessionFactory.openSession();
			StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
			Student student = new Student();
			
			student.setName("li4");
			student.setAge(22);
			
			List<Student> list = mapper.getStudent_Where(student);
			for (Student element : list)
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
	public void testGetStudent_chooseWhenOtherwise()
	{
		SqlSession sqlSession = null;
		try
		{
			sqlSession = sqlSessionFactory.openSession();
			StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
			
			Map<String,Object> map = new HashMap<String,Object>();
			//map.put("name","li4");
			map.put("age",-22);
			
			List<Student> list = mapper.getStudent_chooseWhenOtherwise(map);
			for (Student element : list)
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
	public void testGetStudent_Foreach()
	{
		SqlSession sqlSession = null;
		try
		{
			sqlSession = sqlSessionFactory.openSession();
			StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
			
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("ages",Arrays.asList(22,23,24));
			
			List<Student> list = mapper.getStudent_Foreach(map);
			for (Student element : list)
			{
				System.out.println(element.toString());
			}
		} catch (Exception e){
			e.printStackTrace();
		}finally{
			if(null != sqlSession) sqlSession.close();
		}
	}	
	
	//
	
	@Test
	public void testGetStudent_Trim()
	{
		SqlSession sqlSession = null;
		try
		{
			sqlSession = sqlSessionFactory.openSession();
			StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
			
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("name","li4");
			
			List<Student> list = mapper.getStudent_Trim(map);
			for (Student element : list)
			{
				System.out.println(element.toString());
			}
		} catch (Exception e){
			e.printStackTrace();
		}finally{
			if(null != sqlSession) sqlSession.close();
		}
	}	
	//
	@Test
	public void testInsertStudent_Trim()
	{
		SqlSession sqlSession = null;
		try
		{
			sqlSession = sqlSessionFactory.openSession();
			StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
			
			Student student = new Student();
			student.setAge(27);
			student.setBirth(new Date());
			student.setName("z4");
			//student.setScore(99.5);
			
			mapper.insertStudent_Trim(student);
			sqlSession.commit();
		} catch (Exception e){
			e.printStackTrace();
		}finally{
			if(null != sqlSession) sqlSession.close();
		}
	}	
	
	@Test
	public void testUpdateStudent()
	{
		SqlSession sqlSession = null;
		try
		{
			sqlSession = sqlSessionFactory.openSession();
			StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
			
			Student student = new Student();
			student.setAge(100);
			student.setBirth(new Date());
			student.setName("z4");
			//student.setScore(100);
			student.setId(5);
			
			mapper.updateStudent(student);
			sqlSession.commit();
		} catch (Exception e){
			e.printStackTrace();
		}finally{
			if(null != sqlSession) sqlSession.close();
		}
	}		
}
