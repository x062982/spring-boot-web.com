package com.shanezhou.springboot.templates;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ZhouWX
 * @CreateDate 2020/7/21 星期二
 */
public class FreeMarkerDemo {

    private static final String TEMPLATE_PATH = "src\\main\\java\\com\\shanezhou\\springboot\\templates";
    private static final String CLASS_PATH = "src\\main\\java\\com\\shanezhou\\springboot\\templates";

    public static void main(String[] args) {

        String className = "AutoCodeDemo";
        // 1.创建 freemarker 配置实例
        Configuration configuration = new Configuration();
        Writer out = null;
        try {
            // 2.获取模板路径
            configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
            // 3.创建数据模型
            Map<String, Object> map = new HashMap<>();
            // classpath
            map.put("classpath", "com.shanezhou.springboot.templates");
            // classname
            map.put("classname", className);
            // helloword
            map.put("helloworld", "通过freemarker自动创建的类！");

            // 4.加载模板文件
            Template template = configuration.getTemplate("hello.ftl");
            // 5.生成数据
            File file = new File(CLASS_PATH + "\\" + className + ".java");
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            // 6.输出文件
            template.process(map, out);
            System.out.println("创建文件成功！");
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

}
