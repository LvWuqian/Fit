package org.csu.fit.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class OssConfiguration {
    @Value("${endpoint}")
    private String ENDPOINT;
    @Value("${accessKeyId}")
    private String ACCESSKEYID;
    @Value("${accessKeySecret}")
    private String ACCESSKEYSECRET;
    @Value("${bucketName}")
    private String BUCKETNAME;
    @Value("${filehost}")
    private String FILEHOST;
    @Value("${prefix}")
    private String PREFIX;

    public String getENDPOINT() {
        return ENDPOINT;
    }

    public void setENDPOINT(String ENDPOINT) {
        this.ENDPOINT = ENDPOINT;
    }

    public String getACCESSKEYID() {
        return ACCESSKEYID;
    }

    public void setACCESSKEYID(String ACCESSKEYID) {
        this.ACCESSKEYID = ACCESSKEYID;
    }

    public String getACCESSKEYSECRET() {
        return ACCESSKEYSECRET;
    }

    public void setACCESSKEYSECRET(String ACCESSKEYSECRET) {
        this.ACCESSKEYSECRET = ACCESSKEYSECRET;
    }

    public String getBUCKETNAME() {
        return BUCKETNAME;
    }

    public void setBUCKETNAME(String BUCKETNAME) {
        this.BUCKETNAME = BUCKETNAME;
    }

    public String getFILEHOST() {
        return FILEHOST;
    }

    public void setFILEHOST(String FILEHOST) {
        this.FILEHOST = FILEHOST;
    }

    public String getPREFIX() {
        return PREFIX;
    }

    public void setPREFIX(String PREFIX) {
        this.PREFIX = PREFIX;
    }
}

