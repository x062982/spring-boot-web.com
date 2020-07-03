package com.shanezhou.springboot.generate;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhouWX
 * @createDate 2020/6/23
 */
public class OracleGenerator {

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    //public static String scanner(String tip) {
    //    Scanner scanner = new Scanner(System.in);
    //    StringBuilder help = new StringBuilder();
    //    help.append("请输入" + tip + "：");
    //    System.out.println(help.toString());
    //    if (scanner.hasNext()) {
    //        String ipt = scanner.next();
    //        if (StringUtils.isNotEmpty(ipt)) {
    //            return ipt;
    //        }
    //    }
    //    // scanner.close();
    //    throw new MybatisPlusException("请输入正确的" + tip + "！");
    //}

    /**
     * RUN THIS
     */
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("zhouwx");
        gc.setEntityName("%sEntity");
        gc.setOpen(false);
        gc.setFileOverride(true);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:oracle:thin:@localhost:1521:oracledb");
        dsc.setDbType(DbType.ORACLE);
        //dsc.setSchemaName("FOXDB");
        dsc.setDriverName("oracle.jdbc.driver.OracleDriver");
        dsc.setUsername("C##SHANE");
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        // pc.setModuleName("station");
        pc.setParent("net.sitir.common.relation.responsibilitywithrole");
        pc.setEntity("domain");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        //focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
        //    @Override
        //    public String outputFile(TableInfo tableInfo) {
        //        // 自定义输入文件名称
        //        return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
        //                + "/" + tableInfo.getEntityName().replace("Entity", "") +
        //                "Mapper" + StringPool.DOT_XML;
        //    }
        //});
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setInclude("COMMON_RELATION_RESP_ROLE");
        strategy.setTablePrefix("common_relation");
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);
        // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
        //mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}
