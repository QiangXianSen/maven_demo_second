/**
 * tzdesk系统平台
 * moonvip_admin
 * com.tz.service.adminstat
 * IAdminStatService.java
 * 创建人:柯柯 
 * 时间：2015年12月05日 00:07:45
 * 2015潭州教育公司-版权所有
 */
package com.tz.service.adminstat;

import com.tz.bean.AdminStat;
import com.tz.bean.TzParams;

import java.util.List;

/**
 * 
 * IAdminStatService
 * 创建人:wq
 * 时间：2017年9月20日 00:54:40
 * @version 1.0.0
 * 
 */
public interface IAdminStatService {


	/**
	 * 
	 * com.tz.service.adminstat 
	 * 方法名：findAdminStats
	 * 创建人：柯柯 
	 * 手机号码:15074816437
	 * 时间：2015年12月05日 00:07:45
	 * @param params
	 * @return 
	 * 返回类型：List<AdminStat>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<AdminStat> findAdminStats(TzParams params);
	
	/**
	 * 求总数
	 * com.tz.dao.adminstat 
	 * 方法名：count
	 * 创建人：柯柯 
	 * 手机号码:15074816437
	 * 时间：2015年12月05日 00:07:45
	 * @param id
	 * @return 
	 * 返回类型：List<AdminStat>
	 * @exception 
	 * @since  1.0.0
	 */
	public int count(TzParams params);
	
	/**
	 * 
	 * com.tz.service.adminstat 
	 * 方法名：findAdminStats
	 * 创建人：柯柯 
	 * 手机号码:15074816437
	 * 时间：2015年12月05日 00:07:45
	 * @param params
	 * @return 
	 * 返回类型：List<AdminStat>
	 * @exception 
	 * @since  1.0.0
	 */
	public AdminStat get(Integer id);
	
	/**
	 * 保存日记管理
	 * com.tz.service.adminstat 
	 * 方法名：save
	 * 创建人：柯柯 
	 * 手机号码:15074816437
	 * 时间：2015年12月05日 00:07:45 
	 * @param adminstat
	 * @return 
	 * 返回类型：AdminStat
	 * @exception 
	 * @since  1.0.0
	 */
	public int save(AdminStat adminstat);
	
	/**
	 * 更新日记管理
	 * com.tz.service.adminstat 
	 * 方法名：update
	 * 创建人：柯柯 
	 * 手机号码:15074816437
	 * 时间：2015年12月05日 00:07:45
	 * @param adminstat
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int update(AdminStat adminstat);
	
	/**
	 * 删除日记管理
	 * com.tz.service.adminstat 
	 * 方法名：delete
	 * 创建人：柯柯 
	 * 手机号码:15074816437
	 * 时间：2015年12月05日 00:07:45
	 * @param params
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int delete(TzParams params);
}
