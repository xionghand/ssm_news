package com.service;

import com.pojo.News;
import org.apache.commons.fileupload.FileItem;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UpLoadService {
    public News newsUpload(News news, MultipartFile imgPic);
}
