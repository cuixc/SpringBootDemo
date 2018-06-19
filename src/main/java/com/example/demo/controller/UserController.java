package com.example.demo.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.demo.DTO.ProductCategoryDto;
import com.example.demo.DTO.UserVo;
import com.example.demo.entity.User;
import com.example.demo.manger.ProductCategoryMng;
import com.example.demo.redis.RedisService;
import com.example.demo.service.UserService;

import io.swagger.annotations.ApiOperation;


@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);// 日志文件
	@Autowired
	private UserService userService;
	@Autowired
    private RedisService redisService;
	@Autowired
	private ProductCategoryMng productCategoryMng;
	@ApiOperation(value="保存用户")
	@RequestMapping(value = "save.do",method=RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> insert(UserVo userVo) {
		log.info("------------save.do-----------");
		log.info(userVo.toString());
		Map<String, Object> map = new HashMap<>();
		User user = new User();
		BeanUtils.copyProperties(userVo,user);
		log.info(user.toString());
		boolean result = userService.insert(user);
		map.put("添加结果", result);
		redisService.set("usersave"+user.getId(), user);
		return ResponseEntity.ok(map);
	}
	@RequestMapping(value = "findAll.do",method=RequestMethod.POST)
	@ResponseBody
	public List<User> findAll() {
		return userService.findAll();
	}
	@RequestMapping(value = "findRedis.do",method=RequestMethod.POST)
	@ResponseBody
	public List<User> findRedis() {
		return (List<User>) redisService.get("usersave");
	}
	
	@RequestMapping(value = "findByUser.do",method=RequestMethod.POST)
	@ResponseBody
	public List<User> findByUser(UserVo userVo) {
		User user = new User();
		BeanUtils.copyProperties(userVo, user);
		return userService.selectList(new EntityWrapper<User>(user));
	}
	@ApiOperation(value="分页查询用户")
	@RequestMapping(value = "pageFind.do",method=RequestMethod.POST)
	public Object pageFind(Page page) {
		log.info("=============pageFind.do===============");
		return userService.selectPage(page);
	}
	@RequestMapping("login.do")
	public List<Map<String, Object>> login(){
		
		return null;
	}
	@RequestMapping("welcome.do")
	public String welcome(Model model){
		log.info("=======welcome.do==========");
		List<ProductCategoryDto> productCategoryDtos = productCategoryMng.find(new ProductCategoryDto());
		User user = new User();
		user.setName("张三");
		model.addAttribute("productCategoryDtos", productCategoryDtos);
		model.addAttribute("currentUser", user);
		log.info(productCategoryDtos.size()+"");
		return "welcome";
	}
}
