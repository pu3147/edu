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
		
		String iBillCode = "2000003273";
		String info = yq_9(iBillCode);
		System.out.println(info);
		send("http://123.56.21.37:8080/webservice/iMiddleServerService", info);
		
		info = yq_10(iBillCode);
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
	
	
	private static String dz_8() {
		
		String str = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:chem=\"http://www.chemcn.com/\"> " +
				"   <soapenv:Header/> " +
				"   <soapenv:Body> " +
				"      <chem:updateBillForMiddle> " +
				"        <arg0> " +
				"            <!--Optional: 开单量 --> " +
				"            <extend1>58.000</extend1> " +
				"            <!--Optional: 车牌号--> " +
				"            <extend2>啊Q12301</extend2> " +
				"            <!--Optional:--> " +
				"            <extend3></extend3> " +
				"            <!--Optional:--> " +
				"            <extend4></extend4> " +
				"            <!--Optional: 身份证号--> " +
				"            <extend5>650121199207011727</extend5> " +
				"            <!--Optional:--> " +
				"            <billCode></billCode> " +
				"            <!--Optional: 提单跟踪状态 " +
				"            		5：皮重准备 " +
				"            		6：过皮重 " +
				"            		8：毛重准备 " +
				"            		9：过毛重 " +
				"            		10：已结算 " +
				"            		12：已作废(超提后，换单直接作废) " +
				"            <command>8</command> " +
				"            <!--Optional:--> " +
				"            <commandDesc>地磅人员操作错误</commandDesc> " +
				"            <!--Optional:--> " +
				"            <commandTime>20180207085200</commandTime> " +
				"            <!--Optional:--> " +
				"            <extend6>啊Q12301</extend6> " +
				"            <!--Optional: SAP交货单号--> " +
				"            <externalBillCode>2000003262</externalBillCode> " +
				"            <!-- 实提量 --> " +
				"            <realBillWeight>1</realBillWeight> " +
				"            <!-- 皮重 --> " +
				"            <weight1>2</weight1> " +
				"            <!-- 毛重 --> " +
				"            <weight2>1</weight2> " +
				"            <!-- 折百量--> " +
				"            <weight3>0</weight3> " +
				"         </arg0> " +
				"          " +
				"      </chem:updateBillForMiddle> " +
				"   </soapenv:Body> " +
				"</soapenv:Envelope> " ;
				
		return str;
		
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
						" 					\"iNet\" : 1000,   " +
						" 					\"iGreenChannel\" : 0,   " +
						" 					\"iTime\" : \"2018-05-04 14:57:44\",   " +
						" 					\"iOrderType\" : 20,   " +
						" 					\"iMaterialId\" : \"\",   " +
						" 					\"iMode\" : \"0\",   " +
						" 					\"actualNet\" : 29900,   " +
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
}
