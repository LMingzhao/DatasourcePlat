package com.dsplat.utils;

import com.dsplat.entity.TableEntity;

/** 
 *
 * @ClassName: SelectCreator 
 * @author: Lmz
 * @date: 2017年12月13日 上午11:56:16  
 */
public class SelectBuilder extends BaseCreator implements StatementBuilderFactory {

	public String create(TableEntity tableEntity) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(SELECT);
		buffer.append(ALL);
		buffer.append(FROM);
		buffer.append(tableEntity.getName());
		return null;
	}

}
