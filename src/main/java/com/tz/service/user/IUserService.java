/**
 * tzdesk系统平台
 * moonvip_admin
 * com.tz.dao.user
 * IUserMapper.java
 * 创建人:xuchengfei 
 * 时间：2015年11月24日-上午12:40:28 
 * 2015潭州教育公司-版权所有
 */
package com.tz.service.user;

import com.tz.bean.AdminUser;
import com.tz.bean.TzParams;

import java.util.List;

/**
 * 
 * IUserMapper
 * 创建人:wq
 * 时间：2017年9月20日-下午11:05:21
 * @version 1.0.0
 * 
 */
public interface IUserService {

	/**
	 * 根据账号和密码实现登陆
	 * com.tz.dao.user 
	 * 方法名：getLogin
	 * 创建人:wq
	 * 时间：2017年9月20日-下午11:05:21
	 * @param params
	 * @return 
	 * 返回类型：User
	 * @exception 
	 * @since  1.0.0
	 */
	public AdminUser getLogin(TzParams params);
	
	public int saveBatch(List<AdminUser> adminUsers);
	public int batchUpdate(List<AdminUser> adminUsers);
	
}
