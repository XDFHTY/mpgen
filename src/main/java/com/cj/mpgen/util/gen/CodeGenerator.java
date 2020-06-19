package com.cj.mpgen.util;


import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;


/**
 * @description: 代码生成器
 * @author: liuergu
 * @date: 2019/7/23
 * 参考官方文档：https://mp.baomidou.com/config/generator-config.html#%E5%9F%BA%E6%9C%AC%E9%85%8D%E7%BD%AE
 **/
public class CodeGenerator {

    public static void main(String[] args) {
        // ================= 需要修改的配置 =================

        // 数据源配置
        String jdbcUrl = "jdbc:mysql://139.224.195.76:63306/ujiev2_1_test";
        String jdbcDriver = "com.mysql.jdbc.Driver";
        String jdbcUsername = "root";
        String jdbcPassword = "rootpass";

        // 父级包名配置
        String parentPackage = "com.cj.spension";

        // 生成代码的 @author 值
        String author = "zzz";

        // 要生成代码的表名配置
        String[] tables = {
//                "user_info",
//                "doctor_info",
//                "v2_user_friend",

//                "v3_equipment_step",
//                "v3_equipment_ppg",
//                "v3_equipment_ecg",
//                "v3_equipment_bp",
//                "v3_equipment_sao2",
//                "v3_equipment_sleep",
//                "v3_equipment_gps",

                "v3_err_push_condition",
                "v3_err_surface_log",
                "v3_err_push_log",
        };

        // ==================================================


        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java")
                .setAuthor(author)
                .setBaseResultMap(true)
                .setBaseColumnList(true)
                // 生成完毕后是否打开输出目录
                .setOpen(false)
                // 为true时生成entity将继承Model类，单类即可完成基于单表的业务逻辑操作，按需开启
                .setActiveRecord(true)
                //使用Date作为时间类型
                .setDateType(DateType.ONLY_DATE)
                .setSwagger2(true);


        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc
                .setUrl(jdbcUrl)
                .setDriverName(jdbcDriver)
                .setUsername(jdbcUsername)
                .setPassword(jdbcPassword)
//                .setTypeConvert(new MySqlTypeConvert() {

        ;


        // 包配置
        PackageConfig pc = new PackageConfig();
        // 父级包名，按需修改
        pc
                .setParent("com.cj")
                .setController("spension.controller")
                .setEntity("core.entity")
                .setService("spension.service")
                .setServiceImpl("spension.service.impl")
                .setMapper("spension.mapper")
                .setXml("spension.mapper.xml")
                // 设置模块名, 会在parent包下生成一个指定的模块包
                .setModuleName(null);


        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude(tables)
                .setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                //生成 @RestController 控制器
                .setRestControllerStyle(true)
                .setSuperEntityColumns("id")
                // Controller驼峰连字符，如开启，则requestMapping由 helloWorld 变为 hello-world 默认false
                .setControllerMappingHyphenStyle(false)
                .setTablePrefix(pc.getModuleName() + "_")
                // 开启后将使用lombok注解代替set-get方法，false则生成set-get方法
                .setEntityLombokModel(true)
                // 在实体类中移除is前缀
                .setEntityBooleanColumnRemoveIsPrefix(true);

        new AutoGenerator()
                .setGlobalConfig(gc)
                .setDataSource(dsc)
                .setPackageInfo(pc)
                .setStrategy(strategy)
                .setTemplateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

}

