package com.bushangbuxia.open;

import com.bushangbuxia.open.exception.ApiException;
import com.bushangbuxia.open.request.Request;
import com.bushangbuxia.open.response.Response;

/**
 *	@author kalman03
 *	@since	2019-09-03
 */
public interface TbkApiClient {

	<T extends Response> T execute(Request<T> request)throws ApiException;
}
