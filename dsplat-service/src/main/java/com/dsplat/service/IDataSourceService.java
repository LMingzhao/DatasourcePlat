/**   
 * 
 * @Title: IDataSourceService.java 
 * @Prject: dsplat-service
 * @Package: com.dsplat.service 
 * @author: Lmz
 * @date: 2018年1月4日 下午1:51:02 
 * @version: V1.0   
 */
package com.dsplat.service;

import com.dsplat.vo.reqVO.SaveDateSourceReqVO;

/** 
 * 数据源服务接口
 * @ClassName: IDataSourceService 
 * @author: Lmz
 * @date: 2018年1月4日 下午1:51:02  
 */
public interface IDataSourceService {

	/**
	 * 保存数据源
	 * @author Lmz
	 * @Title: saveDateSource 
	 * @param reqVO
	 * @throws Exception
	 * @return: void
	 */
	public void saveDateSource(SaveDateSourceReqVO reqVO) throws Exception;
}
