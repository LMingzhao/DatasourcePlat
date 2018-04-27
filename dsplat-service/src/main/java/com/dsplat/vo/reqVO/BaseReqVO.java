/**   
 * 
 * @Title: BaseReqVO.java 
 * @Prject: dsplat-service
 * @Package: com.dsplat.vo.reqVO 
 * @author: Lmz
 * @date: 2018年1月4日 下午1:53:18 
 * @version: V1.0   
 */
package com.dsplat.vo.reqVO;

import java.io.Serializable;

/** 
 * 基础请求类
 * @ClassName: BaseReqVO 
 * @author: Lmz
 * @date: 2018年1月4日 下午1:53:18  
 */
public class BaseReqVO implements Serializable{
	private static final long serialVersionUID = 4409012095052272840L;
	/**交易日期*/
	private String transDate;
	/**当前用户*/
	private String currentUser;
	/**  
	 * 获取交易日期  
	 * @return transDate 交易日期  
	 */
	public String getTransDate() {
		return transDate;
	}
	/**  
	 * 设置交易日期  
	 * @param transDate 交易日期
	 */
	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}
	/**  
	 * 获取当前用户  
	 * @return currentUser 当前用户  
	 */
	public String getCurrentUser() {
		return currentUser;
	}
	/**  
	 * 设置当前用户  
	 * @param currentUser 当前用户
	 */
	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}
}
