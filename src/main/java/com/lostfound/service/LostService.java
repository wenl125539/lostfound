package com.lostfound.service;


import com.lostfound.pojo.Lost;

public interface LostService {
    int deleteByKey(Long lostId);

    int insertLost(Lost record);

    Lost selectByKey(Long lostId);

    int updateByKey(Lost record);
}
