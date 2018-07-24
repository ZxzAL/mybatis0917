package com.atguigu.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.atguigu.mybatis.entities.Dept;
import com.atguigu.mybatis.entities.Emp;

public interface EmpMapperAnnotation
{
	@Select("select * from tbl_emp where deptId=#{deptId}")
	@Results({
		@Result(id=true,property="id",column="id"),
		@Result(property="name",column="name")
	})
	public List<Emp> getEmpByDeptId(Integer deptId);
	
	
	//自身业务，按照员工ID查出自身信息和所属部门
	@Select("select * from tbl_emp where id=#{id}")
	@Results({
		@Result(id=true,property="id",column="id"),
		@Result(property="name",column="name"),	
		@Result(property="dept",column="deptId",one=@One(select="com.atguigu.mybatis.mapper.DeptMapperAnnotation.getDeptById"))	
	})
	public Emp getEmpById(Integer id);	
	
}
