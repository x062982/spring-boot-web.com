package com.shanezhou.springboot.controller;

import com.shanezhou.springboot.generate.QRCodeGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @Author shaneZhou
 * @Time 2020/05/30 16:57 下午
 */
@Controller
@RequestMapping("/hello")
public class HelloController {


    @RequestMapping("/success")
    public String toSuccess(Model model) {
        model.addAttribute("name", "springboot");

        return "success";
    }

    @GetMapping("/qrCode")
    public void getQRCode(HttpServletResponse response) {
        File file = new File("E:\\MyProjects\\SpringBootWeb\\src\\main\\resources\\pic");

        String url = "https://www.baidu.com/";
        String content = "访问百度！";
        BufferedImage image = QRCodeGenerator.drawQRCode(null, url, content);
        OutputStream os = null;
        response.setContentType("image/png");
        try {
            os = response.getOutputStream();
            //ImageIO.write(image, "png", file);
            ImageIO.write(image, "png", os);
            System.out.println("生成二维码成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
