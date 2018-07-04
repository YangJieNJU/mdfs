package com.yangjie.demo.web;

import com.yangjie.demo.entity.File;
import com.yangjie.demo.entity.FileSystem;
import com.yangjie.demo.service.FileService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class NameNodeController {
    FileSystem fileSystem = new FileSystem();

    @RequestMapping(value = "/**",method = RequestMethod.GET)
    String index(HttpServletRequest request){
        FileService fileService = new FileService(fileSystem);
        String json = fileService.dealGET(request.getRequestURI());
        return json;
    }

    @RequestMapping(value = "/**", method = RequestMethod.PUT)
    String index2(HttpServletRequest request,
                  @RequestParam(value = "data") String content){
        System.out.println("success");
        String fileName = request.getRequestURI();
        File newFile = new File(fileName,content);
        System.out.println(fileSystem);
        System.out.println(newFile);
        fileSystem.addFile(newFile);
        return "Added Successfully!";
    }

    @RequestMapping(value = "/**", method = RequestMethod.DELETE)
    String index3(HttpServletRequest request){
        FileService fileService = new FileService(fileSystem);
        String res = fileService.dealDELETE(request.getRequestURI());
        return res;
    }
}
