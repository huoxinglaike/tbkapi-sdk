package com.bushangbuxia.open.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *	@author kalman03
 *	@since	2019-09-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TaobaoPwdResolvingResponse extends Response {

	private TaobaoPwdResolvingDO data;
	
	@Data
	public class TaobaoPwdResolvingDO {
		/**淘口令标题*/
		private String title;
		/**淘口令跳转链接*/
		private String url;
		/**淘口令图片地址*/
		private String pictUrl;
		/**有效期*/
		private String validDate;
	}

}
