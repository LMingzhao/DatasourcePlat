/**   
 * 
 * @Title: CommonController.java 
 * @Prject: cloud-web
 * @Package: com.cloud.web.controller 
 * @author: Lmz
 * @date: 2017年12月5日 下午3:25:45 
 * @version: V1.0   
 */
package com.dsplat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
 * 公共模块
 * @ClassName: CommonController 
 * @author: Lmz
 * @date: 2017年12月5日 下午3:25:45  
 */
@Controller
public class CommonController {
	
	@RequestMapping("/")
	public String getIndex(){
		return "index.html";
	}
	
}
