package com.yangjie.demo.entity;

import com.yangjie.demo.service.DataNodeSystem;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Random;

public class File {
    private String fileName;
    private String fileContent;
    private ArrayList<DataNode> dataNodes = new ArrayList<DataNode>();
    int numOfNode;

    @Autowired
    public DataNodeSystem dataNodeSystem;

    public File(String fileName,String fileContent){
        this.fileName = fileName;
        this.fileContent = fileContent;
        numOfNode = 0;
    }

    public void addDataNode(DataNode newDataNode){
        dataNodes.add(newDataNode);
        numOfNode++;
    }

    public String getContent(){
        return fileContent;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileContent(){
        String content = "";
        int id = 0;
        for(DataNode eachDataNode : dataNodes){
            String dataNodeFileName = fileName + id;
            String res = eachDataNode.getData(dataNodeFileName);
            content += res;
            id++;
        }
        return content;
    }

    public void setDataNodes(int length){

        int id = 0;
        int flag = 0;
        Random random = new Random();
        while(flag + length < fileContent.length()){
            String sub = fileContent.substring(flag,flag+length);
            flag += length;
            String dataNodeFileName = fileName + id;
            int randomNumber = random.nextInt(dataNodeSystem.getNumber());
            dataNodeSystem.dataNodes.get(randomNumber).setData(dataNodeFileName,sub);
            this.addDataNode(dataNodeSystem.dataNodes.get(randomNumber));
        }
    }
}
