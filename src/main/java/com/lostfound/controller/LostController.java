package com.lostfound.controller;



import com.lostfound.pojo.Increase.LostIncrease;
import com.lostfound.pojo.Lost;
import com.lostfound.service.LostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/lost")
public class LostController {
    @Autowired
    private LostService lostService;

    /**
     * 添加捡到物品信息
     * @param lostIncrease
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/insertLost")
    public Map<String,Object> insertPick(LostIncrease lostIncrease){
        Map<String,Object> map = new HashMap<>();
        try {
            int i = lostService.insertLost(lostIncrease);
            if(i == 0){
                map.put("msg","0");
                map.put("error","id重复");
                return map;
            }
            map.put("msg","1");
            return map;
        }catch (Exception e){
            map.put("msg","0");
            e.printStackTrace();
            return map;
        }
    }


    /**
     * 更新捡到物品信息
     * @param lostIncrease
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateByKey")
    public Map<String,Object> updateByKey(LostIncrease lostIncrease){
        Map<String,Object> map = new HashMap<>();
        try {
            int i =  lostService.updateByKey(lostIncrease);
            if(i == 0){
                map.put("msg","0");
                map.put("error","物品不存在");
                return map;
            }else{
                map.put("msg","1");
                return map;
            }
        }catch (Exception e){
            map.put("msg","0");
            return map;
        }
    }

    /**
     * 根据用户查询 上传的物品
     * @param lost
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectByUser", method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    public Map<String,Object> selectByUser(@RequestBody Lost lost){
        Map<String,Object> map = new HashMap<>();
        try {
            List<Lost> list = lostService.selectByUsername(lost);
            if(list == null || list.size() == 0){
                map.put("msg","0");
                return map;
            }
            map.put("msg",1);
            map.put("pick",list);
            return map;
        }catch (Exception e){
            e.printStackTrace();
            map.put("msg","0");
            return map;
        }
    }

    /**
     * 根据物品id查询 上传的物品
     * @param lost
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectByKey", method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    public Map<String,Object> selectByKey(@RequestBody Lost lost){
        Map<String,Object> map = new HashMap<>();
        try {

            Lost lost1= lostService.selectByKey(lost.getLostId());
            if(lost1 == null){
                map.put("msg",0);
                return map;
            }
            map.put("msg",1);
            map.put("pick",lost1);
            return map;
        }catch (Exception e){
            e.printStackTrace();
            map.put("msg","0");
            return map;
        }
    }

    /**
     * 查询所有物品
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectAllLost", method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    public Map<String,Object> selectAllPick(){
        Map<String,Object> map = new HashMap<>();
        try {
            List<Lost> list = lostService.selectAllLost();
            if(list.size() == 0 || list == null){
                map.put("msg","0");
                map.put("error","没有丢失物品");
                return map;
            }
            map.put("msg",1);
            map.put("pick",list);
            return map;
        }catch (Exception e){
            e.printStackTrace();
            map.put("msg","0");
            return map;
        }
    }

    /**
     * 根据id删除物品
     * @param lost
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteById", method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    public Map<String,Object> deleteById(@RequestBody Lost lost){
        Map<String,Object> map = new HashMap<>();
        try {
            lostService.deleteByKey(lost.getLostId());
            map.put("msg",1);
            return map;
        }catch (Exception e){
            e.printStackTrace();
            map.put("msg","0");
            return map;
        }
    }

    /**
     * 根据id改变物品 招领状态
     * @param lost
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateStatus", method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    public Map<String,Object> updateStatus(@RequestBody Lost lost){
        Map<String,Object> map = new HashMap<>();
        try {
            lostService.updateStatus(lost.getLostId());
            map.put("msg",1);
            return map;
        }catch (Exception e){
            e.printStackTrace();
            map.put("msg","0");
            return map;
        }
    }
}
