package com.bushangbuxia.open.response;

import com.bushangbuxia.open.domain.BaseDO;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 *	@author kalman03
 *	@since	2019-09-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TaobaoItemCouponResponse extends Response{
    private TaobaoItemCouponDO data;
    
    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class TaobaoItemCouponDO extends BaseDO {

    	/** 商品id */
    	private long itemId;
    	/** 商品标题 */
    	private String title;
    	/** 商品当前价格，单位：元 */
    	private String currentPrice;
    	/** 优惠券金额，单位：元 */
    	private String couponPrice;
    	/** 券后价，单位：元 */
    	private String afterCouponPrice;
    	/** 销量 */
    	private long biz30Day;
    	/** 商品推广地址，如：https://s.click.taobao.com/t?e=m... */
    	private String clickUrl;
    	/** 领券推广地址，如：https://uland.taobao.com/coupon/edetail?e=QodyuE36... */
    	private String ulandUrl;
    	/** 商品主图地址 */
    	private String pictUrl;
    	/** 卖家类型（也可以理解为商品类型），0：淘宝，1：天猫 */
    	private int userType;// 0
    }
}
