package com.lostfound.controller;

import com.alibaba.fastjson.JSONObject;
import com.lostfound.pojo.User;
import com.lostfound.service.UserService;
import com.lostfound.uitls.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/lostfound")
public class UserController {

        @Autowired
        private UserService userService;
        private Map<String,Object> map = null;

    /**
     * 注册
     * @param jsonObject
     * @return
     */
    @ResponseBody
        @RequestMapping(value = "/register",method = {RequestMethod.POST})
        public Map<String,Object> register(@RequestBody JSONObject jsonObject){
            try {
                map = new HashMap<>();
                User user = jsonObject.toJavaObject(User.class);
                int result = userService.register(user);
                if(result == 0){
                    map.put("msg","0");//返回0 没储存成功
                }else{
                    map.put("msg","1");//返回1 储存成功
                }
            }catch (Exception e){
                //抛出异常
                map.put("msg","用户已存在");
                return map;
            }
            return map;
        }

    /**
     * 登录
     * @param jsonObject
     * @return
     */
    @ResponseBody
        @RequestMapping(value = "/login",method = {RequestMethod.POST})
        public Map<String,Object> login(@RequestBody JSONObject jsonObject){
            try{
                map = null;
                map = new HashMap<>();
                User user = jsonObject.toJavaObject(User.class);
                //获取用户
                User user2 = userService.login(user);
                if(user2 == null){
                    map.put("msg","0");
                    map.put("error","用户名或密码错误");
                }else{
                    map.put("msg","1");
                    map.put("user",user2);
                }
            }catch (Exception e){
                map.put("msg","0");
                map.put("error","用户名或密码错误");
                return map;
            }
            return map;
        }

    /**
     * 上传头像
     * @param file
     * @param username
     * @return
     */
        @ResponseBody
        @RequestMapping(value = "/upload",method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
        public Map<String,Object> upload(MultipartFile file, String username){
           try {
               map = null;
               map = new HashMap<>();

               if(file != null){
                   String path2 = UploadFile.store(file);
                   //保存数据库
                   User user = new User();
                   user.setUsername(username);
                   user.setHead(path2);
                   int i = userService.addHead(user);
                   if(i==0){
                       map.put("msg","保存出错");
                       return map;
                   }
                   map.put("msg","保存成功");
               }
           }catch (Exception e){
               map.put("msg","保存失败");
               return map;
           }
            return map;
        }


    /**
     * 用户修改资料
     */
    @ResponseBody
    @RequestMapping(value = "/edit",method = {RequestMethod.POST})
    public Map<String,Object> edit(@RequestBody JSONObject jsonObject){
        try {
            map = null;
            map = new HashMap<>();
            User user = jsonObject.toJavaObject(User.class);
            int result = userService.edit(user);
            if(result == 0){
                map.put("msg","0");//返回0 没储存成功
            }else{
                map.put("msg","1");//返回1 储存成功
            }
        }catch (Exception e){
            //抛出异常
            map.put("msg","修改失败");
            e.printStackTrace();
            return map;
        }
        return map;
    }

}
