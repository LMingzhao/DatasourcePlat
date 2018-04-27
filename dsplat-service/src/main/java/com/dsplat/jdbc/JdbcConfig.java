/**   
 * 
 * @Title: JDBCConfig.java 
 * @Prject: springboot-dao
 * @Package: com.bimoom.springboot.dao.mybatis 
 * @author: Lmz
 * @date: 2017年12月11日 上午10:39:02 
 * @version: V1.0   
 */
package com.dsplat.jdbc;

/** 
 * JDBC配置model
 * @ClassName: JDBCConfig 
 * @author: Lmz
 * @date: 2017年12月11日 上午10:39:02  
 */
public class JdbcConfig {

	private static final long serialVersionUID = -1944977364797076255L;
	/**id*/
	private Integer id;
	/**初始大小*/
	private int initialSize  = 10;
	/**最大活跃数*/
	private int maxActive= 20;
	/**最大Idle*/
	private int maxIdle= 5;
	/**最大等待时间*/
	private int maxWait= 5000;
	/**驱动*/
	private String driverClass  = "com.mysql.jdbc.Driver";
	/**数据库链接url*/
	private String connectUrl;
	/**数据库登录用户名*/
	private String username;
	/**登录密码*/
	private String password;
	/***/
	private String createdTs;
	/**数据连接池 key，数据源标识 ,任意字符串但是需唯一*/
	private String dataSourceKey;
	/**  
	 * 获取id  
	 * @return id id  
	 */
	public Integer getId() {
		return id;
	}
	/**  
	 * 设置id  
	 * @param id id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**  
	 * 获取初始大小  
	 * @return initialSize 初始大小  
	 */
	public int getInitialSize() {
		return initialSize;
	}
	/**  
	 * 设置初始大小  
	 * @param initialSize 初始大小
	 */
	public void setInitialSize(int initialSize) {
		this.initialSize = initialSize;
	}
	/**  
	 * 获取最大活跃数  
	 * @return maxActive 最大活跃数  
	 */
	public int getMaxActive() {
		return maxActive;
	}
	/**  
	 * 设置最大活跃数  
	 * @param maxActive 最大活跃数
	 */
	public void setMaxActive(int maxActive) {
		this.maxActive = maxActive;
	}
	/**  
	 * 获取最大Idle  
	 * @return maxIdle 最大Idle  
	 */
	public int getMaxIdle() {
		return maxIdle;
	}
	/**  
	 * 设置最大Idle  
	 * @param maxIdle 最大Idle
	 */
	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}
	/**  
	 * 获取最大等待时间  
	 * @return maxWait 最大等待时间  
	 */
	public int getMaxWait() {
		return maxWait;
	}
	/**  
	 * 设置最大等待时间  
	 * @param maxWait 最大等待时间
	 */
	public void setMaxWait(int maxWait) {
		this.maxWait = maxWait;
	}
	/**  
	 * 获取驱动  
	 * @return driverClass 驱动  
	 */
	public String getDriverClass() {
		return driverClass;
	}
	/**  
	 * 设置驱动  
	 * @param driverClass 驱动
	 */
	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}
	/**  
	 * 获取数据库链接url  
	 * @return connectUrl 数据库链接url  
	 */
	public String getConnectUrl() {
		return connectUrl;
	}
	/**  
	 * 设置数据库链接url  
	 * @param connectUrl 数据库链接url
	 */
	public void setConnectUrl(String connectUrl) {
		this.connectUrl = connectUrl;
	}
	/**  
	 * 获取数据库登录用户名  
	 * @return username 数据库登录用户名  
	 */
	public String getUsername() {
		return username;
	}
	/**  
	 * 设置数据库登录用户名  
	 * @param username 数据库登录用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**  
	 * 获取登录密码  
	 * @return password 登录密码  
	 */
	public String getPassword() {
		return password;
	}
	/**  
	 * 设置登录密码  
	 * @param password 登录密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**  
	 * 获取  createdTs
	 * @return createdTs   
	 */
	public String getCreatedTs() {
		return createdTs;
	}
	/**  
	 * 设置  createdTs
	 * @param createdTs 
	 */
	public void setCreatedTs(String createdTs) {
		this.createdTs = createdTs;
	}
	/**  
	 * 获取数据连接池key数据  
	 * @return dataSourceKey 数据连接池key数据  
	 */
	public String getDataSourceKey() {
		return dataSourceKey;
	}
	/**  
	 * 设置数据连接池key数据  
	 * @param dataSourceKey 数据连接池key数据
	 */
	public void setDataSourceKey(String dataSourceKey) {
		this.dataSourceKey = dataSourceKey;
	}
	/**  
	 * 获取serialVersionUID  
	 * @return serialVersionUID serialVersionUID  
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
