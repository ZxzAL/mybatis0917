package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.entities.User;

public interface UserMapper
{
	 public User getUserById(Integer id);
	 
	 public void updateUser(User user);
}
