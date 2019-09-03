package com.bushangbuxia.open.request;

import java.util.HashMap;
import java.util.Map;

import com.bushangbuxia.open.response.TaobaoItemCouponListResponse;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 优惠券商品搜索
 *	@author kalman03
 *	@since	2019-09-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TaobaoItemCouponListRequest extends Request<TaobaoItemCouponListResponse>{

	/**
	 * 搜索关键字
	 */
	private String q;
	/**
	 * 联盟推广pid
	 */
	private String pid;
	/**
	 * 页码，默认为第1页
	 */
	private int pageNum = 1;
	/**
	 * 每页返回的记录条数，默认为20，最大不超过50
	 */
	private int pageSize = 20;
	
	@Override
	public String getApi() {
		return "/openapi/item/coupon_list";
	}

	@Override
	public Class<TaobaoItemCouponListResponse> getResponseClass() {
		return TaobaoItemCouponListResponse.class;
	}

	@Override
	public Map<String, String> getParams() {
		Map<String, String> map = new HashMap<>();
		map.put("q", q);
		map.put("pid", pid);
		map.put("pageNum", pageNum+"");
		map.put("pageSize",pageSize+"");
		return map;
	}
}
