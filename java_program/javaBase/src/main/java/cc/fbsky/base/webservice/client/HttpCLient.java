package cc.fbsky.base.webservice.client;

import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class HttpCLient {
	
	public static void main(String[] args) {
		
		String iBillCode = "2000003365";
		String info = yq_12(iBillCode);
		System.out.println(info);
		send("http://123.56.21.37:8080/webservice/iMiddleServerService", info);
		
		
	}
	
	public static void send(String url,String soapXml) {
        String retStr = "";  
        // 创建HttpClientBuilder  
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();  
        // HttpClient  
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();  
        HttpPost httpPost = new HttpPost(url);  
                //  设置请求和传输超时时间  
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(10000).setConnectTimeout(10000).build();  
        httpPost.setConfig(requestConfig);  
        try {
        	
            httpPost.setHeader("Content-Type", "text/xml;charset=UTF-8");  
            httpPost.setHeader("SOAPAction", "");  
            StringEntity data = new StringEntity(soapXml,Charset.forName("UTF-8"));  
            httpPost.setEntity(data);  
            CloseableHttpResponse response = closeableHttpClient.execute(httpPost);  
            HttpEntity httpEntity = response.getEntity();  
            if (httpEntity != null) {  
                // 打印响应内容  
                retStr = EntityUtils.toString(httpEntity, "UTF-8");  
            }  
            
            System.out.println(retStr);
            // 释放资源  
            closeableHttpClient.close();  
        } catch (Exception e) {  
        	e.printStackTrace();
        }  
        
	}
	
	
	private static String yq_9(String iBillCode) {
		String str = 
						" <soap:Envelope   " +
						" 	xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"   " +
						" 	xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"   " +
						" 	xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">   " +
						" 	<soap:Body>   " +
						" 		<SetBillState xmlns=\"http://www.chemcn.com/\">   " +
						" 			<json xmlns=\"\">   " +
						" 				{   " +
						" 					\"iBillCode\" : \""+iBillCode+"\",   " +
						" 					\"iCommand\" : \"9\",   " +
						" 					\"iNet\" : 1000,   " +						//	结算重量,单位是千克,
						" 					\"iGreenChannel\" : 0,   " +
						" 					\"iTime\" : \"2018-05-04 14:57:44\",   " +
						" 					\"iOrderType\" : 20,   " +
						" 					\"iMaterialId\" : \"\",   " +
						" 					\"iMode\" : \"0\",   " +					//	结算方式，0-地磅结算，1-流量计结算
						" 					\"actualNet\" : 29900,   " +				//	实提重量,单位千克
						" 					\"cancelRemark\" : \"\"   " +
						" 				}			   " +
						" 			</json>   " +
						" 		</SetBillState>   " +
						" 	</soap:Body>   " +
						" </soap:Envelope>   " ;
		
		return str;
	}
	
	private static String yq_10(String iBillCode) {
		String str = 
						" <soap:Envelope   " +
						" 	xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"   " +
						" 	xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"   " +
						" 	xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">   " +
						" 	<soap:Body>   " +
						" 		<SetBillState xmlns=\"http://www.chemcn.com/\">   " +
						" 			<json xmlns=\"\">   " +
						" 			{   " +
						" 				\"iBillCode\" : \""+iBillCode+"\",   " +
						" 				\"iCommand\" : \"10\",   " +
						" 				\"iNet\" : 1000,   " +
						" 				\"iGreenChannel\" : 0,   " +
						" 				\"iTime\" : \"2018-05-04 15:06:36\",   " +
						" 				\"iOrderType\" : 20,   " +
						" 				\"iMaterialId\" : \"\",   " +
						" 				\"iMode\" : \"0\",   " +
						" 				\"actualNet\" : 1000,   " +
						" 				\"cancelRemark\" : \"\"   " +
						" 			}   " +
						" 			</json>   " +
						" 		</SetBillState>   " +
						" 	</soap:Body>   " +
						" </soap:Envelope>   ";
		
		return str;
	}
	
	private static String yq_12(String iBillCode) {
		String str = 
						" <soap:Envelope   " +
						" 	xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"   " +
						" 	xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"   " +
						" 	xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">   " +
						" 	<soap:Body>   " +
						" 		<SetBillState xmlns=\"http://www.chemcn.com/\">   " +
						" 			<json xmlns=\"\">   " +
						" 			{   " +
						" 				\"iBillCode\" : \""+iBillCode+"\",   " +
						" 				\"iCommand\" : \"12\",   " +
						" 				\"iNet\" : 1000,   " +
						" 				\"iGreenChannel\" : 0,   " +
						" 				\"iTime\" : \"2018-05-04 15:06:36\",   " +
						" 				\"iOrderType\" : 20,   " +
						" 				\"iMaterialId\" : \"\",   " +
						" 				\"iMode\" : \"0\",   " +
						" 				\"actualNet\" : 1000,   " +
						" 				\"cancelRemark\" : \"地磅作废\"   " +
						" 			}   " +
						" 			</json>   " +
						" 		</SetBillState>   " +
						" 	</soap:Body>   " +
						" </soap:Envelope>   ";
		
		return str;
	}
}
