package com.lostfound.service;

import com.lostfound.pojo.LostType;

import java.util.List;

public interface LostTypeService {

    int insertType(LostType record);

    List<LostType> selectAllType();

    int deleteType(LostType record);
}
