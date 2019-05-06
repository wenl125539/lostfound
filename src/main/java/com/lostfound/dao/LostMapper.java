package com.lostfound.dao;

import com.lostfound.pojo.Lost;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LostMapper {
    int deleteByKey(Long lostId);

    int insertLost(Lost record);

    Lost selectByKey(Long lostId);

    int updateByKey(Lost record);
}