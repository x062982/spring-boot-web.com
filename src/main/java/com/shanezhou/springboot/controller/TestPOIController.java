package com.shanezhou.springboot.controller;

import com.shanezhou.springboot.service.IStudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @Author ZhouWX
 * @CreateDate 2020/8/5 星期三
 */
@RestController
public class TestPOIController {

    @Resource
    private IStudentService studentService;

    @PostMapping("/import/excel")
    public String importData(@RequestParam("myFile")MultipartFile myFile) throws Exception {
        Integer integer = studentService.importExcel(myFile);
        System.out.println(integer);
        return "success";
    }
}
