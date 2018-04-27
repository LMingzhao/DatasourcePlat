package com.dsplat.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dsplat.constants.URLConstants;
import com.dsplat.service.IDataSourceService;
import com.dsplat.vo.reqVO.SaveDateSourceReqVO;

/** 
 * 数据源模块
 * @ClassName: UserController 
 * @author: Lmz
 * @date: 2017年12月5日 下午3:25:45  
 */
@RestController
@RequestMapping(URLConstants.MODULE_DATA_SOURCE)
public class DataSourceController {
	
private static final Logger logger = Logger.getLogger(UserController.class); 
	
	@Autowired
	private IDataSourceService iDataSourceService;

	@RequestMapping(value = URLConstants.DATA_SOURCE_SAVE_DATA_SOURCE,method = RequestMethod.POST)
	public void saveDataSourceHandler(@RequestBody SaveDateSourceReqVO reqVO){
		try {
			this.iDataSourceService.saveDateSource(reqVO);
		} catch (Exception e) {
			logger.error("请求失败",e);
		}
	}
	
}
