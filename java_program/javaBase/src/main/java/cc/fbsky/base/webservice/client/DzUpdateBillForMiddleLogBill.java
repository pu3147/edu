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

public class DzUpdateBillForMiddleLogBill {
	
	public static void main(String[] args) {
		
		String billWight = null;
		String carId = null;
		String idCard = null;
		String commandTime = "20180207085200";
		String sapBillCode = null;
		String piZhong = null;
		String maoZhong = null;
		String zheBai = null;
		String realZhong = null;
		
		billWight = "";carId = "";idCard = "";sapBillCode = "";piZhong = "";maoZhong = "";zheBai = "";realZhong = "";
		
		String info =dz_10(billWight, carId, idCard, commandTime, sapBillCode, piZhong, maoZhong, zheBai, realZhong);
		
		System.out.println(info);
		send("http://123.56.21.37:8080/webservice/newMiddleServerService", info);
		
		
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
	
	
	private static String dz_10(String billWight,String carId,String idCard,String commandTime,String sapBillCode,
			String piZhong, String maoZhong, String zheBai, String realZhong) {
		String str = "";
		str = str
				+ " <soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:chem=\"http://www.chemcn.com/\">                      ";
		str = str + "    <soapenv:Header/>                      ";
		str = str + "    <soapenv:Body>                      ";
		str = str + "       <chem:updateBillForMiddle>                      ";
		str = str + "          <!--Optional:-->                      ";
		str = str + "         <arg0>                      ";
		str = str + "             <!--Optional: ������ -->                      ";
		str = str + "             <extend1>" + billWight + "</extend1>                      ";
		str = str + "             <!--Optional: ���ƺ�-->                      ";
		str = str + "             <extend2>" + carId + "</extend2>                      ";
		str = str + "             <!--Optional:-->                      ";
		str = str + "             <extend3></extend3>                      ";
		str = str + "             <!--Optional:-->                      ";
		str = str + "             <extend4></extend4>                      ";
		str = str + "             <!--Optional: ���֤��-->                      ";
		str = str + "             <extend5>" + idCard + "</extend5>                      ";
		str = str + "             <!--Optional:-->                      ";
		str = str + "             <billCode></billCode>                      ";
		str = str + "             <!--                      ";
		str = str + "             		5��Ƥ��׼��                      ";
		str = str + "             		6����Ƥ��                      ";
		str = str + "             		8��ë��׼��                      ";
		str = str + "             		9����ë��                      ";
		str = str + "             		10���ѽ���                      ";
		str = str + "             		12��������(����󣬻���ֱ������)                      ";
		str = str + "             		16���ճ�����            		                      ";
		str = str + "             -->                      ";
		str = str + "             <command>10</command>                      ";
		str = str + "             <!--Optional:-->                      ";
		str = str + "             <commandDesc>��̨ά��</commandDesc>                      ";
		str = str + "             <!--Optional:-->                      ";
		str = str + "             <commandTime>" + commandTime + "</commandTime>                      ";
		str = str + "             <!--Optional:-->                      ";
		str = str + "             <extend6>" + carId + "</extend6>                      ";
		str = str + "             <!--Optional: SAP��������-->                      ";
		str = str + "             <externalBillCode>2000003269</externalBillCode>                      ";
		str = str + "             <!-- ʵ���� -->                      ";
		str = str + "             <realBillWeight>" + realZhong + "</realBillWeight>                      ";
		str = str + "             <!-- Ƥ�� -->                      ";
		str = str + "             <weight1>" + piZhong + "</weight1>                      ";
		str = str + "             <!-- ë�� -->                      ";
		str = str + "             <weight2>" + maoZhong + "</weight2>                      ";
		str = str + "             <!-- �۰���-->                      ";
		str = str + "             <weight3>" + zheBai + "</weight3>                      ";
		str = str + "          </arg0>                      ";
		str = str + "                                ";
		str = str + "       </chem:updateBillForMiddle>                      ";
		str = str + "    </soapenv:Body>                      ";
		str = str + " </soapenv:Envelope>                      ";

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
