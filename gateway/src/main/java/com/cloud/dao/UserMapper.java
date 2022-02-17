package com.cloud.dao;

import com.cloud.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    String getPassword(String userName);
}
