package com.yangjie.demo.service;

import com.yangjie.demo.entity.File;
import com.yangjie.demo.entity.FileSystem;

import java.util.ArrayList;

public class FileService {
    private FileSystem fileSystem;
    private DataNodeSystem dataNodeSystem;
    public FileService(FileSystem fileSystem){
        this.fileSystem = fileSystem;
    }

    public ArrayList<String> analyseURI(String uri){
        ArrayList<String> catalogFile = new ArrayList<String>();
        for(File eachFile : fileSystem.files){
            if(eachFile.getFileName().indexOf(uri) == 0){
                catalogFile.add(eachFile.getFileName());
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
        String res = "";
        for(File eachFile : fileSystem.files){
            if(eachFile.getFileName() == fileName)
                res = eachFile.getContent();
        }
        return res;
    }

    public String dealGET(String uri){
        String json = "";
        ArrayList<String> catalogFile = analyseURI(uri);
        int res = isCatalog(catalogFile);
        if(res == 0)
            json += "Failed!No file existed\n";
        else if(res == 1 && catalogFile.get(0).length() == uri.length()){
            json += getFileContent(catalogFile.get(0)) + "\n";
        }
        else
            json += catalogFile + "\n";
        return json;
    }

    public String dealDELETE(String filename){
        String res = "Failed! file named " + filename + " does't exist!";
        for(File eachFile : fileSystem.files){
            System.out.println(eachFile.getFileName());
            if(eachFile.getFileName().equals(filename)){
                fileSystem.deleteFile(eachFile);
                res = "Deleted Successfully!";
            }
        }
        return res;
    }
}
