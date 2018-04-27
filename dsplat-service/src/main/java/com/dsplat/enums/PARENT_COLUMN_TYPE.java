package com.dsplat.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 列父类型
 *
 * @ClassName: PARENT_COLUMN_TYPE 
 * @author: Lmz
 * @date: 2017年12月14日 上午11:11:31
 */
public enum PARENT_COLUMN_TYPE {

	DATE("DATE","时间类型"),
	NUMBER("NUMBER","数字类型"),
	STRING("STRING","字符类型");

	private String code;
	private String desc;

	private PARENT_COLUMN_TYPE(String code, String desc) {
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
		for (PARENT_COLUMN_TYPE status : EnumSet.allOf(PARENT_COLUMN_TYPE.class)) {
			map.put(status.getCode(), status.getDesc());
		}
	}

	public static String getDesc(String code) {
		return map.get(code);
	}
}
