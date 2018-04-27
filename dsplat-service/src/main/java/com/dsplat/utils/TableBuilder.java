package com.dsplat.utils;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import com.dsplat.entity.ColumnEntity;
import com.dsplat.entity.KeyEntity;
import com.dsplat.entity.TableEntity;
import com.dsplat.enums.COLUMN_KEY_TYPE;
import com.dsplat.enums.EXTRA_TYPE;
import com.dsplat.enums.PARENT_COLUMN_TYPE;

/** 
 *
 * @ClassName: TableBuilder 
 * @author: Lmz
 * @date: 2017年12月13日 下午2:11:38  
 */
public class TableBuilder extends BaseCreator implements StatementBuilderFactory {

	public String create(TableEntity tableEntity) throws Exception {
		List<ColumnEntity> columns = tableEntity.getColumns();
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(CREATE_TABLE);
		stringBuffer.append(tableEntity.getName());
		stringBuffer.append(ACCENT+SPACE+LEFT_BRACKET);
		boolean exitAutoIncrement = false;
		for (Iterator<ColumnEntity> iterator = columns.iterator(); iterator.hasNext();) {
			ColumnEntity columnEntity = iterator.next();
			boolean isAutoIncrement = columnCreate(columnEntity,stringBuffer);
			if(!exitAutoIncrement){
				exitAutoIncrement = isAutoIncrement;
			}
		}
		if(CollectionUtils.isEmpty(tableEntity.getKeys())){
			if(exitAutoIncrement){
				throw new Exception("自增长字段必须设置索引");
			}
		}else{
			List<KeyEntity> keys = tableEntity.getKeys();
			for (Iterator<KeyEntity> iterator = keys.iterator(); iterator.hasNext();) {
				KeyEntity keyEntity = iterator.next();
				keyCreate(keyEntity, stringBuffer);
			}
		}
		int lastIndexOf = stringBuffer.toString().lastIndexOf(",");
		stringBuffer.replace(lastIndexOf, lastIndexOf+1, " ");
		stringBuffer.append(RIGHT_BRACKET+ENGINE+DEFAULT+CHARSET+UTF8+COMMENT);
		stringBuffer.append(SINGLE_QUOTES);
		stringBuffer.append(tableEntity.getComment());
		stringBuffer.append(SINGLE_QUOTES);
		stringBuffer.append(SEMICOLON);
		return stringBuffer.toString();
	}
	
	public boolean columnCreate(ColumnEntity columnEntity,StringBuffer stringBuffer){
		boolean isStringType = columnEntity.getParentType().equals(PARENT_COLUMN_TYPE.STRING.getCode());
		boolean isNumberType = columnEntity.getParentType().equals(PARENT_COLUMN_TYPE.NUMBER.getCode());
		boolean isDateType = columnEntity.getParentType().equals(PARENT_COLUMN_TYPE.DATE.getCode());
		String extraType = columnEntity.getExtraType();
		boolean isAutoIncrement = EXTRA_TYPE.AUTO_INCREMENT.getCode().equals(extraType);
		stringBuffer.append(ACCENT);
		stringBuffer.append(columnEntity.getName());
		stringBuffer.append(ACCENT+SPACE);
		stringBuffer.append(columnEntity.getType());
		stringBuffer.append(SPACE);
		if(!isDateType){
			stringBuffer.append(LEFT_BRACKET);
			stringBuffer.append(columnEntity.getLength());
			stringBuffer.append(RIGHT_BRACKET);
		}
		if(!columnEntity.isNullable()){
			stringBuffer.append(NOT+NULL);
		}
		if(StringUtils.isNotBlank(columnEntity.getDefaultValue()) && !isAutoIncrement){
			stringBuffer.append(DEFAULT);
			if(isStringType){
				stringBuffer.append(SINGLE_QUOTES);
			}
			if(isDateType){
				stringBuffer.append(CURRENT_TIMESTAMP);
			}else{
				stringBuffer.append(columnEntity.getDefaultValue());
			}
			if(isStringType){
				stringBuffer.append(SINGLE_QUOTES);
			}
			stringBuffer.append(SPACE);
		}
		if(StringUtils.isNotBlank(extraType)){
			if(isNumberType && isAutoIncrement){
				stringBuffer.append(AUTO_INCREMENT);
			}
			if(isDateType && EXTRA_TYPE.ON_UPDATE_CURRENT_TIMESTAMP.getCode().equals(extraType)){
				stringBuffer.append(ON_UPDATE_CURRENT_TIMESTAMP);
			}
		}
		if(StringUtils.isNotBlank(columnEntity.getComment())){
			stringBuffer.append(COMMENT+SINGLE_QUOTES);
			stringBuffer.append(columnEntity.getComment());
			stringBuffer.append(SINGLE_QUOTES);
		}
		stringBuffer.append(COMMA);
		return isAutoIncrement;
	}
	
