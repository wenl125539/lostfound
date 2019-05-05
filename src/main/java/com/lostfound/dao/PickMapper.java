package com.lostfound.dao;


import com.lostfound.pojo.Pick;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PickMapper {
    int deleteByPrimaryKey(Long pickId);

    int insert(Pick record);

    int insertSelective(Pick record);

    Pick selectByPrimaryKey(Long pickId);

    int updateByPrimaryKeySelective(Pick record);

    int updateByPrimaryKey(Pick record);
}