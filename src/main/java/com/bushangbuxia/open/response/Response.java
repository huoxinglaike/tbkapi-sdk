package com.bushangbuxia.open.response;

import lombok.Data;

import com.alibaba.fastjson.JSON;

/**
 * @since 2018年7月5日
 * @author kalman03
 */
@Data
public class Response{

	private int code;
	private String message;
	private boolean success;
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
