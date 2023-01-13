package com.cj.core.config.file;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;
import java.io.File;

/**
 * Created by zsl on 2017/9/3.
 */
@Configuration
public class FileConfig {
    @Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }

    @Value("${web.path}")
    private String path;


























    /**
     * 解决tomcat乱找路径和限制文件大小
     *
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory multipartConfigFactory = new MultipartConfigFactory();





        String location = "data/tmp";
        File tmpFile = new File(location);
        if (!tmpFile.exists()) {
            tmpFile.mkdirs();
        }
        multipartConfigFactory.setLocation(location);

        return multipartConfigFactory.createMultipartConfig();
    }


}