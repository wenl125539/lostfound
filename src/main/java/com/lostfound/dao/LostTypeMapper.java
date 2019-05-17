package com.lostfound.dao;

import com.lostfound.pojo.LostType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LostTypeMapper {



    int insertType(LostType record);

    List<LostType> selectAllType();

    int deleteType(LostType record);
}