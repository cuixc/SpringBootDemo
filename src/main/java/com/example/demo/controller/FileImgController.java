package com.example.demo.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.util.FileUtils;
import com.example.demo.util.R;

import io.swagger.annotations.ApiOperation;

@RestController
@ResponseBody
@RequestMapping("/FileImgController")
public class FileImgController {
	
	private String imgPath = "img/";
	private static final Logger log = LoggerFactory.getLogger(FileImgController.class);
	//处理文件上传
	@ApiOperation(value="处理图片上传")
    @RequestMapping(value="/uploadimg.do", method = RequestMethod.POST)
    public R uploadImg(@RequestParam("file") MultipartFile file,
            HttpServletRequest request) {
		log.info("=============uploadimg.do================");
        String contentType = file.getContentType();
        log.info("");
        if(StringUtils.endsWithAny(contentType, "image/jpg", "image/gif", "image/jpeg", "image/png")) {
        	Date date = new Date();
        	String fileName = date.getTime()+"_"+file.getOriginalFilename();
            log.info("fileName:"+fileName);
             
            String dateStr = DateFormatUtils.format(date, "yyyyMMdd");
           
            String filePath = request.getSession().getServletContext().getRealPath(imgPath)+dateStr;
            //String filePath = request.getContextPath()+imgPath+dateStr;
            log.info("filePath:"+filePath);
            try {
                FileUtils.uploadFile(file.getBytes(),filePath, fileName);
                R r = new R();
                r.put("imgurl", "/"+imgPath+dateStr+"/"+fileName);
                return r;
            } catch (Exception e) {
                 log.error(e.toString());
                 return R.error();
            }
        }
       
        //返回json
        return R.error();
    }
}
