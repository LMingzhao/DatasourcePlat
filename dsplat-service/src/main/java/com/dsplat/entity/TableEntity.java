/**   
 * 
 * @Title: TableEntity.java 
 * @Prject: springboot-dao
 * @Package: com.bimoom.springboot.dao.entity 
 * @author: Lmz
 * @date: 2017年12月13日 下午2:44:50 
 * @version: V1.0   
 */
package com.dsplat.entity;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;
/** 
 * 表实体
 * @ClassName: TableEntity 
 * @author: Lmz
 * @date: 2017年12月13日 下午2:44:50  
 */
public class TableEntity {
	/**表名*/
	private String name;
	/**引擎*/
	private String engine;
	/**字符集*/
	private String charSet;
	/**注释*/
	private String comment;
	/**列*/
	private List<ColumnEntity> columns;
	/**键*/
	private List<KeyEntity> keys;
	
	
	public void addColum(ColumnEntity columnEntity){
		if(CollectionUtils.isEmpty(this.columns)){
			this.setColumns(new ArrayList<ColumnEntity>());
		}
		this.columns.add(columnEntity);
	}
	public void addKey(KeyEntity keyEntity){
		if(CollectionUtils.isEmpty(this.keys)){
			this.setKeys(new ArrayList<KeyEntity>());
		}
		this.keys.add(keyEntity);
	}
	/**  
	 * 获取表名  
	 * @return name 表名  
	 */
	public String getName() {
		return name;
	}
	/**  
	 * 设置表名  
	 * @param name 表名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**  
	 * 获取引擎  
	 * @return engine 引擎  
	 */
	public String getEngine() {
		return engine;
	}
	/**  
	 * 设置引擎  
	 * @param engine 引擎
	 */
	public void setEngine(String engine) {
		this.engine = engine;
	}
	/**  
	 * 获取字符集  
	 * @return charSet 字符集  
	 */
	public String getCharSet() {
		return charSet;
	}
	/**  
	 * 设置字符集  
	 * @param charSet 字符集
	 */
	public void setCharSet(String charSet) {
		this.charSet = charSet;
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
	/**  
	 * 获取列  
	 * @return columns 列  
	 */
	public List<ColumnEntity> getColumns() {
		return columns;
	}
	/**  
	 * 设置列  
	 * @param columns 列
	 */
	public void setColumns(List<ColumnEntity> columns) {
		this.columns = columns;
	}
	/**  
	 * 获取键  
	 * @return keys 键  
	 */
	public List<KeyEntity> getKeys() {
		return keys;
	}
	/**  
	 * 设置键  
	 * @param keys 键
	 */
	public void setKeys(List<KeyEntity> keys) {
		this.keys = keys;
	}
}
