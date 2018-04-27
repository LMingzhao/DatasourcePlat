/**   
 * 
 * @Title: DATASOURCETYPE.java 
 * @Prject: dsplat-service
 * @Package: com.dsplat.enums 
 * @author: Lmz
 * @date: 2018年1月4日 下午4:29:30 
 * @version: V1.0   
 */
package com.dsplat.enums;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
/** 
 * 数据源类型
 * @ClassName: DATASOURCETYPE 
 * @author: Lmz
 * @date: 2018年1月4日 下午4:29:30  
 */
public enum DATASOURCETYPE {
	MYSQL("1", "com.mysql.jdbc.Driver"),
	ORACLE("2", "oracle.jdbc.driver.OracleDriver");
	private String code;
	private String driverClass;
	private DATASOURCETYPE(String code, String driverClass) {
		this.code = code;
		this.driverClass = driverClass;
	}
	/**  
	 * 获取code  
	 * @return code code  
	 */
	public String getCode() {
		return code;
	}
	/**  
	 * 设置code  
	 * @param code code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**  
	 * 获取driverClass  
	 * @return driverClass driverClass  
	 */
	public String getDriverClass() {
		return driverClass;
	}
	/**  
	 * 设置driverClass  
	 * @param driverClass driverClass
	 */
	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}
	private static final Map<String, String> map = new HashMap<String, String>();
	static {
		for (DATASOURCETYPE status : EnumSet.allOf(DATASOURCETYPE.class)) {
			map.put(status.getCode(), status.getDriverClass());
		}
	}
	public static String getDriverClass(String code) {
		return map.get(code);
	}
}
