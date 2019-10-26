package com.service.impl;


import com.pojo.News;
import com.service.UpLoadService;
import org.apache.commons.fileupload.FileItem;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

@Service
public class UpLoadServiceImpl  implements UpLoadService {
    @Override
    public News newsUpload(News news, MultipartFile imgPic) {
        /*
        *   图片上传
        * */
        //获取当前图片名的文件名
        String oldName = imgPic.getOriginalFilename();
        //判断名字是否为空
        if(oldName!=null&&!"".equals(oldName)){
           //随机分配一个16位名字
            String newName = UUID.randomUUID().toString()+oldName.substring(oldName.lastIndexOf("."));
            //指定图片存放的路径
            File file = new File("D:/img/"+newName);
            try {
                imgPic.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            news.setPic("../img/"+newName);
        }

        return news;
    }
}
