package com.yjjk.erp.utility.wx;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;

public class MyConfig extends WXPayConfig {


    private byte[] certData;
    public MyConfig() throws Exception {
//    	ClassPathResource cp = new ClassPathResource("apiclient_cert.p12");
//    	File files =cp.getFile();
//    	 this.certData = new byte[(int)files.length()];
//    	 InputStream certStream = new FileInputStream(files);
		String relativelyPath=System.getProperty("user.dir");
        String certPath = relativelyPath+"/apiclient_cert.p12";
        File file = new File(certPath);
        InputStream certStream = new FileInputStream(file);
        this.certData = new byte[(int) file.length()];
        certStream.read(this.certData);
        certStream.close();
    }

    @Override
    public String getAppID() {
        return "wxb21e2eb790f4ee9d";
    }

    @Override
    public String getMchID() {
        return "1553417871";
    }

    @Override
    public String getKey() {
        return "4e3ae26a673342f8970180aaf01b4a1d";
    }

    @Override
    public InputStream getCertStream() {
        ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }

    @Override
    public int getHttpConnectTimeoutMs() {
        return 8000;
    }

    @Override
    public int getHttpReadTimeoutMs() {
        return 10000;
    }

    @Override
    IWXPayDomain getWXPayDomain() {
        return new IWXPayDomain() {
            @Override
            public void report(String domain, long elapsedTimeMillis, Exception ex) {
            }

            @Override
            public DomainInfo getDomain(WXPayConfig config) {
                return new DomainInfo("api.mch.weixin.qq.com", false);
            }
        };
    }
}
