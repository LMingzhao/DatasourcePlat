/**   
 * 
 * @Title: ColumnEntity.java 
 * @Prject: springboot-dao
 * @Package: com.bimoom.springboot.dao.entity 
 * @author: Lmz
 * @date: 2017年12月13日 下午2:44:35 
 * @version: V1.0   
 */
package com.dsplat.entity;
/** 
 * 列实体
 * @ClassName: ColumnEntity 
 * @author: Lmz
 * @date: 2017年12月13日 下午2:44:35  
 */
public class ColumnEntity {
	/**列名*/
	private String name;
	/**列类型*/
	private String type;
	/**列父类型*/
	private String parentType;
	/**额外配置类型*/
	private String extraType;
	/**列数据长度*/
	private String length;
	/**默认值*/
	private String defaultValue;
	/**是否可空*/
	private boolean nullable;
	/**键类型*/
	private String keyType;
	/**注释*/
	private String comment;
	/**  
	 * 获取列名  
	 * @return name 列名  
	 */
	public String getName() {
		return name;
	}
	/**  
	 * 设置列名  
	 * @param name 列名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**  
	 * 获取列类型  
	 * @return type 列类型  
	 */
	public String getType() {
		return type;
	}
	/**  
	 * 设置列类型  
	 * @param type 列类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**  
	 * 获取列父类型  
	 * @return parentType 列父类型  
	 */
	public String getParentType() {
		return parentType;
	}
	/**  
	 * 设置列父类型  
	 * @param parentType 列父类型
	 */
	public void setParentType(String parentType) {
		this.parentType = parentType;
	}
	/**  
	 * 获取额外配置类型  
	 * @return extarType 额外配置类型  
	 */
	public String getExtraType() {
		return extraType;
	}
	/**  
	 * 设置额外配置类型  
	 * @param extarType 额外配置类型
	 */
	public void setExtraType(String extraType) {
		this.extraType = extraType;
	}
	/**  
	 * 获取列数据长度  
	 * @return length 列数据长度  
	 */
	public String getLength() {
		return length;
	}
	/**  
	 * 设置列数据长度  
	 * @param length 列数据长度
	 */
	public void setLength(String length) {
		this.length = length;
	}
	/**  
	 * 获取默认值  
	 * @return defaultValue 默认值  
	 */
	public String getDefaultValue() {
		return defaultValue;
	}
	/**  
	 * 设置默认值  
	 * @param defaultValue 默认值
	 */
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	/**  
	 * 获取是否可空  
	 * @return nullable 是否可空  
	 */
	public boolean isNullable() {
		return nullable;
	}
	/**  
	 * 设置是否可空  
	 * @param nullable 是否可空
	 */
	public void setNullable(boolean nullable) {
		this.nullable = nullable;
	}
	/**  
	 * 获取键类型  
	 * @return keyType 键类型  
	 */
	public String getKeyType() {
		return keyType;
	}
	/**  
	 * 设置键类型  
	 * @param keyType 键类型
	 */
	public void setKeyType(String keyType) {
		this.keyType = keyType;
	}
	/**  
	 * 获取注释  
	 * @return comment 注释  
	 */
	public String getComment() {
		return comment;
	}
	/**  
	 * 设置注释  
	 * @param comment 注释
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
}
