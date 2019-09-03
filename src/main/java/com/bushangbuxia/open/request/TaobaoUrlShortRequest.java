package com.bushangbuxia.open.request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bushangbuxia.open.response.TaobaoUrlShortResponse;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author kalman03
 * @since 2019-09-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TaobaoUrlShortRequest extends Request<TaobaoUrlShortResponse> {
	/**
	 * 只支持uland.taobao.com，s.click.taobao.com， ai.taobao.com，temai.taobao.com的域名转换，否则报错
	 */
	private List<String> links;

	@Override
	public String getApi() {
		return "/api/tburl/short";
	}

	@Override
	public Class<TaobaoUrlShortResponse> getResponseClass() {
		return TaobaoUrlShortResponse.class;
	}

	@Override
	public Map<String, String> getParams() {
		Map<String, String> map = new HashMap<>();
		map.put("links",arrayToString(links));
		return map;
	}

	private String arrayToString(List<String> links) {
		if(links == null || links.isEmpty()) {
			return null;
		}
		StringBuilder builder = new StringBuilder();
		for(String link : links) {
			builder.append(link).append(",");
		}
		String temp = builder.toString();
		return temp.substring(0,temp.length()-1);
	}
}
