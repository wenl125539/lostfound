package com.lostfound.service;

import com.lostfound.pojo.User;

public interface UserService {
    int register(User record);

    User login(User user);

    int addHead(User user);

    int edit(User user);
}
