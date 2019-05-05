package com.lostfound.dao;


import com.lostfound.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    int register(User record);

    User login(User record);

    int addHead(User user);
}