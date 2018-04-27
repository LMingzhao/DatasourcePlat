/**   
 * 
 * @Title: DataSourceImpl.java 
 * @Prject: dsplat-service
 * @Package: com.dsplat.service.impl 
 * @author: Lmz
 * @date: 2018年1月4日 下午2:05:25 
 * @version: V1.0   
 */
package com.dsplat.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.dao.dbmain.DefDataSourcePOMapper;
import com.common.dao.dbmain.mybatis.DefDataSourcePO;
import com.dsplat.enums.DATASOURCETYPE;
import com.dsplat.service.IDataSourceService;
import com.dsplat.vo.reqVO.SaveDateSourceReqVO;

/** 
 * 数据源服务接口实现类
 * @ClassName: DataSourceImpl 
 * @author: Lmz
 * @date: 2018年1月4日 下午2:05:25  
 */
@Service
public class DataSourceImpl implements IDataSourceService{
	
	private static final Logger logger = Logger.getLogger(IDataSourceService.class);
	
	@Autowired
	private DefDataSourcePOMapper defDataSourcePOMapper;

	public void saveDateSource(SaveDateSourceReqVO reqVO) throws Exception {
		logger.info("=============>进入方法");
		DefDataSourcePO dataSource = new DefDataSourcePO();
		BeanUtils.copyProperties(reqVO, dataSource);
		if(StringUtils.isBlank(dataSource.getDataSoureceKey())){
			throw new Exception("数据源主键为空");
		}
		dataSource.setDriverClass(DATASOURCETYPE.getDriverClass(reqVO.getDataSourceType()));
		this.defDataSourcePOMapper.insertSelective(dataSource);
	}

}
