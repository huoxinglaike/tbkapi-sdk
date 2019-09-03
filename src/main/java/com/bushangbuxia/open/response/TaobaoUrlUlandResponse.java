package com.bushangbuxia.open.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *	@author kalman03
 *	@since	2019-09-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TaobaoUrlUlandResponse extends Response {

	private TaobaoUrlUlandDO data;
	
	@Data
	public class TaobaoUrlUlandDO {
		/**优惠券有效期之开始时间*/
		private String effectiveStartTime;
		/**优惠券有效期之结束时间*/
		private String effectiveEndTime;
		/**优惠券面额，单位：元*/
		private String amount;
		/**私有券地址*/
		private String privateCouponUrl;
		/**运费*/
		private String startFee;
		/**couponKey*/
		private String couponKey;
		/**店铺名称*/
		private String shopName;
		/**店铺logo*/
		private String shopLogo;
		
		/**商品id*/
		private long itemId;
		/**商品标题*/
		private String title;
		/**商品图片*/
		private String pictUrl;
		/**商品销量*/
		private long biz30Day;
		/**是否天猫商品*/
		private int tmall;
		/**普通推广地址*/
		private String clickUrl;
		/**商品原价，单位：元*/
		private String reservePrice;
		/**当前价，不含去除优惠券的面额，单位：元*/
		private String discountPrice;
		/**是否包邮，1：包邮*/
		private int postFree;
		/**优惠券推广地址*/
		private String ulandUrl;
	}

}
