/**   
 * 
 * @Title: StatementBuilderFactory.java 
 * @Prject: springboot-dao
 * @Package: com.bimoom.springboot.utils 
 * @author: Lmz
 * @date: 2017年12月13日 上午11:52:33 
 * @version: V1.0   
 */
package com.dsplat.utils;

import com.dsplat.entity.TableEntity;

/** 
 * 查询语句创建工厂
 * @ClassName: StatementBuilderFactory 
 * @author: Lmz
 * @date: 2017年12月13日 上午11:52:33  
 */
public interface StatementBuilderFactory {

	public String create(TableEntity tableEntity) throws Exception ;
}
