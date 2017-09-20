/**
 * tzdesk系统平台
 * moonvip_admin
 * com.tz.web.adminstat
 * AdminStatController.java
 * 创建人:柯柯
 * 时间：2015年12月05日 00:07:45
 * 2015潭州教育公司-版权所有
 */
package com.tz.web.adminstat;

import com.tz.bean.AdminStat;
import com.tz.bean.TzParams;
import com.tz.service.adminstat.IAdminStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 日记管理web
 * AdminStatController
 * 创建人:柯柯
 * 时间：2015年12月05日 00:07:45
 * @version 1.0.0
 * 
 */
@Controller
@RequestMapping("/admin/adminstat")
public class AdminStatController {
	
	@Autowired
	private IAdminStatService adminstatService;
	
	/*列表查询*/
	@RequestMapping("/list")
	public String list(TzParams params){
		return "adminstat/list";
	}
	
	/*模板页面*/
	@RequestMapping("/template")
	public ModelAndView template(TzParams params){
		ModelAndView modelAndView = new ModelAndView();
		List<AdminStat> adminstats = adminstatService.findAdminStats(params);
		int count = adminstatService.count(params);
		modelAndView.setViewName("adminstat/template");
		modelAndView.addObject("datas",adminstats);
		modelAndView.addObject("itemCount",count);
		return modelAndView;
	}
}
