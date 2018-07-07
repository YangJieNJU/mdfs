package com.yangjie.demo.entity;

import java.util.ArrayList;

public class File {
    public ArrayList<String> fileName = new ArrayList<String>();
    public ArrayList<String> fileContent = new ArrayList<String>();

    public void addFile(String newFileName,String newFileContent){
        fileName.add(newFileName);
        fileContent.add(newFileContent);

    }
}