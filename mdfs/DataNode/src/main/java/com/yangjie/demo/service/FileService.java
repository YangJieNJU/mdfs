package com.yangjie.demo.service;

import com.yangjie.demo.entity.File;

import java.util.ArrayList;

public class FileService {
    private File file;
    public FileService(File file){
        this.file = file;
    }

    public ArrayList<String> analyseURI(String uri){
        ArrayList<String> catalogFile = new ArrayList<String>();
        for(String eachFileName : file.fileName){
            if(eachFileName.indexOf(uri) == 0){
                catalogFile.add(eachFileName);
            }
        }
        return catalogFile;
    }

    public int isCatalog(ArrayList<String> catalogFile){
        if(catalogFile.size() == 0)
            return 0;
        else if(catalogFile.size() == 1)
            return 1;
        else
            return 2;
    }

    public String getFileContent(String fileName){
        int num = file.fileName.indexOf(fileName);
        return file.fileContent.get(num);
    }

    public String dealGET(String uri){
        String json = "";
        ArrayList<String> catalogFile = analyseURI(uri);
        int res = isCatalog(catalogFile);
        if(res == 0)
            json += "Failed!No files existed\n";
        else if(res == 1 && catalogFile.get(0).length() == uri.length()){
            json += getFileContent(catalogFile.get(0)) + "\n";
        }
        else
            json += catalogFile + "\n";
        return json;
    }

    public void dealDELETE(String filename){
        int num = file.fileName.indexOf(filename);
        file.fileName.remove(num);
        file.fileContent.remove(num);
    }
}
