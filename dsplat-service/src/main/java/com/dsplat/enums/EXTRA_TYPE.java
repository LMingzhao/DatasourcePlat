package com.dsplat.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 列额外配置类型
 * @ClassName: EXTRA_TYPE 
 * @author: Lmz
 * @date: 2017年12月15日 下午1:59:15
 */
public enum EXTRA_TYPE {

	AUTO_INCREMENT("1","自增长"),
	ON_UPDATE_CURRENT_TIMESTAMP("2","更新时自动更新为当前时间");

	private String code;
	private String desc;

	private EXTRA_TYPE(String code, String desc) {
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
		for (EXTRA_TYPE status : EnumSet.allOf(EXTRA_TYPE.class)) {
			map.put(status.getCode(), status.getDesc());
		}
	}

	public static String getDesc(String code) {
		return map.get(code);
	}
}
