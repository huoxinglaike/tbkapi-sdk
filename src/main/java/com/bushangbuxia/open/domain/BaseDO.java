package com.bushangbuxia.open.domain;

import com.alibaba.fastjson.JSON;
/**
 *	@author kalman03
 *	@since	2019-09-03
 */
public class BaseDO {
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
