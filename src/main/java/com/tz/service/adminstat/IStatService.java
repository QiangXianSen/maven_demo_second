/**
 * kekeblog系统平台
 * moonvip_admin
 * com.tz.dao.adminstat
 * IAdminStatMapper.java
 * 创建人:柯柯 
 * 时间：2015年11月28日-下午10:47:13 
 * 2015潭州教育公司-版权所有
 */
package com.tz.service.adminstat;

import com.tz.bean.TzParams;

import java.util.HashMap;
import java.util.List;

/**
 * echat
 * IStatMapper
 * 创建人:wq
 * 时间：2017年9月20日 00:54:40
 * @version 1.0.0
 *
 */
public interface IStatService {

	/**
	 * 获取统计表所需数据
	 * @param tzParams
	 * @return
	 */
	public List<HashMap<String, Object>> groupContent(TzParams tzParams);
}
