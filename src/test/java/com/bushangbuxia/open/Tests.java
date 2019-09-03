package com.bushangbuxia.open;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.bushangbuxia.open.request.TaobaoItemCouponRequest;
import com.bushangbuxia.open.request.TaobaoUrlShortRequest;
import com.bushangbuxia.open.response.TaobaoItemCouponResponse;
import com.bushangbuxia.open.response.TaobaoUrlShortResponse;


/**
 * @since 2018年7月5日
 * @author kalman03
 */
public class Tests {

	private final static String appKey = "328522874379964416";
	private final static String appSecret = "rxLvOfOnlBeVrQB1mWjSYWQbgWwCAKJ2";
	private final static String gatewayUrl = "https://www.mapprouter.com";
	
	private TbkApiClient newClient(){
		return new DefaultTbkApiClient(appKey, appSecret, gatewayUrl);
	}
	
	@Test
	public void test_查询商品优惠券() throws Exception{
		TbkApiClient client = newClient();
		TaobaoItemCouponRequest request = new TaobaoItemCouponRequest();
		request.setItemId(524783419295L);
		request.setPid("mm_11_11_11");
		TaobaoItemCouponResponse response = client.execute(request);
		System.out.println(JSON.toJSONString(response));
		assertTrue(response.isSuccess());
	}
	
	@Test
	public void test_淘宝短链接生成() throws Exception{
		TbkApiClient client = newClient();
		TaobaoUrlShortRequest request = new TaobaoUrlShortRequest();
		List<String> links = new ArrayList<>();
		links.add("http://uland.taobao.com/coupon/edetail?e=AQTTaULonQIGQASttHIRqTeXI7TCP8ezP42S%2B2gJpNSOOynoqP64GQZZPjQf2WJCa2VBWt3bo6E6wS8Q2PLcHHytQvVqu4pPDfqEFBOhTcw3ZOK1F0TXFRnK99riR9aLGWqNBzv719M%3D&mt=1&ptl=bucket:_TL-68268;engpvid:100_11.139.227.168_76677_6451567504084075641");
		links.add("https://uland.taobao.com/coupon/edetail?e=9IfwzmHKF5oGQASttHIRqR1LVdnjvoqygUOwTQ4SDd2EdvD4wwM%2BY%2Fi3hzRJTBR32C%2Bz%2F4R16SJq2bVGJOHrLjduK%2FqL12MVDfqEFBOhTcw3ZOK1F0TXFRnK99riR9aLGWqNBzv719M%3D&mt=1&ptl=bucket:_TL-68268;engpvid:100_11.139.227.168_76677_6451567504084075641");
		request.setLinks(links);
		TaobaoUrlShortResponse response = client.execute(request);
		System.out.println(JSON.toJSONString(response));
		assertTrue(response.isSuccess());
	}
}
