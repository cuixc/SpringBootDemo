package com.example.demo.controller;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.SellerInfoDto;
import com.example.demo.util.ErrorEnum;
import com.example.demo.util.R;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/login")
public class LoginController {	
	private static final Logger log = Logger.getLogger(LoginController.class);
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	@ApiOperation(value="用户登入验证")
	public R authLogin(SellerInfoDto seller) {
		log.info("============authLogin============");
		UsernamePasswordToken token = new UsernamePasswordToken(seller.getUsername(), seller.getPassword());
		try {
			SecurityUtils.getSubject().login(token);
            return R.ok();
        } catch (AuthenticationException e) {
           return R.error(ErrorEnum.E_202.getErrorCode(), ErrorEnum.E_202.getErrorMsg());
        }
	}
	@RequestMapping(value = "/logout.do",method=RequestMethod.POST)
	@ApiOperation(value="用户注销")
	public R logout() {
		 try {
            SecurityUtils.getSubject().logout();
            return R.ok();
	     } catch (Exception e) {
	    	return R.error(ErrorEnum.E_20012.getErrorCode(), ErrorEnum.E_20012.getErrorMsg());
	     }
	}
}
