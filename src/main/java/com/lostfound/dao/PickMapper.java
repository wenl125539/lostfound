package com.lostfound.dao;

import com.lostfound.pojo.Pick;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PickMapper {
    int deleteByKey(Long pickId);

    int insertPick(Pick record);


    Pick selectByKey(Long pickId);

    int updateByKey(Pick record);

}