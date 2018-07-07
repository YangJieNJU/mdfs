package com.yangjie.demo.web;

import com.yangjie.demo.entity.File;
import com.yangjie.demo.service.FileService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class DataNodeController {
    File file = new File();

    @RequestMapping(value = "/**",method = RequestMethod.GET)
    String index(HttpServletRequest request){
        FileService fileService = new FileService(file);
        String json = fileService.dealGET(request.getRequestURI());
        System.out.println(json);
        return json;
    }

    @RequestMapping(value = "/**", method = RequestMethod.PUT)
    String index2(HttpServletRequest request,
                  @RequestParam(value = "data") String content){
        System.out.println(content);
        String fileName = request.getRequestURI();
        file.addFile(fileName,content);
        return "Added Successfully!";
    }

    @RequestMapping(value = "/**", method = RequestMethod.DELETE)
    String index3(HttpServletRequest request){
        FileService fileService = new FileService(file);
        fileService.dealDELETE(request.getRequestURI());
        return "Delete Successfully";
    }
}
