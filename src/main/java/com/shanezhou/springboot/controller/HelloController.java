package com.shanezhou.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author shaneZhou
 * @Time 2020/05/30 16:57 下午
 */
@Controller
public class HelloController {


    @RequestMapping("/success")
    public String toSuccess(Model model) {
        model.addAttribute("name", "springboot");

        return "success";
    }

}
