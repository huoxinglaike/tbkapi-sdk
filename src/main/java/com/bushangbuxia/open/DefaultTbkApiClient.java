package com.bushangbuxia.open;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.commons.codec.digest.DigestUtils;

import com.alibaba.fastjson.JSON;
import com.bushangbuxia.open.exception.ApiException;
import com.bushangbuxia.open.request.Request;
import com.bushangbuxia.open.response.Response;
import com.bushangbuxia.open.utils.HttpClientUtils;

/**
 *	@author kalman03
 *	@since	2019-09-03
 */
public class DefaultTbkApiClient implements TbkApiClient {

	private final String appkey;
	private final String appsecret;
	private final String gatewayUrl;
	
	private int connectTimeout;
	private int socketTimeout;

	public DefaultTbkApiClient(String appkey, String appsecret, String gatewayUrl) {
		this(appkey, appsecret, gatewayUrl, 3000, 8000);
	}

	public DefaultTbkApiClient(String appkey, String appsecret, String gatewayUrl, int connectTimeout,
			int socketTimeout) {
		this.appkey = appkey;
		this.appsecret = appsecret;
		this.gatewayUrl = gatewayUrl;
		this.connectTimeout = connectTimeout;
		this.socketTimeout = socketTimeout;
	}

	@Override
	public <T extends Response> T execute(Request<T> request)throws ApiException {
		try {
			String url = gatewayUrl+request.getApi();
			Map<String, String> params = request.getParams();
			params.put("t", System.currentTimeMillis()/1000+"");
			params.put("appkey", appkey);

			String sign = getSign(params);
			params.put("sign", sign);

			String res = HttpClientUtils.post(url, params, "utf-8", connectTimeout, socketTimeout);
			if(res != null && !res.equals("")){
				return JSON.parseObject(res, request.getResponseClass());
			}
			throw new ApiException("response null when request remote.");
		} catch (Exception e) {
			throw new ApiException(e);
		}
	}

	private String getSign(Map<String, String> params) {
		Map<String, String> treeMap = new TreeMap<String, String>();
		treeMap.putAll(params);
		String temp = "";
		for (Entry<String, String> entry : treeMap.entrySet()) {
			if(entry.getValue() != null){
				temp += (entry.getKey() + entry.getValue());
			}
		}
		temp = appsecret+temp;
		return DigestUtils.md5Hex(temp);
	}
}
