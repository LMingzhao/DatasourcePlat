/**   
 * 
 * @Title: ReqVO.java 
 * @Prject: spring-service
 * @Package: com.bimoom.springboot.vo.reqVO 
 * @author: Lmz
 * @date: 2017年12月7日 下午3:48:42 
 * @version: V1.0   
 */
package com.dsplat.vo.reqVO;
import java.io.Serializable;
/** 
 * 
 * @ClassName: ReqVO 
 * @author: Lmz
 * @date: 2017年12月7日 下午3:48:42  
 */
public class ReqVO implements Serializable{
	private static final long serialVersionUID = -6794053352098421273L;
	/**页号*/
	private Integer page;
	/**行数*/
	private Integer rows;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**  
	 * 获取页号  
	 * @return page 页号  
	 */
	public Integer getPage() {
		return page;
	}
	/**  
	 * 设置页号  
	 * @param page 页号
	 */
	public void setPage(Integer page) {
		this.page = page;
	}
	/**  
	 * 获取行数  
	 * @return rows 行数  
	 */
	public Integer getRows() {
		return rows;
	}
	/**  
	 * 设置行数  
	 * @param rows 行数
	 */
	public void setRows(Integer rows) {
		this.rows = rows;
	}
}
