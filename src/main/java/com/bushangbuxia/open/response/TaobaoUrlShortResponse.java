package com.bushangbuxia.open.response;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *	@author kalman03
 *	@since	2019-09-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TaobaoUrlShortResponse extends Response {

	private TaobaoUrlShortDO data;
	
	@Data
	public class TaobaoUrlShortDO {
		/**
		 * 转换后的短连接
		 */
		private List<String> links;
	}

}
