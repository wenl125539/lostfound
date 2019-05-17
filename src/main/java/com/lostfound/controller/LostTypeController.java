package com.lostfound.controller;

import com.lostfound.pojo.LostType;
import com.lostfound.service.LostTypeService;
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
@RequestMapping(value = "/lostfound")
public class LostTypeController {

    @Autowired
    private LostTypeService lostTypeService;

    @ResponseBody
    @RequestMapping(value = "/addType",method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    public Map<String,Object> addType(@RequestBody LostType lostType){
        Map<String,Object> map = new HashMap<>();
        System.out.println(lostType.getTypeid()+":"+lostType.getTypename());
        try {
            int i = lostTypeService.insertType(lostType);
            map.put("msg",i);
        }catch (Exception e){
            map.put("msg",0);
            map.put("error","添加失败");
            e.printStackTrace();
        }
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/removeType",method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    public Map<String,Object> removeType(@RequestBody LostType lostType){
        Map<String,Object> map = new HashMap<>();
        System.out.println(lostType.getTypeid()+":"+lostType.getTypename());
        try {
            int i = lostTypeService.deleteType(lostType);
            map.put("msg",i);
        }catch (Exception e){
            map.put("msg",0);
            map.put("error","添加失败");
            e.printStackTrace();
        }
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/findAllType",method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    public Map<String,Object> findAllType(){
        Map<String,Object> map = new HashMap<>();
        try {
            List<LostType> lostTypes = lostTypeService.selectAllType();
            if(lostTypes.size() == 0){
                map.put("msg",0);
                map.put("error","添加失败");
                return map;
            }
            map.put("lostType",lostTypes);
            map.put("msg",1);
        }catch (Exception e){
            map.put("msg",0);
            map.put("error","添加失败");
            e.printStackTrace();
        }
        return map;
    }
}
