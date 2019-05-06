package com.lostfound.service;

import com.lostfound.pojo.Increase.PickIncrease;
import com.lostfound.pojo.Pick;

import java.util.List;

public interface PickService {

    /**
     * 根据key删除
     * @param pickId
     * @return
     */
    int deleteByKey(Long pickId);

    /**
     * 添加拾到物品信息
     * @param record
     * @return
     */
    int insertPick(PickIncrease record);

    /**
     * 根据id查找该物品所有信息
     * @param pickId
     * @return
     */
    Pick selectByKey(Long pickId);

    /**
     * 根据id更新该物品所有信息
     * @param record
     * @return
     */
    int updateByKey(PickIncrease record);

    /**
     * 根据用户查找该用户上传 的 物品的所有信息
     * @param record
     * @return
     */
    List<Pick> selectByUsername(Pick record);

    /**
     * 获取所有物品记录
     * @return
     */
    List<Pick> selectAllPick();

    /**
     * 根据id改变物品 招领状态
     * @param pickId
     * @return
     */
    int updateStatus(Long pickId);

}
