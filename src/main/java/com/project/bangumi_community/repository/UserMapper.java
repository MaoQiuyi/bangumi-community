package com.project.bangumi_community.repository;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.project.bangumi_community.domain.User;

@Mapper
public interface UserMapper {
	@Select("SELECT * FROM USER WHERE name = #{name} AND password=#{password}")
	User getUsersById(@Param("name") String name, @Param("password") String password);
}
