package com.example.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;

import com.example.demo.util.QRCodeUtil;
@PropertySource("classpath:pay.properties")
public class QRCodeTest {
	 /**
     * 商户支付密钥 生成签名时用
     */
    @Value("${wx.apiKey}")
    private String apiKey;
    /**
     * 公众账号ID(企业号corpid)
     */
    @Value("${wx.appId}")
    private String appId;
    /**
     * 商户号
     */
    @Value("${wx.mchId}")
    private String mchId;
    /**
     * 刷卡支付url
     */
    @Value("${wx.barCodePayUrl}")
    private String barCodePayUrl;
    /**
     * 申请退款url
     */
    @Value("${wx.refundUrl}")
    private String refundUrl;
    /**
     * 查询订单url
     */
    @Value("${wx.orderQueryUrl}")
    private String orderQueryUrl;
    /**
     * 退款查询url
     */
    @Value("${wx.refundQueryUrl}")
    private String refundQueryUrl;
	@Test
	public void test01() throws IOException {
		 
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append("//wxpay/bizpayurl?");
		sBuffer.append("appid="+appId);
		sBuffer.append("&mch_id="+mchId);
		sBuffer.append("&nonce_str=f6808210402125e30663234f94c87a8c");
		sBuffer.append("&product_id="+1);
		sBuffer.append("&time_stamp="+new Date().getTime());
		sBuffer.append("&sign=512F68131DD251DA4A45DA79CC7EFE9D");
		ClassPathResource file = new ClassPathResource("pic");
        String path = file.getFile().getAbsolutePath();
        System.out.println(path);
        File image = new File(path+File.separator+"logo.png");
        FileInputStream logo=new FileInputStream(image);
        File out = new File(path+File.separator+"QRCode.png");
        QRCodeUtil.createCodeLogo(out,sBuffer.toString(),logo,"");
        System.out.println(out.getAbsolutePath());
	}
	@Test
	public void test02() throws IOException {
		ClassPathResource file = new ClassPathResource("pic");
        String path = file.getFile().getAbsolutePath();
        System.out.println(path);
        File image = new File(path+File.separator+"logo.png");
        FileInputStream logo=new FileInputStream(image);
        File out = new File(path+File.separator+"QRCode.png");
        QRCodeUtil.createCodeLogo(out,"http://baidu.com",logo,"");
        System.out.println(out.getAbsolutePath());
	}
	
}
