//package com.bushangbuxia.open;
//import static org.junit.Assert.assertTrue;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.commons.codec.digest.DigestUtils;
//import org.junit.Test;
//
//import com.alibaba.fastjson.JSON;
//import com.bushangbuxia.open.request.TaobaoItemCouponRequest;
//import com.bushangbuxia.open.request.TaobaoItemListRequest;
//import com.bushangbuxia.open.request.TaobaoUrlShortRequest;
//import com.bushangbuxia.open.response.TaobaoItemCouponResponse;
//import com.bushangbuxia.open.response.TaobaoItemListResponse;
//import com.bushangbuxia.open.response.TaobaoUrlShortResponse;
//
//
///**
// * @since 2018年7月5日
// * @author kalman03
// */
//public class Tests {
//
//	private final static String appKey = "329054170453526880";
//	private final static String appSecret = "543";
//	private final static String gatewayUrl = "http://www.mapprouter.com";
//	
//	private TbkApiClient newClient(){
//		return new DefaultTbkApiClient(appKey, appSecret, gatewayUrl);
//	}
//	
//	public static void main(String[] args) {
//		String str = "3zYmd0SdFC5Lm2qFOV87oQt46PzLO9Wlappkey329238742256717824clickUrlhttps://s.click.taobao.com/t?e=m%3D2%26s%3DqnVCjK05vg4cQipKwQzePOeEDrYVVa64qu1K02Mshg4YXcpTjhqjBbh6lveQ4QbbxF5AHBg6Tr6XpyrZPgAl9K3Qx%2BptXcSvGE9YQhqPWJlgG%2FQocWERplFkM0dlFqg1JxYWXQ9AN5Kz6PJMEPCZlvh25vt4ofW91IvxgQpWSuk8QjAEhXS1DRXPAGgsd3bPTvtvEZwfZ1JACARJowPCnhdNCrb0YQV8THSKda6%2BD90%3D&pvid=200_11.224.194.93_293_1509199881681&union_lens=lensId%3An%401567610111%400b0fa839_0e37_16cfcd80738_2a6c%4001&af=4&ut_sk=1.utdid_null_1567610133407.TaoPassword-Outside.taoketop&sp_tk=77+lTU1ESVlsaE5PV1Tvv6U=t1567720891000";
//		String data = DigestUtils.md5Hex(str);
//		System.out.println(data);
//	}
//	
//	@Test
//	public void test_查询商品优惠券1() throws Exception{
//		TbkApiClient client = newClient();
//		TaobaoItemListRequest request = new TaobaoItemListRequest();
//		request.setQ("衣服");
//		request.setPid("mm_11_11_11");
//		TaobaoItemListResponse response = client.execute(request);
//		System.out.println(JSON.toJSONString(response));
//		assertTrue(response.isSuccess());
//	}
//	
//	@Test
//	public void test_查询商品优惠券() throws Exception{
//		TbkApiClient client = newClient();
//		TaobaoItemCouponRequest request = new TaobaoItemCouponRequest();
//		request.setItemId(524783419295L);
//		request.setPid("mm_11_11_11");
//		TaobaoItemCouponResponse response = client.execute(request);
//		System.out.println(JSON.toJSONString(response));
//		assertTrue(response.isSuccess());
//	}
//	
//	@Test
//	public void test_淘宝短链接生成() throws Exception{
//		TbkApiClient client = newClient();
//		TaobaoUrlShortRequest request = new TaobaoUrlShortRequest();
//		List<String> links = new ArrayList<>();
//		links.add("http://uland.taobao.com/coupon/edetail?e=AQTTaULonQIGQASttHIRqTeXI7TCP8ezP42S%2B2gJpNSOOynoqP64GQZZPjQf2WJCa2VBWt3bo6E6wS8Q2PLcHHytQvVqu4pPDfqEFBOhTcw3ZOK1F0TXFRnK99riR9aLGWqNBzv719M%3D&mt=1&ptl=bucket:_TL-68268;engpvid:100_11.139.227.168_76677_6451567504084075641");
//		links.add("https://uland.taobao.com/coupon/edetail?e=9IfwzmHKF5oGQASttHIRqR1LVdnjvoqygUOwTQ4SDd2EdvD4wwM%2BY%2Fi3hzRJTBR32C%2Bz%2F4R16SJq2bVGJOHrLjduK%2FqL12MVDfqEFBOhTcw3ZOK1F0TXFRnK99riR9aLGWqNBzv719M%3D&mt=1&ptl=bucket:_TL-68268;engpvid:100_11.139.227.168_76677_6451567504084075641");
//		request.setLinks(links);
//		TaobaoUrlShortResponse response = client.execute(request);
//		System.out.println(JSON.toJSONString(response));
//		assertTrue(response.isSuccess());
//	}
//}
