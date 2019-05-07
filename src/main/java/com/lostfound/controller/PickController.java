package com.lostfound.controller;


import com.lostfound.pojo.Increase.PickIncrease;
import com.lostfound.pojo.Pick;
import com.lostfound.service.PickService;
import com.lostfound.uitls.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/lostfound")
public class PickController {
    @Autowired
    private PickService pickService;

    /**
     * 添加捡到物品信息
     * @param pickIncrease
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/insertPick")
    public Map<String,Object> insertPick(PickIncrease pickIncrease){
        Map<String,Object> map = new HashMap<>();
        try {
            int i = pickService.insertPick(pickIncrease);
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
     * @param pickIncrease
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateByKey")
    public Map<String,Object> updateByKey(PickIncrease pickIncrease){
        Map<String,Object> map = new HashMap<>();
        try {
           int i =  pickService.updateByKey(pickIncrease);
           if(i == 0){
               map.put("msg","0");
               map.put("error","物品不存在");
               return map;
           }
            map.put("msg","1");
            return map;
        }catch (Exception e){
            map.put("msg","0");
            return map;
        }
    }

    /**
     * 根据用户查询 上传的物品
     * @param pick
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectByUser", method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    public Map<String,Object> selectByUser(@RequestBody Pick pick){
        Map<String,Object> map = new HashMap<>();
        try {
            List<Pick> list = pickService.selectByUsername(pick);
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
     * @param pick
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectByKey", method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    public Map<String,Object> selectByKey(@RequestBody Pick pick){
        Map<String,Object> map = new HashMap<>();
        try {

            Pick pick1= pickService.selectByKey(pick.getPickId());
            if(pick1 == null){
                map.put("msg",0);
                return map;
            }
            map.put("msg",1);
            map.put("pick",pick1);
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
    @RequestMapping(value = "/selectAllPick", method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    public Map<String,Object> selectAllPick(){
        Map<String,Object> map = new HashMap<>();
        try {
            List<Pick> list = pickService.selectAllPick();
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
     * @param pick
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteById", method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    public Map<String,Object> deleteById(@RequestBody Pick pick){
        Map<String,Object> map = new HashMap<>();
        try {
            pickService.deleteByKey(pick.getPickId());
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
     * @param pick
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateStatus", method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    public Map<String,Object> updateStatus(@RequestBody Pick pick){
        Map<String,Object> map = new HashMap<>();
        try {
            pickService.updateStatus(pick.getPickId());
            map.put("msg",1);
            return map;
        }catch (Exception e){
            e.printStackTrace();
            map.put("msg","0");
            return map;
        }
    }
}
