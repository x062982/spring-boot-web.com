package com.shanezhou.springboot.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author ZhouWX
 * @CreateDate 2020/8/5 星期三
 */
public interface IStudentService {

    Integer importExcel(MultipartFile myFile) throws Exception;

}
