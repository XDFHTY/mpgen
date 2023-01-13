package com.cj.core.util.parameter;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class parameterUtil {
    /**
     * 拼接get请求的url请求地址
     */
    public static String getUrl(String url, Map<String, Object> params) {
        StringBuilder builder = new StringBuilder(url);
        boolean isFirst = true;
        for (String key : params.keySet()) {
            if (key != null && params.get(key) != null) {
                if (isFirst) {
                    isFirst = false;
                    builder.append("?");
                } else {
                    builder.append("&");
                }
                builder.append(key)
                        .append("=")
                        .append(params.get(key));
            }
        }
        log.info("====>>restURL:");
        log.info(builder.toString());
        return builder.toString();
    }
}
