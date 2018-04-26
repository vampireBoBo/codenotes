package com.future.controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.future.dao.ISystemMessageMapper;
import com.future.entity.SystemMessage;


/**
 * 
 * CopyRright (c)2007-2013: 西安未来国际信息股份有限公司<br>
 * Project:未来国际springMVC+Spring+Mybatis框架<br>                                  
 * Class Type:抽象类<br>
 * Comments:描述内容<br>
 * 	不同业务的消息实体的处理类 ，业务目前有：服务申请、服务目录等业务的流程审批信息的Controller
 * JDK version:1.8<br>
 * Namespace:com.future<br>
 * extends：<br>
 * implements：<br>
 *--------------------------------------------------------------<br>
 * V1.0 创建  Administrator 2018年4月13日  新项目<br>
 *--------------------------------------------------------------<br>
 */

@SuppressWarnings("all")
@Controller
@RequestMapping("/systemMessage")
public class SystemMessageController {
	@Autowired
	private ISystemMessageMapper sysMessage;   //业务消息接口类
	/**
	 * 
	 * @Description: 方法说明
	 * 根据指定参数获取systemMessage的业务消息内容 目前查询参数为：消息接受者ID（当前登录用户ID）  消息状态
	 * @param maps
	 * @return
	 * @author
	 *
	 */
	@RequestMapping(value="/newsInfo/",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	@ResponseBody 
	public String getHotNews(@RequestBody Map<String, Object> maps){
		List<SystemMessage> lists=new ArrayList<SystemMessage>();
		lists=sysMessage.selectByParameter(maps);
		JSON json=(JSON) JSON.toJSON(lists);
		return json.toString();
	}
	
}
