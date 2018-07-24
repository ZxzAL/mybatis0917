package com.atguigu.mybatis.entities;

import java.util.List;

public class Dept
{
	 private Integer id;
	 private String  deptName;
	 private String  locAdd;
	 private List<Emp> emps;//一个部门含有多个员工
	 
	 public Dept() {}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getDeptName()
	{
		return deptName;
	}

	public void setDeptName(String deptName)
	{
		this.deptName = deptName;
	}

	public String getLocAdd()
	{
		return locAdd;
	}

	public void setLocAdd(String locAdd)
	{
		this.locAdd = locAdd;
	}

	public List<Emp> getEmps()
	{
		return emps;
	}

	public void setEmps(List<Emp> emps)
	{
		this.emps = emps;
	}
	 
	 
}
