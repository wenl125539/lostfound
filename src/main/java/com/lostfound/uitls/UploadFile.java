package com.lostfound.uitls;

import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

public class UploadFile {

    /**
     * 保存文件 成功返回 文件名 反之 保存失败
     * @param file
     * @return
     */
    public static String store(MultipartFile file) {
       String path2 = null;
            //将文件转换为字节
        byte[] bytes = new byte[0];
        try {
            bytes = file.getBytes();

        //获取项目根目录
            String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
            //根据时间给文件命名
            path2 = UUID.randomUUID()+".jpg";
            //创建文件
            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(new File(path+"static/img/"+path2)));
            //将字节写进文件中
            stream.write(bytes);
            stream.close();
        } catch (IOException e) {
            return "保存失败";
        }
        return path2;
    }
}
