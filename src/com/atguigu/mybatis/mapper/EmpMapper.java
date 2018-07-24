package com.atguigu.mybatis.mapper;

import java.util.List;

import com.atguigu.mybatis.entities.Emp;

public interface EmpMapper
{
	//此处是辅助方法，目的是通过部门ID查询出该部门下的全部员工给Dept
	public List<Emp> getEmpByDeptId(Integer deptId);
	
	
	//自身业务，按照员工ID查出自身信息和所属部门
	public Emp getEmpById(Integer id);
}
