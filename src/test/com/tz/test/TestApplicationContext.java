/**
 * tzdesk系统平台
 * springmvc2
 * com.tz.test
 * TestApplicationContext.java
 * 创建人:xuchengfei 
 * 时间：2015年11月18日-上午11:35:24 
 * 2015潭州教育公司-版权所有
 */
package com.tz.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.tz.dao.adminstat.IStatMapper;
import com.tz.service.adminstat.IStatService;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tz.bean.Content;
import com.tz.bean.TzParams;
import com.tz.bean.AdminUser;
import com.tz.service.content.IContentService;
import com.tz.service.user.IUserService;
import com.tz.util.TmStringUtils;

/**
 * 
 * TestApplicationContext
 * 创建人:xuchengfei 
 * 时间：2015年11月18日-上午11:35:24 
 * @version 1.0.0
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class TestApplicationContext {
	
	@Autowired
	IUserService  userService;
	
	@Autowired
	private IContentService contentService;

	@Autowired
	private IStatService statService;
	
	
	@Test
	public void handler() throws JSONException{
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
//		DruidDataSource dataSource = context.getBean(DruidDataSource.class);
//		System.out.println("============"+dataSource);
//		IUserMapper mapper = context.getBean(IUserMapper.class);
//		System.out.println(mapper);
		TzParams params = new TzParams();
		params.setAccount("keke");
		params.setPassword("4QrcOUm6Wau+VuBX8g+IPg==");
		AdminUser user = userService.getLogin(params);
		System.out.println("============="+user.getUsername());
	}
	
	

	@Test
	public void handler2() throws JSONException{
		TzParams params = new TzParams();
		List<Content> contents = contentService.findContents(params);
		for (Content content : contents) {
			System.out.println("=======>"+content.getTitle());
		}
	}
	
	
	@Test
	public void handler3() throws JSONException{
		List<AdminUser> adminUsers = new ArrayList<AdminUser>();
		AdminUser adminUser = new AdminUser();
		//keke
		adminUser.setUsername("keke");
		adminUser.setPassword(TmStringUtils.md5Base64("keke_keke"));
		adminUsers.add(adminUser);
		
		//小明
		adminUser = new AdminUser();
		adminUser.setUsername("小明");
		adminUser.setPassword(TmStringUtils.md5Base64("keke"));
		adminUsers.add(adminUser);
		
		int count = userService.saveBatch(adminUsers);
//		int count = userService.batchUpdate(adminUsers);
		System.out.println("==============>"+count);
	}
	
	
	@Test
	public void handler5(){
		Content content = new Content();
		content.setId(50);
//		content.setStatus(1);
		content.setIsDelete(0);
		int count = contentService.update(content);
		System.out.println("=============>"+count);
	}

	@Test
	public void handler6() throws JSONException{
		TzParams tzParams = new TzParams();
		tzParams.setYear(2015);
		List<HashMap<String, Object>> hashMaps = statService.groupContent(tzParams);
		String serialize = JSONUtil.serialize(hashMaps);
		System.out.println("=============>"+serialize);
	}
}
