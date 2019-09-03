package com.bushangbuxia.open.request;

import java.util.HashMap;
import java.util.Map;

import com.bushangbuxia.open.response.TaobaoItemCouponResponse;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *  优惠券商品查询
 * @author kalman03
 * @since 2019-09-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TaobaoItemCouponRequest extends Request<TaobaoItemCouponResponse> {

	/** 商品id */
	private long itemId;
	/** 联盟推广PID */
	private String pid;

	@Override
	public String getApi() {
		return "/api/item/coupon";
	}

	@Override
	public Class<TaobaoItemCouponResponse> getResponseClass() {
		return TaobaoItemCouponResponse.class;
	}

	@Override
	public Map<String, String> getParams() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("itemId", itemId + "");
		map.put("pid", pid);
		return map;
	}
}
