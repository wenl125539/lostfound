package com.lostfound.dao;

import com.lostfound.pojo.Lost;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LostMapper {
    int deleteByPrimaryKey(Long lostId);

    int insert(Lost record);

    int insertSelective(Lost record);

    Lost selectByPrimaryKey(Long lostId);

    int updateByPrimaryKeySelective(Lost record);

    int updateByPrimaryKey(Lost record);
}