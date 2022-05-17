package com.cj.mpgen.util.gen;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.BeetlTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.keywords.MySqlKeyWordsHandler;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * @description: 代码生成器
 **/
@Slf4j
public class CodeGenerator35 {

    public static void main(String[] args) {

        String projectPath = System.getProperty("user.dir").replaceAll("\\\\","/") + "/src/main";
        DataSourceConfig build = new DataSourceConfig.Builder("jdbc:mysql://47.103.64.182:63306/ujiev2", "root", "rootpass")
                .typeConvert(new MySqlTypeConvert())
                .keyWordsHandler(new MySqlKeyWordsHandler())
                .build();


        FastAutoGenerator.create("jdbc:mysql://47.103.64.182:63306/ujiev2", "root", "rootpass")
                .globalConfig(builder -> {
                    builder.author("acheck") // 设置作者
                            .fileOverride() // 覆盖已生成文件
                            .enableSwagger() // 开启 swagger 模式
                            .author("admin")
                            .enableSwagger()
                            .dateType(DateType.ONLY_DATE)
                            .outputDir(projectPath + "/java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.cj") // 设置父包名
                            .moduleName("sshop") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, projectPath + "/resources/xml")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(getTables("v8_good")) // 设置需要生成的表名
                            .addTablePrefix("t_", "c_") // 设置过滤表前缀



                            .entityBuilder()
                            .enableChainModel()
                            .enableLombok()
                            .columnNaming(NamingStrategy.underline_to_camel)

                            .controllerBuilder()
                            .enableRestStyle()

                            .serviceBuilder()
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImp")

                            .mapperBuilder()
                            .superClass(BaseMapper.class)
                            .enableMapperAnnotation()
                            .enableBaseResultMap()
                            .enableBaseColumnList()

                    ;

                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }

    // 处理 all 情况
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }
}

