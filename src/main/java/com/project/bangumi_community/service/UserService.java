package com.project.bangumi_community.service;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.bangumi_community.repository.UserMapper;
import com.project.bangumi_community.domain.User;

@Component
public class UserService {
	@Autowired
	UserMapper userMapper;
	
	Set<User> userSet = new HashSet<User>();
	public User loginCheck(String name, String password) {
		User user = userMapper.getUsersById(name, password);
		if(user != null) {
			userSet.add(user);
		}
		return user;
	}
	
	
}
