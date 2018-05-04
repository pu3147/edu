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
        // ����HttpClientBuilder  
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();  
        // HttpClient  
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();  
        HttpPost httpPost = new HttpPost(url);  
                //  ��������ʹ��䳬ʱʱ��  
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
                // ��ӡ��Ӧ����  
                retStr = EntityUtils.toString(httpEntity, "UTF-8");  
            }  
            
            System.out.println(retStr);
            // �ͷ���Դ  
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
				"            <!--Optional: ������ --> " +
				"            <extend1>58.000</extend1> " +
				"            <!--Optional: ���ƺ�--> " +
				"            <extend2>��Q12301</extend2> " +
				"            <!--Optional:--> " +
				"            <extend3></extend3> " +
				"            <!--Optional:--> " +
				"            <extend4></extend4> " +
				"            <!--Optional: ���֤��--> " +
				"            <extend5>650121199207011727</extend5> " +
				"            <!--Optional:--> " +
				"            <billCode></billCode> " +
				"            <!--Optional: �ᵥ����״̬ " +
				"            		5��Ƥ��׼�� " +
				"            		6����Ƥ�� " +
				"            		8��ë��׼�� " +
				"            		9����ë�� " +
				"            		10���ѽ��� " +
				"            		12��������(����󣬻���ֱ������) " +
				"            <command>8</command> " +
				"            <!--Optional:--> " +
				"            <commandDesc>�ذ���Ա��������</commandDesc> " +
				"            <!--Optional:--> " +
				"            <commandTime>20180207085200</commandTime> " +
				"            <!--Optional:--> " +
				"            <extend6>��Q12301</extend6> " +
				"            <!--Optional: SAP��������--> " +
				"            <externalBillCode>2000003262</externalBillCode> " +
				"            <!-- ʵ���� --> " +
				"            <realBillWeight>1</realBillWeight> " +
				"            <!-- Ƥ�� --> " +
				"            <weight1>2</weight1> " +
				"            <!-- ë�� --> " +
				"            <weight2>1</weight2> " +
				"            <!-- �۰���--> " +
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
