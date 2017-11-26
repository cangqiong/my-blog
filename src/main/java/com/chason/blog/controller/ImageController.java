package com.chason.blog.controller;

import com.chason.blog.exception.ImageUploadException;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 图片相关控制器
 *
 * @author cang
 * @date 2017-10-07
 */
@RestController
@RequestMapping( "/image" )
public class ImageController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Value( "${web.image.path}" )
    private String uploadPath;

    @RequestMapping( value = "/upload", method = RequestMethod.POST )
    public ImageUploadResult setCookie(@NotNull @RequestParam( "image" ) MultipartFile image, HttpServletResponse response, HttpServletRequest request) {

        ImageUploadResult result = new ImageUploadResult();
        //可以从页面传参数过来
        try {
            validateImage(image);

        } catch (ImageUploadException e) {
            e.printStackTrace();
            result.setSuccess(0);
            result.setMessage(e.getMessage());
        }

        String newName = saveImage(image);
        result.setSuccess(0);
        result.setUrl(uploadPath + "/" + newName);

        return result;
    }

//    @RequestMapping( value = "/preview/{image}", method = RequestMethod.GET )
//    public ResultBean<String> setCookie(@PathVariable("image") String image) throws ImageUploadException {
//
//        //可以从页面传参数过来o
//        validateImage(image);
//        String newName = saveImage(image);
//
//        ResultBean<String> result = new ResultBean();
//
//        result.setData(uploadPath+"/"+newName);
//
//        return result;
//    }

    private String saveImage(MultipartFile image) {

        //这里可以支持多文件上传
        BufferedOutputStream bw = null;
        //判断是否有文件且是否为图片文件
        //创建输出文件对象
        String newName = UUID.randomUUID().toString() + getFileType(image.getOriginalFilename());
        File outFile = new File(uploadPath + "/" + newName);
        //拷贝文件到输出文件对象
        try {
            FileUtils.copyInputStreamToFile(image.getInputStream(), outFile);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

        return newName;
    }

    private void validateImage(MultipartFile image) throws ImageUploadException {
        String fileName = image.getOriginalFilename();
        if (StringUtils.isEmpty(fileName) || !isImageFile(fileName)) {
            throw new ImageUploadException("只有图片格式允许上传");
        }
    }

    /**
     * 判断文件是否为图片文件
     *
     * @param fileName
     * @return
     */
    private Boolean isImageFile(String fileName) {
        String[] img_type = new String[]{".jpg", ".jpeg", ".png", ".gif", ".bmp"};
        if (fileName == null) {
            return false;
        }
        fileName = fileName.toLowerCase();
        for (String type : img_type) {
            if (fileName.endsWith(type)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取文件后缀名
     *
     * @param fileName
     * @return
     */
    private String getFileType(String fileName) {
        if (fileName != null && fileName.indexOf(".") >= 0) {
            return fileName.substring(fileName.lastIndexOf("."), fileName.length());
        }
        return "";
    }

    class ImageUploadResult {

        // 0 表示上传失败，1 表示上传成功
        private int success;
        //  提示的信息，上传成功或上传失败及错误信息等
        private String message;
        private String url;

        public int getSuccess() {
            return success;
        }

        public void setSuccess(int success) {
            this.success = success;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}