	class ColumnCreateResult {
		String statement;
		boolean isAutoIncrement;
	}

	public void keyCreate(KeyEntity keyEntity,StringBuffer stringBuffer){
		String keyType = keyEntity.getType();
		if(COLUMN_KEY_TYPE.PRIMARY.getCode().equals(keyType)){
			stringBuffer.append(PRIMARY);
		}
		if(COLUMN_KEY_TYPE.FOREIGN.getCode().equals(keyType)){
			stringBuffer.append(FOREIGN);
		}
		stringBuffer.append(KEY);
		if(COLUMN_KEY_TYPE.KEY.getCode().equals(keyType)){
			stringBuffer.append(ACCENT);
			stringBuffer.append(keyEntity.getKeyName());
			stringBuffer.append(ACCENT+SPACE);
		}
		stringBuffer.append(LEFT_BRACKET+ACCENT);
		stringBuffer.append(keyEntity.getColumn());
		stringBuffer.append(ACCENT+RIGHT_BRACKET);
		if(COLUMN_KEY_TYPE.FOREIGN.getCode().equals(keyType)){
			stringBuffer.append(REFERENCES+ACCENT);
			stringBuffer.append(keyEntity.getReferenceTable());
			stringBuffer.append(ACCENT+SPACE+LEFT_BRACKET+ACCENT);
			stringBuffer.append(keyEntity.getReferenceTableColumn());
			stringBuffer.append(ACCENT+RIGHT_BRACKET);
		}
		stringBuffer.append(COMMA);
	}
	
	

	public static void main(String[] args) throws Exception {
		StatementBuilderFactory factory = new TableBuilder();
		ColumnEntity idColumn = new ColumnEntity();
		idColumn.setName("id");
		idColumn.setType("int");
		idColumn.setLength("11");
		idColumn.setParentType(PARENT_COLUMN_TYPE.NUMBER.getCode());
		idColumn.setNullable(false);
		idColumn.setDefaultValue("1");
		idColumn.setComment("主键");
		idColumn.setExtraType(EXTRA_TYPE.AUTO_INCREMENT.getCode());
		
		ColumnEntity stringColumn = new ColumnEntity();
		stringColumn.setName("name");
		stringColumn.setType("varchar");
		stringColumn.setLength("100");
		stringColumn.setParentType(PARENT_COLUMN_TYPE.STRING.getCode());
		stringColumn.setNullable(true);
		stringColumn.setDefaultValue("name");
		stringColumn.setComment("名称");
		
		ColumnEntity dateColumn = new ColumnEntity();
		dateColumn.setName("insert_time");
		dateColumn.setType("timestamp");
		dateColumn.setParentType(PARENT_COLUMN_TYPE.DATE.getCode());
		dateColumn.setNullable(false);
		dateColumn.setDefaultValue("CURRENT_TIMESTAMP");
		dateColumn.setComment("插入时间");
		
		KeyEntity primarykeyEntity = new KeyEntity();
		primarykeyEntity.setColumn("id");
		primarykeyEntity.setKeyName("key_id_1");
		primarykeyEntity.setReferenceTable("dic");
		primarykeyEntity.setReferenceTableColumn("id");
		primarykeyEntity.setType(COLUMN_KEY_TYPE.FOREIGN.getCode());
		
		TableEntity tableEntity = new TableEntity();
		tableEntity.setComment("测试表");
		tableEntity.setName("test_table");
		tableEntity.addColum(idColumn);
		tableEntity.addColum(stringColumn);
		tableEntity.addColum(dateColumn);
		tableEntity.addKey(primarykeyEntity);
		String columnCreate = factory.create(tableEntity);
		System.out.println(columnCreate);
	}
}
