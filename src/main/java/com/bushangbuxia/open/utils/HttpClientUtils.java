package com.bushangbuxia.open.utils;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * @since 2018年7月5日
 * @author kalman03
 */
public class HttpClientUtils {

	/**
	 * 发送 POST请求
	 */
	public static String post(String url, Map<String, String> params, String charset, int connectTimeout,
			int socketTimeout) {
		if (url == null || url.length() <= 0)
			return null;

		RequestConfig config = RequestConfig.custom().setConnectTimeout(connectTimeout).setSocketTimeout(socketTimeout)
				.build();
		try {
			Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
					.register("http", PlainConnectionSocketFactory.INSTANCE)
					.register("https", new SSLConnectionSocketFactory(createIgnoreVerifySSL())).build();
			CloseableHttpClient httpclient = HttpClientBuilder.create().setSSLContext(createIgnoreVerifySSL())
					.setConnectionManager(new PoolingHttpClientConnectionManager(socketFactoryRegistry))
					.setDefaultRequestConfig(config).build();

			HttpPost httpPost = new HttpPost(url);
			if (params != null && !params.isEmpty()) {
				List<NameValuePair> pairs = new ArrayList<NameValuePair>(params.size());
				for (Map.Entry<String, String> entry : params.entrySet()) {
					String value = entry.getValue();
					if (value != null) {
						pairs.add(new BasicNameValuePair(entry.getKey(), value));
					}
				}
				httpPost.setEntity(new UrlEncodedFormEntity(pairs, charset));
			}
			CloseableHttpResponse response = httpclient.execute(httpPost);
			// 执行get请求.
			try {
				int statusCode = response.getStatusLine().getStatusCode();
				if (statusCode != 200) {
					httpPost.abort();
					return null;
				}
				HttpEntity entity = response.getEntity();
				String rs = EntityUtils.toString(entity, charset);
				EntityUtils.consume(entity);
				return rs;
			} finally {
				response.close();
				try {
					httpclient.close();
				} catch (IOException e) {
					// ignore
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static SSLContext createIgnoreVerifySSL() throws NoSuchAlgorithmException, KeyManagementException {
		SSLContext sc = SSLContext.getInstance("SSLv3");
		// 实现一个X509TrustManager接口，用于绕过验证，不用修改里面的方法
		X509TrustManager trustManager = new X509TrustManager() {
			@Override
			public void checkClientTrusted(java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
					String paramString) throws CertificateException {
			}

			@Override
			public void checkServerTrusted(java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
					String paramString) throws CertificateException {
			}

			@Override
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}
		};

		sc.init(null, new TrustManager[] { trustManager }, null);
		return sc;
	}
}