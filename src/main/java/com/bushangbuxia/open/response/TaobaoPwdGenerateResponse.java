package com.bushangbuxia.open.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *	@author kalman03
 *	@since	2019-09-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TaobaoPwdGenerateResponse extends Response {

	private TaobaoPwdGenerateDO data;
	
	@Data
	public class TaobaoPwdGenerateDO {
		private String password;
	}

}
