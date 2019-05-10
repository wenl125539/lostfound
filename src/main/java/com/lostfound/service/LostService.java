package com.lostfound.service;

import com.lostfound.pojo.Increase.LostIncrease;
import com.lostfound.pojo.Increase.PickIncrease;
import com.lostfound.pojo.Lost;
import com.lostfound.pojo.Pick;

import java.util.List;

public interface LostService {

    /**
     * 根据key删除
     * @param lostId
     * @return
     */
    int deleteByKey(Long lostId);

    /**
     * 添加拾到物品信息
     * @param record
     * @return
     */
    int insertLost(LostIncrease record);

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
    int updateByKey(LostIncrease record);

    /**
     * 根据用户查找该用户上传 的 物品的所有信息
     * @param record
     * @return
     */
    List<Lost> selectByUsername(Lost record);

    /**
     * 获取所有物品记录
     * @return
     */
    List<Lost> selectAllLost();

    /**
     * 根据id改变物品 招领状态
     * @param lostId
     * @return
     */
    int updateStatus(Long lostId);

}
