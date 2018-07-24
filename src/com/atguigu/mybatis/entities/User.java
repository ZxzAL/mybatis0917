package com.atguigu.mybatis.entities;

import java.io.Serializable;

public class User implements Serializable
{
	 private Integer id;
	 private String  name;
	 private int     age;
	 
	 public User() {}
	 
	 

	public User(Integer id, String name, int age)
	{
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}



	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	@Override
	public String toString()
	{
		return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	 
	 
}
