package com.lostfound.dao;

import com.lostfound.pojo.Lost;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Mapper
@Repository
public interface LostMapper {
    /**
     * 根据key删除
     * @param lostId
     * @return
     */
    int deleteByKey(Long lostId);
    /**
     * 根据id查找该物品所有信息
     * @param lostId
     * @return
     */
    Lost selectByKey(Long lostId);
    /**
     * 根据id更新该物品所有信息
     * @param record
     * @return
     */
    int updateByKey(Lost record);
    /**
     * 添丢失物品信息
     * @param record
     * @return
     */
    int insertLost(Lost record);


    /**
     * 根据用户查找该用户上传 的 物品的所有信息
     * @param record
     * @return
     */
    List<Lost> selectByUsername(Lost record);

    /**
     * 获取所有丢失物品记录
     * @return
     */
    List<Lost> selectAllLost();

    /**
     * 根据id改变物品 招领状态
     * @param pickId
     * @return
     */
    int updateStatus(Long pickId);
}