package com.bushangbuxia.open.response;

import java.util.List;

import com.bushangbuxia.open.response.TaobaoItemCouponResponse.TaobaoItemCouponDO;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *	@author kalman03
 *	@since	2019-09-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TaobaoItemCouponListResponse extends Response{

	private List<TaobaoItemCouponExtraDO> data;
	
	@Data
	@EqualsAndHashCode(callSuper = true)
	public class TaobaoItemCouponExtraDO extends TaobaoItemCouponDO{
		/**
		 * 优惠券已领取数量
		 */
		private long sendCouponCount;
		/**
		 * 总优惠券数量
		 */
		private long totalCouponCount;
	}
}
