package com.lostfound.service.impl;


import com.lostfound.dao.LostMapper;
import com.lostfound.dao.PickMapper;
import com.lostfound.pojo.Increase.LostIncrease;
import com.lostfound.pojo.Increase.PickIncrease;
import com.lostfound.pojo.Lost;
import com.lostfound.pojo.Pick;
import com.lostfound.service.LostService;
import com.lostfound.service.PickService;
import com.lostfound.uitls.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Service("lostService")
public class LostServiceImpl implements LostService
{
    @Autowired
    private LostMapper lostMapper;


    @Override
    public int deleteByKey(Long lostId) {
        return lostMapper.deleteByKey(lostId);
    }

    @Override
    public int insertLost(LostIncrease record) {

        Lost lost = selectByKey(record.getLostId());
        if(lost != null){
            return 0;
        }
             MultipartFile file = record.getFile();
             MultipartFile file2 = record.getFile2();
             MultipartFile file3 = record.getFile3();
             if(file != null){
                 String path = UploadFile.store(file);
                 record.setLostPhoto(path);
             }
            if(file2 != null){
                String path = UploadFile.store(file2);
                record.setLostPhoto2(path);
            }
            if(file3 != null){
                String path = UploadFile.store(file3);
                record.setLostPhoto3(path);
            }
           record.setLtime(new Date());
            return lostMapper.insertLost(record);
    }

    @Override
    public Lost selectByKey(Long lostId) {
        return lostMapper.selectByKey(lostId);
    }

    @Override
    public int updateByKey(LostIncrease record) {

        Lost lost = selectByKey(record.getLostId());
        if(lost == null){
            return 0;
        }
        MultipartFile file = record.getFile();
        MultipartFile file2 = record.getFile2();
        MultipartFile file3 = record.getFile3();
        if(file != null){
            String path = UploadFile.store(file);
            record.setLostPhoto(path);
        }
        if(file2 != null){
            String path = UploadFile.store(file2);
            record.setLostPhoto2(path);
        }
        if(file3 != null){
            String path = UploadFile.store(file3);
            record.setLostPhoto3(path);
        }

        record.setLtime(new Date());
        return lostMapper.updateByKey(record);
    }

    @Override
    public List<Lost> selectByUsername(Lost record) {
        return lostMapper.selectByUsername(record);
    }

    @Override
    public List<Lost> selectAllLost() {
        return lostMapper.selectAllLost();
    }

    @Override
    public int updateStatus(Long pickId) {
        return lostMapper.updateStatus(pickId);
    }
}
