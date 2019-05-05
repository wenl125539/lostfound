package com.lostfound.dao;


import com.lostfound.pojo.LostType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LostTypeMapper {
    int deleteByPrimaryKey(Integer typeid);

    int insert(LostType record);

    int insertSelective(LostType record);

    LostType selectByPrimaryKey(Integer typeid);

    int updateByPrimaryKeySelective(LostType record);

    int updateByPrimaryKey(LostType record);
}