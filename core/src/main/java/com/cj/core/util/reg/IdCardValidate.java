package com.cj.core.util.reg;


import com.cj.core.util.timeUtil.DateUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class IdCardValidate {



    public static void main(String[] args) {
        System.err.println(vlidateIdcard("110825199004014010"));
        // 构造一个符合验证的假身份证号
        System.err.println(genernateCert("110825199004014012"));
    }

    // 省份数据
    private static Map<Integer, String> provs = new HashMap<>();

    static {
        provs.put(11, "北京");
        provs.put(12, "天津");
        provs.put(13, "河北");
        provs.put(14, "山西");
        provs.put(15, "内蒙古");
        provs.put(21, "辽宁");
        provs.put(22, "吉林");
        provs.put(23, "黑龙江");
        provs.put(31, "上海");
        provs.put(32, "江苏");
        provs.put(33, "浙江");
        provs.put(34, "安徽");
        provs.put(35, "福建");
        provs.put(36, "江西");
        provs.put(37, "山东");
        provs.put(41, "河南");
        provs.put(42, "湖北 ");
        provs.put(43, "湖南");
        provs.put(44, "广东");
        provs.put(45, "广西");
        provs.put(46, "海南");
        provs.put(50, "重庆");
        provs.put(51, "四川");
        provs.put(52, "贵州");
        provs.put(53, "云南");
        provs.put(54, "西藏 ");
        provs.put(61, "陕西");
        provs.put(62, "甘肃");
        provs.put(63, "青海");
        provs.put(64, "宁夏");
        provs.put(65, "新疆");
        provs.put(71, "台湾");
        provs.put(81, "香港");
        provs.put(82, "澳门");

    }
    // 验证身份号前18，符合一个简单的身份证号，年是18-20开头的年份
    private static boolean checkCode(String cert) {
        String regex = "^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";
        if (Pattern.matches(regex, cert)) {
// 校验合算法
            int[] factor = new int[] { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
            String[] parity = new String[] { "1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2" };
            String code = cert.substring(17);
            int sum = 0;
            for (int i = 0; i < 17; i++) {
                sum += Integer.parseInt(String.valueOf(cert.charAt(i))) * factor[i];
            }
            if (parity[sum % 11].equals(code.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    // 构造符合身份证号规律的身份证号
    private static String genernateCert(String cert) {
        String regex = "^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";
        if (Pattern.matches(regex, cert)) {
            int[] factor = new int[] { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
            String[] parity = new String[] { "1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2" };
            String code = cert.substring(17);
            int sum = 0;
            for (int i = 0; i < 17; i++) {
                sum += Integer.parseInt(String.valueOf(cert.charAt(i))) * factor[i];
            }
            return cert.substring(0,17)+parity[sum % 11];
        }
        return cert;
    }
    // 组合起来，分段验证，提高效率(符合正则使用习惯，分段验证，提高性能)
    public static boolean vlidateIdcard(String cert) {
        if (checkCode(cert)) {
            String date = cert.substring(6, 14);
            if (checkDate(date)) {
                if (checkProv(cert.substring(0, 2))) {
                    return true;
                }
            }
        }
        return false;
    }
    // 验证年
    private static boolean checkDate(String date) {
        String pattern = "^(18|19|20)\\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)$";
        if (Pattern.matches(pattern, date)) {
            String month = date.substring(4, 6);
            try {
                Date date2 = DateUtil.strToDate(date,"yyyyMMdd");
                // 这里检验月的原因的，润年校验
                if (date2 != null && date2.getMonth() == (Integer.parseInt(month) - 1)) {
                    return true;
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        return false;
    }
    // 检查省份
    private static boolean checkProv(String prov) {
        String pattern = "^[1-9][0-9]";

        if (Pattern.matches(pattern, prov)) {
            return provs.containsKey(Integer.parseInt(prov));
        }
        return false;
    }

}