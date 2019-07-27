package cc.fbksy.eduspringboot.wechat;

import cc.fbksy.eduspringboot.service.HttpClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.TreeMap;

@Controller
public class WeChatPayController {

    String sellerPayKey = "";
    String appId = "";
    String mch_id = "";
    String device_info = "WEB";

    //通知地址
    String notify_url = "http://pay.fbksy.cc/notify_url";

    @Autowired
    private HttpClientService httpClientService;

    @RequestMapping("/createWeChatOrder")
    public ModelAndView  createWeChatOrder(HttpServletRequest request) throws Exception {
        ModelAndView mav = new ModelAndView();
        TreeMap<String,Object> paramMap = new TreeMap<String,Object>();

        paramMap.put("appid",appId);//公众号id
        paramMap.put("mch_id",mch_id);//微信支付分配的商户号
        paramMap.put("device_info",device_info);//自定义参数，可以为终端设备号(门店号或收银设备ID)，PC网页或公众号内支付可以传"WEB"
        paramMap.put("nonce_str","D089");//随机字符串
        paramMap.put("sign_type","MD5");//签名类型，默认为MD5，支持HMAC-SHA256和MD5。注意此处需与统一下单的签名类型一致
        paramMap.put("body","黑枸杞");//商品简单描述 String(128)
        paramMap.put("detail","黑枸杞");//商品简单描述 String(128)
        paramMap.put("attach","黑枸杞");//商品简单描述 String(128)
        paramMap.put("out_trade_no","D089");//电商订单号   商户系统内部订单号
        paramMap.put("fee_type","CNY");//标价币种
        paramMap.put("total_fee","101");//标价金额  订单总金额，单位为分
        paramMap.put("spbill_create_ip",request.getRemoteAddr());//终端IP	支持IPV4和IPV6两种格式的IP地址。用户的客户端IP
        paramMap.put("notify_url",notify_url);//异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数。
        paramMap.put("trade_type","JSAPI");//交易类型
        paramMap.put("openid","123123");//用户标识  微信用户在商户对应appid下的唯一标识

        String sign = getMd5Sign(paramMap,sellerPayKey);
        paramMap.put("sign",sign);//签名

        String reqXml = toXmlStr(paramMap);

        String info = httpClientService.sendWeChat("https://api.mch.weixin.qq.com/pay/unifiedorder",reqXml);


        mav.addAllObjects(paramMap);
        mav.addObject("info",info);

        mav.setViewName("weChat/orde");

        return mav;
    }

    @RequestMapping("/jsPay")
    public ModelAndView  toJsPay() {
        ModelAndView mav = new ModelAndView();
        TreeMap<String,Object> paramMap = new TreeMap<String,Object>();

        paramMap.put("appId",appId);//公众号id
        paramMap.put("timeStamp",System.currentTimeMillis()/1000);//时间戳
        paramMap.put("nonceStr",System.currentTimeMillis());//随机字符串
        paramMap.put("package","package");//统一下单接口返回的prepay_id参数值，提交格式如：prepay_id=***
        paramMap.put("signType","MD5");//签名类型，默认为MD5，支持HMAC-SHA256和MD5。注意此处需与统一下单的签名类型一致

        String paySign = getMd5Sign(paramMap,sellerPayKey);
        paramMap.put("paySign",paySign);//签名

        mav.addAllObjects(paramMap);

        String reqXml = toXmlStr(paramMap);

        mav.setViewName("weChat/jsPay");

        return mav;
    }

    private String getMd5Sign(Map paramMap ,String sellerPayKey){
        TreeMap<String,Object> treeMap = new TreeMap<String,Object>();
        treeMap.putAll(paramMap);
        StringBuffer strBuf = new StringBuffer(1024);

        for(String key : treeMap.keySet()){
            strBuf.append(key);
            strBuf.append("=");
            strBuf.append(String.valueOf(treeMap.get(key)));
            strBuf.append("&");
        }
        strBuf.append("key");
        strBuf.append("=");
        strBuf.append(sellerPayKey);

        System.out.println(strBuf.toString());
        String single = DigestUtils.md5DigestAsHex(strBuf.toString().getBytes()).toUpperCase();
        System.out.println(single);

        return single;

    }

    private String toXmlStr(Map<String,Object> paramMap){
        StringBuffer strBuf = new StringBuffer(1024);

        strBuf.append("<xml>");

        for(String key : paramMap.keySet()){
            strBuf.append("<");
            strBuf.append(key);
            strBuf.append(">");

            strBuf.append(String.valueOf(paramMap.get(key)));

            strBuf.append("</");
            strBuf.append(key);
            strBuf.append(">");

        }

        strBuf.append("</xml>");

        return strBuf.toString();

    }
}
