/**   
 * 
 * @Title: SaveDateSourceReqVO.java 
 * @Prject: dsplat-service
 * @Package: com.dsplat.vo.reqVO 
 * @author: Lmz
 * @date: 2018年1月4日 下午1:52:45 
 * @version: V1.0   
 */
package com.dsplat.vo.reqVO;
/** 
 * 保存数据源请求类
 * @ClassName: SaveDateSourceReqVO 
 * @author: Lmz
 * @date: 2018年1月4日 下午1:52:45  
 */
public class SaveDateSourceReqVO extends BaseReqVO{
	private static final long serialVersionUID = -3174440575613995930L;
	 /**数据源主键*/
    private String dataSoureceKey;
    /**初始大小*/
    private Integer intialSize;
    /**最大活跃数*/
    private Integer maxActive;
    /**最大idle*/
    private Integer maxIdle;
    /**数据源类型*/
    private String dataSourceType;
    /**数据源链接*/
    private String connectUrl;
    /**数据库登录用户名*/
    private String userName;
    /**数据库密码*/
    private String passWord;
	/**  
	 * 获取数据源主键  
	 * @return dataSoureceKey 数据源主键  
	 */
	public String getDataSoureceKey() {
		return dataSoureceKey;
	}
	/**  
	 * 设置数据源主键  
	 * @param dataSoureceKey 数据源主键
	 */
	public void setDataSoureceKey(String dataSoureceKey) {
		this.dataSoureceKey = dataSoureceKey;
	}
	/**  
	 * 获取初始大小  
	 * @return intialSize 初始大小  
	 */
	public Integer getIntialSize() {
		return intialSize;
	}
	/**  
	 * 设置初始大小  
	 * @param intialSize 初始大小
	 */
	public void setIntialSize(Integer intialSize) {
		this.intialSize = intialSize;
	}
	/**  
	 * 获取最大活跃数  
	 * @return maxActive 最大活跃数  
	 */
	public Integer getMaxActive() {
		return maxActive;
	}
	/**  
	 * 设置最大活跃数  
	 * @param maxActive 最大活跃数
	 */
	public void setMaxActive(Integer maxActive) {
		this.maxActive = maxActive;
	}
	/**  
	 * 获取最大idle  
	 * @return maxIdle 最大idle  
	 */
	public Integer getMaxIdle() {
		return maxIdle;
	}
	/**  
	 * 设置最大idle  
	 * @param maxIdle 最大idle
	 */
	public void setMaxIdle(Integer maxIdle) {
		this.maxIdle = maxIdle;
	}
	/**  
	 * 获取数据源链接  
	 * @return connectUrl 数据源链接  
	 */
	public String getConnectUrl() {
		return connectUrl;
	}
	/**  
	 * 设置数据源链接  
	 * @param connectUrl 数据源链接
	 */
	public void setConnectUrl(String connectUrl) {
		this.connectUrl = connectUrl;
	}
	/**  
	 * 获取数据库登录用户名  
	 * @return userName 数据库登录用户名  
	 */
	public String getUserName() {
		return userName;
	}
	/**  
	 * 设置数据库登录用户名  
	 * @param userName 数据库登录用户名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**  
	 * 获取数据库密码  
	 * @return passWord 数据库密码  
	 */
	public String getPassWord() {
		return passWord;
	}
	/**  
	 * 设置数据库密码  
	 * @param passWord 数据库密码
	 */
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	/**  
	 * 获取数据源类型  
	 * @return dataSourceType 数据源类型  
	 */
	public String getDataSourceType() {
		return dataSourceType;
	}
	/**  
	 * 设置数据源类型  
	 * @param dataSourceType 数据源类型
	 */
	public void setDataSourceType(String dataSourceType) {
		this.dataSourceType = dataSourceType;
	}
}
