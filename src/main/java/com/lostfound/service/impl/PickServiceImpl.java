package com.lostfound.service.impl;


import com.lostfound.dao.PickMapper;
import com.lostfound.pojo.Increase.PickIncrease;
import com.lostfound.pojo.Pick;
import com.lostfound.service.PickService;
import com.lostfound.uitls.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Service("pickService")
public class PickServiceImpl implements PickService
{
    @Autowired
    private PickMapper pickMapper;


    @Override
    public int deleteByKey(Long pickId) {
        return pickMapper.deleteByKey(pickId);
    }

    @Override
    public int insertPick(PickIncrease record) {
             MultipartFile file = record.getFile();
             MultipartFile file2 = record.getFile2();
             MultipartFile file3 = record.getFile3();
             if(file != null){
                 String path = UploadFile.store(file);
                 record.setPickPhoto(path);
             }
            if(file2 != null){
                String path = UploadFile.store(file2);
                record.setPickPhoto2(path);
            }
            if(file3 != null){
                String path = UploadFile.store(file3);
                record.setPickPhoto3(path);
            }

           record.setPickTime(new Date());
        return pickMapper.insertPick(record);
    }

    @Override
    public Pick selectByKey(Long pickId) {
        return pickMapper.selectByKey(pickId);
    }

    @Override
    public int updateByKey(PickIncrease record) {
        MultipartFile file = record.getFile();
        MultipartFile file2 = record.getFile2();
        MultipartFile file3 = record.getFile3();
        if(file != null){
            String path = UploadFile.store(file);
            record.setPickPhoto(path);
        }
        if(file2 != null){
            String path = UploadFile.store(file2);
            record.setPickPhoto2(path);
        }
        if(file3 != null){
            String path = UploadFile.store(file3);
            record.setPickPhoto3(path);
        }

        record.setPickTime(new Date());
        return pickMapper.updateByKey(record);
    }

    @Override
    public List<Pick> selectByUsername(Pick record) {
        return pickMapper.selectByUsername(record);
    }

    @Override
    public List<Pick> selectAllPick() {
        return pickMapper.selectAllPick();
    }

    @Override
    public int updateStatus(Long pickId) {
        return pickMapper.updateStatus(pickId);
    }
}
