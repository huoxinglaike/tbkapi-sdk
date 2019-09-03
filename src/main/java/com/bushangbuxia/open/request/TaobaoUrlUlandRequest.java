package com.bushangbuxia.open.request;

import java.util.HashMap;
import java.util.Map;

import com.bushangbuxia.open.response.TaobaoUrlUlandResponse;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author kalman03
 * @since 2019-09-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TaobaoUrlUlandRequest extends Request<TaobaoUrlUlandResponse> {
	/**
	 * 优惠券推广地址
	 */
	private String ulandUrl;

	@Override
	public String getApi() {
		return "/openapi/tburl/uland";
	}

	@Override
	public Class<TaobaoUrlUlandResponse> getResponseClass() {
		return TaobaoUrlUlandResponse.class;
	}

	@Override
	public Map<String, String> getParams() {
		Map<String, String> map = new HashMap<>();
		map.put("ulandUrl", ulandUrl);
		return map;
	}

}
