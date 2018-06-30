package com.yangjie.demo.service;

import com.yangjie.demo.entity.DataNode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DataNodeSystem {
    public ArrayList<DataNode> dataNodes = new ArrayList<DataNode>();
    private int number;

    public DataNodeSystem(){
        this.number = 0;
    }

    public int getNumber() {
        return number;
    }

    public void addDataNode(String id, int port, String ip){
        DataNode newDataNode = new DataNode(id,port,ip);
        dataNodes.add(newDataNode);
        number++;
    }

    public void deleteDataNode(String id){
        for(DataNode eachDataNode : dataNodes){
            if(eachDataNode.getId().equals(id)){
                DataNode deadDataNode = eachDataNode;
                dataNodes.remove(deadDataNode);
            }
        }
        number--;
    }
}
