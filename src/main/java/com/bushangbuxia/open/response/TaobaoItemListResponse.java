package com.bushangbuxia.open.response;

import java.util.List;

import com.bushangbuxia.open.domain.BaseDO;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *	@author kalman03
 *	@since	2019-09-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TaobaoItemListResponse extends Response{

	private List<TaobaoTbkItemDO> data;
	
	@Data
	@EqualsAndHashCode(callSuper = true)
	public static class TaobaoTbkItemDO extends BaseDO{
		/**商品id*/
		private long itemId;
		/**商品标题*/
		private String title;
		/**商品主图*/
		private String pictUrl;
		/**商品当前价格，单位:元*/
		private String currentPrice;
		/**商品优惠券金额，单位：元。*/
		private String couponPrice;
		/**减掉优惠券后的价格,单位：元*/
		private String afterCouponPrice;
		/**卖家类型，0表示淘宝，1表示天猫*/
		private int userType;
		/**商品所在地*/
		private String provcity;
		/**商品推广链接，如果有优惠券，该地址是领券地址；否则是普通的淘宝客推广地址*/
		private String clickUrl;
		/**卖家淘宝id*/
		private long sellerId;
		/**卖家昵称*/
		private String sellerNick;
		/**商品销量*/
		private long biz30day;
		/**是否包邮*/
		private boolean freeShipping;
		/**淘客推广佣金比例,500表示5%的佣金*/
		private long tkRate;
	}
}
