package com.lostfound.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lostfound.pojo.User;
import com.lostfound.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserController {

        @Autowired
        private UserService userService;
        private Map<String,Object> map = null;

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

        @ResponseBody
        @RequestMapping(value = "/login",method = {RequestMethod.POST})
        public Map<String,Object> login(@RequestBody JSONObject jsonObject){
            map = null;
            map = new HashMap<>();
            User user = jsonObject.toJavaObject(User.class);
            //获取用户
            User user2 = userService.login(user);
            if(user2 == null){
                map.put("msg","用户名或密码错误");
            }else{
                map.put("user",user2);
            }
            return map;
        }

        @ResponseBody
        @RequestMapping(value = "/upload/{username}",method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
        public Map<String,Object> upload(MultipartFile file, @PathVariable String username){
           try {
               map = null;
               map = new HashMap<>();
               if(file != null){
                   //将文件转换为字节
                   byte[] bytes = file.getBytes();
                   //获取项目根目录
                   String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
                   //根据时间给文件命名
                   String path2 = new Date().getTime()+".jpg";
                   //创建文件
                   BufferedOutputStream stream = new BufferedOutputStream(
                           new FileOutputStream(new File(path+"static/img/"+path2)));
                   //将字节写进文件中
                   stream.write(bytes);
                   stream.close();

                   //保存数据库
                   User user = new User();
                   user.setUsername(username);
                   user.setHead(path2);
                   int i = userService.addHead(user);
                   if(i==0){
                       map.put("msg","保存出错");
                       return map;
                   }
                   System.out.println("图片上传完毕，存储地址为："+path+"static/img/"+path2);
                   map.put("msg","保存成功");
               }
           }catch (Exception e){
               map.put("msg","保存失败");
               return map;
           }
            return map;
        }

}
