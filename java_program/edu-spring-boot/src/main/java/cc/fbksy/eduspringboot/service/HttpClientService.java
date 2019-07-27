package cc.fbksy.eduspringboot.service;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HttpClientService {

    @Autowired
    private CloseableHttpClient httpClient;

    @Autowired
    private RequestConfig config;

    /**
     * 带参数的get请求，如果状态码为200，则返回body，如果不为200，则返回null
     *
     * @param url
     * @return
     * @throws Exception
     */
    public String sendWeChat(String url,String reqBody) throws Exception {

        HttpPost postReq = new HttpPost(url);
        postReq.setConfig(config);
        StringEntity reqEntity = new StringEntity(reqBody,"UTF-8");
        postReq.setEntity(reqEntity);

        System.out.println("url=" +url+ "\nreqBody="+reqBody);

        CloseableHttpResponse response = this.httpClient.execute(postReq);

        return EntityUtils.toString(response.getEntity(),"UTF-8");
    }

}
