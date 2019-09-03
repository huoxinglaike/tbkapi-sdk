package com.bushangbuxia.open.request;

import java.util.HashMap;
import java.util.Map;

import com.bushangbuxia.open.response.TaobaoItemListResponse;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *  淘宝客商品搜索
 * @author kalman03
 * @since 2019-09-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TaobaoItemListRequest extends Request<TaobaoItemListResponse> {

	/** 搜索关键字，和参数categoryId不能同时为空 */
	private String q;
	/**
	 * 联盟推广pid
	 */
	private String pid;
	/** 搜索的价格区间，可选，格式如：23~90，表示价格在23到90元之间 */
	private String price;
	/** 类目id，和参数q不能同时为空 */
	private Long categoryId;
	/** 排序方式，可选，1：综合排序，2：按销量降序， 3：按价格升序，4：按价格降序。默认为1 */
	private int sort = 1;
	/** 是否只返回天猫商品，可选，默认为false */
	private boolean tmall = false;
	/** 页码，可选，不传默认为1 */
	private int pageNum = 1;

	@Override
	public String getApi() {
		return "/openapi/item/list";
	}

	@Override
	public Class<TaobaoItemListResponse> getResponseClass() {
		return TaobaoItemListResponse.class;
	}

	@Override
	public Map<String, String> getParams() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("q", q);
		map.put("pid", pid);
		map.put("price", price);
		map.put("categoryId", categoryId == null ? null : categoryId + "");
		map.put("sort", sort + "");
		map.put("tmall", tmall + "");
		map.put("pageNum", pageNum + "");
		return map;
	}
}
