package com.dsplat.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 列键类型
 * @ClassName: COLUMN_KEY_TYPE 
 * @author: Lmz
 * @date: 2017年12月15日 下午1:55:07
 */
public enum COLUMN_KEY_TYPE {

	KEY("1","索引"),
	PRIMARY("2","主键"),
	FOREIGN("3","外键");

	private String code;
	private String desc;

	private COLUMN_KEY_TYPE(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	private static final Map<String, String> map = new HashMap<String, String>();
	static {
		for (COLUMN_KEY_TYPE status : EnumSet.allOf(COLUMN_KEY_TYPE.class)) {
			map.put(status.getCode(), status.getDesc());
		}
	}

	public static String getDesc(String code) {
		return map.get(code);
	}
}
