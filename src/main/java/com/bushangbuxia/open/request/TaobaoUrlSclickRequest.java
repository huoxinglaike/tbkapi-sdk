package com.bushangbuxia.open.request;

import java.util.HashMap;
import java.util.Map;

import com.bushangbuxia.open.response.TaobaoUrlSclickResponse;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author kalman03
 * @since 2019-09-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TaobaoUrlSclickRequest extends Request<TaobaoUrlSclickResponse> {
	/**https://s.click.taobao.com/**下的链接*/
	private String clickUrl;

	@Override
	public String getApi() {
		return "/openapi/tburl/sclick";
	}

	@Override
	public Class<TaobaoUrlSclickResponse> getResponseClass() {
		return TaobaoUrlSclickResponse.class;
	}

	@Override
	public Map<String, String> getParams() {
		Map<String, String> map = new HashMap<>();
		map.put("clickUrl", clickUrl);
		return map;
	}

}
