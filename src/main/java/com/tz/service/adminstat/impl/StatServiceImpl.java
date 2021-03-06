/**
 * tzdesk系统平台
 * moonvip_admin
 * com.tz.service.adminstat
 * IAdminStatService.java
 * 创建人:柯柯 
 * 时间：2015年12月05日 00:07:45
 * 2015潭州教育公司-版权所有
 */
package com.tz.service.adminstat.impl;

import com.tz.bean.AdminStat;
import com.tz.bean.TzParams;
import com.tz.dao.adminstat.IAdminStatMapper;
import com.tz.dao.adminstat.IStatMapper;
import com.tz.service.adminstat.IAdminStatService;
import com.tz.service.adminstat.IStatService;
import com.tz.util.TmStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * 日记管理serviceImpl
 * IAdminStatService
 * 创建人:wq
 * 时间：2017年9月20日 00:54:40
 * @version 1.0.0
 * 
 */
@Service
public class StatServiceImpl implements IStatService{

	@Autowired
	private IStatMapper statMapper;


	@Override
	public List<HashMap<String, Object>> groupContent(TzParams tzParams) {
		return statMapper.groupContent(tzParams);
	}
}
