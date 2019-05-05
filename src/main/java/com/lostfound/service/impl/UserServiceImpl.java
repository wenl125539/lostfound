package com.lostfound.service.impl;

import com.lostfound.dao.UserMapper;
import com.lostfound.pojo.User;
import com.lostfound.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int register(User record) {
        return userMapper.register(record);
    }

    @Override
    public User login(User user) {
        User user2 = userMapper.login(user);
        if(user.getPassword().equals(user2.getPassword())){
            return user2;
        }
        return null;
    }


    @Override
    public int addHead(User user) {
        if(userMapper.login(user) == null){
            return 0;
        }
        return userMapper.addHead(user);
    }
}
