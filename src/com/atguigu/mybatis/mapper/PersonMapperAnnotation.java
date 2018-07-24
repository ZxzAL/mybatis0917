package com.atguigu.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.atguigu.mybatis.entities.Person;

public interface PersonMapperAnnotation
{
	@Insert("insert into tbl_person(name,age,birth,registerTime,salary) values(#{name},#{age},#{birth},#{registerTime},#{salary})")
	@Options(useGeneratedKeys=true,keyProperty="id")
	public void add(Person person);
	
	@Delete("delete from tbl_person where id=#{id}")
	public void delete(Integer id);
	
	@Update("update tbl_person set name=#{name},age=#{age},birth=#{birth},registerTime=#{registerTime},salary=#{salary} where id=#{id}")
	public void update(Person person);
	
	@Select("select id,name,age,birth,registerTime,salary from tbl_person where id=#{id}")
	public Person getPersonById(Integer id);
	
	@Select("")
	public List<Person> getAll();
}
