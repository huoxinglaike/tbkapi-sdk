package com.bushangbuxia.open.request;

import java.util.Map;

import com.bushangbuxia.open.response.Response;
/**
 * @since 2018年7月5日
 * @author kalman03
 */
public abstract class Request<T extends Response> {
	
	public abstract String getApi();
	
	public abstract Class<T> getResponseClass();

	public abstract Map<String, String> getParams();

}