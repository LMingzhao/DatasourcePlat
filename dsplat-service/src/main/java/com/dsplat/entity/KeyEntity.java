/**   
 * 
 * @Title: KeyEntity.java 
 * @Prject: dsplat-dao
 * @Package: com.dsplat.entity 
 * @author: Lmz
 * @date: 2017年12月15日 上午10:41:23 
 * @version: V1.0   
 */
package com.dsplat.entity;
/** 
 * 键实体
 * @ClassName: KeyEntity 
 * @author: Lmz
 * @date: 2017年12月15日 上午10:41:23  
 */
public class KeyEntity {
	/**索引名称*/
	private String keyName;
	/**键所属列*/
	private String column;
	/**键类型*/
	private String type;
	/**关联表*/
	private String referenceTable;
	/**关联表列*/
	private String referenceTableColumn;
	/**  
	 * 获取索引名称  
	 * @return keyName 索引名称  
	 */
	public String getKeyName() {
		return keyName;
	}
	/**  
	 * 设置索引名称  
	 * @param keyName 索引名称
	 */
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
	/**  
	 * 获取键所属列  
	 * @return column 键所属列  
	 */
	public String getColumn() {
		return column;
	}
	/**  
	 * 设置键所属列  
	 * @param column 键所属列
	 */
	public void setColumn(String column) {
		this.column = column;
	}
	/**  
	 * 获取键类型  
	 * @return type 键类型  
	 */
	public String getType() {
		return type;
	}
	/**  
	 * 设置键类型  
	 * @param type 键类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**  
	 * 获取关联表  
	 * @return referenceTable 关联表  
	 */
	public String getReferenceTable() {
		return referenceTable;
	}
	/**  
	 * 设置关联表  
	 * @param referenceTable 关联表
	 */
	public void setReferenceTable(String referenceTable) {
		this.referenceTable = referenceTable;
	}
	/**  
	 * 获取关联表列  
	 * @return referenceTableColumn 关联表列  
	 */
	public String getReferenceTableColumn() {
		return referenceTableColumn;
	}
	/**  
	 * 设置关联表列  
	 * @param referenceTableColumn 关联表列
	 */
	public void setReferenceTableColumn(String referenceTableColumn) {
		this.referenceTableColumn = referenceTableColumn;
	}
}
