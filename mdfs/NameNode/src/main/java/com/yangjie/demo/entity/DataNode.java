package com.yangjie.demo.entity;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataNode {
    private String id;
    private int port;
    private String ip;

    public DataNode(String id,int port,String ip){
        this.id = id;
        this.port = port;
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public String getId() {
        return id;
    }

    public String getData(String fileName) {
//        return "MOCK";
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> paramMap = new HashMap<>();
        String url = getUrl() + "?fileName={fileName}";
        paramMap.put("fileName", fileName);
        HttpEntity<String> response = restTemplate.getForEntity(url, String.class, paramMap);
        return response.getBody();
    }

    public void setData(String fileName,String data) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> paramMap = new HashMap<>();
        String url = getUrl() + "?fileName={fileName}&data={data}";
        paramMap.put("fileName", fileName);
        paramMap.put("data", data);
        restTemplate.put(url, "", paramMap);
    }

    private String getUrl() {
        return "http://" + ip + ":" + port;
    }

}
