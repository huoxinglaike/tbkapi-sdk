package com.bushangbuxia.open.request;

import java.util.HashMap;
import java.util.Map;

import com.bushangbuxia.open.response.TaobaoPwdResolvingResponse;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 淘口令解析
 *	@author kalman03
 *	@since	2019-09-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TaobaoPwdResolvingRequest extends Request<TaobaoPwdResolvingResponse>{

	/**
	 * 含淘口令的文本
	 */
	private String content;
	
	@Override
	public String getApi() {
		return "/api/pwd/resolving";
	}

	@Override
	public Class<TaobaoPwdResolvingResponse> getResponseClass() {
		return TaobaoPwdResolvingResponse.class;
	}

	@Override
	public Map<String, String> getParams() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("content",content);
		return map;
	}

}
