package com.bushangbuxia.open.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *	@author kalman03
 *	@since	2019-09-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TaobaoUrlSclickResponse extends Response {

	private TaobaoUrlSclickDO data;
	
	@Data
	public class TaobaoUrlSclickDO {
		/**商品ID*/
		private long itemId;
		/**商品图片*/
		private String pictUrl;
		/**商品标题*/
		private String title;
		/**联盟推广PID*/
		private String pid;
	}

}
