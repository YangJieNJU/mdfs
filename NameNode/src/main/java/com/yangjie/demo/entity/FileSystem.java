package com.yangjie.demo.entity;

import java.util.ArrayList;

public class FileSystem {
    public ArrayList<File> files = new ArrayList<File>();

    public void addFile(File newFile){
        newFile.setDataNodes(20);
        files.add(newFile);
    }

    public String getFile(String fileName){
        String res = "";
        for(File eachFile : files){
            if(fileName == eachFile.getFileName())
                res = eachFile.getContent();
        }
        if(res.equals(""))
            return "No file existed!";
        else
            return res;
    }

    public void deleteFile(File file){
        int num = files.indexOf(file);
        files.remove(num);
    }
}
