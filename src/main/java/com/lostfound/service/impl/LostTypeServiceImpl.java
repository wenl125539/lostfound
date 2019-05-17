package com.lostfound.service.impl;

import com.lostfound.dao.LostTypeMapper;
import com.lostfound.pojo.LostType;
import com.lostfound.service.LostTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "lostTypeService")
public class LostTypeServiceImpl implements LostTypeService {
    @Autowired
    private LostTypeMapper lostTypeMapper;

    @Override
    public int insertType(LostType record) {
        return lostTypeMapper.insertType(record);
    }

    @Override
    public List<LostType> selectAllType() {
        return lostTypeMapper.selectAllType();
    }

    @Override
    public int deleteType(LostType record) {
        return lostTypeMapper.deleteType(record);
    }
}
