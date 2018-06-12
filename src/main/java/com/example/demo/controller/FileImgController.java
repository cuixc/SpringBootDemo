package com.example.demo.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.util.FileUtils;

import io.swagger.annotations.ApiOperation;

@RestController
@ResponseBody
@RequestMapping("/FileImgController")
public class FileImgController {
	
	private String imgPath = "/img";
	private static final Logger log = Logger.getLogger(FileImgController.class);
	//处理文件上传
	@ApiOperation(value="处理图片上传")
    @RequestMapping(value="/uploadimg.do", method = RequestMethod.POST)
    public String uploadImg(@RequestParam("file") MultipartFile file,
            HttpServletRequest request) {
		log.info("=============uploadimg.do================");
        String contentType = file.getContentType();
        log.info("");
        if(StringUtils.endsWithAny(contentType, "image/jpg", "image/gif", "image/jpeg", "image/png")) {
        	 String fileName = "/"+file.getOriginalFilename();
             log.info(fileName);
             Date date = new Date();
             String dateStr = DateFormatUtils.format(date, "yyyyMMdd");
             //String filePath = request.getSession().getServletContext().getRealPath("imgupload/");
             String filePath = request.getContextPath();
             System.out.println(filePath);
             try {
                 FileUtils.uploadFile(file.getBytes(), imgPath+dateStr, fileName);
             } catch (Exception e) {
                 // TODO: handle exception
             }
        }
       
        //返回json
        return "uploadimg success";
    }
}
