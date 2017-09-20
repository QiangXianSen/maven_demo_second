/**
 * Copyright @ 2017北京鼎九信息工程研究院有限公司。 All rights reserved.
 *
 * @Author: wangqiang
 * @Date: 2017/9/20 18:53
 */
package com.tz.web.adminstat;

import com.tz.bean.TzParams;
import com.tz.service.adminstat.IStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * Copyright @ 2017北京鼎九信息工程研究院有限公司。 All rights reserved.
 * @Title StatController
 * @Project mavenDemo_5
 * @Description TODO
 * @Author wangqiang
 * @date 2017/9/20 18:53
 */
@Controller
@RequestMapping("/admin/stat")
public class StatController {
	@Autowired
	private IStatService statService;

	/**
	 *
	 * @param tzParams
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public List<HashMap<String ,Object>> list(TzParams tzParams){
		List<HashMap<String, Object>> datas = statService.groupContent(tzParams);
		return datas;
	}
}
