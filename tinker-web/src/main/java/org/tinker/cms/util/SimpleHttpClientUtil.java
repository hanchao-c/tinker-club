package org.tinker.cms.util;

import static com.google.common.base.Preconditions.checkState;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.util.CollectionUtils;
import org.tinker.util.Propagater;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

/**
 * 
 */
public class SimpleHttpClientUtil {

	private static final RequestConfig DEFAULT_REQUEST_CONFIG = RequestConfig.custom()  
            .setSocketTimeout(30000)
            .setConnectTimeout(30000)
            .setConnectionRequestTimeout(30000)
            .build();
	
	public static String post(String url, Map<String, String> data) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		List<NameValuePair> nameValuePairs = toNameValuePairs(data);
		HttpPost httpPost = new HttpPost(url);
		if(!CollectionUtils.isEmpty(nameValuePairs)){
			httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, StandardCharsets.UTF_8));
		}
		httpPost.setConfig(DEFAULT_REQUEST_CONFIG);
		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httpPost);
			int statusCode = response.getStatusLine().getStatusCode();
			checkState(Objects.equal(statusCode, HttpStatus.SC_OK), "Status code is [ %s ] not 200", statusCode);
			HttpEntity entity = response.getEntity();
			String result = EntityUtils.toString(entity, StandardCharsets.UTF_8);
			EntityUtils.consume(entity);
			return result;
		} catch (Exception e) {
			throw Propagater.interrupt(e);
		}finally {
			HttpClientUtils.closeQuietly(httpclient);
			HttpClientUtils.closeQuietly(response);
		}
		
	}
	
	/**
	 * 
	 * @param map
	 * @return
	 */
	private static List<NameValuePair> toNameValuePairs(Map<String, String> map){
		List<NameValuePair> pairs = Lists.newArrayList();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			String name = StringUtils.trimToNull(entry.getKey());
			if(StringUtils.isEmpty(name)){
				continue;
			}
			String value = StringUtils.trimToEmpty(entry.getValue());
			pairs.add(new BasicNameValuePair(name,value));
		} 
		return pairs;
	}
	
	
}
