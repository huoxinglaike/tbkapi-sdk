package com.bushangbuxia.open.request;

import java.util.HashMap;
import java.util.Map;

import com.bushangbuxia.open.response.TaobaoPwdGenerateResponse;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *	@author kalman03
 *	@since	2019-09-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TaobaoPwdGenerateRequest extends Request<TaobaoPwdGenerateResponse> {

	/**要生成淘口令的链接，仅支持s.click.taobao.com/uland.taobao.com域名下的链接*/
	private String url;
	/**淘口令推广语，可选*/
	private String title;
	/**淘口令打开手淘的Logo，可选*/
	private String pictUrl;
	
	@Override
	public String getApi() {
		return "/api/pwd/generate";
	}
	@Override
	public Class<TaobaoPwdGenerateResponse> getResponseClass() {
		return TaobaoPwdGenerateResponse.class;
	}
	@Override
	public Map<String, String> getParams() {
		Map<String, String> map = new HashMap<>();
		map.put("url", url);
		map.put("title", title);
		map.put("pictUrl", pictUrl);
		return map;
	}

}
