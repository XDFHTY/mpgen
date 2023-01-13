package com.cj.core.util.timeUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

    public static final String YYYY = "yyyy";
    public static final String YYYY_MM = "yyyy-MM";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String HH = "HH";
    public static final String HH_MM_SS = "HH:mm:ss";
    public static final String YYYY_MM_DDHHMM = "yyyy-MM-dd HH:mm";
    public static final String YYYY_MM_DDHHMMSS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MM_DDHHMMSS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String YYYY_MM_DDTHHMMSS_SSSZ = "yyyy-MM-ddTHH:mm:ss.SSSZ";

    public static final String YYYYMM = "yyyyMM";
    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String YYYYMMDDHH = "yyyyMMddHH";
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String YYMMDDHHMMSS = "yyMMddHHmmss";
    public static final String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";

    public static final String YYYY_MM_1 = "yyyy/MM";
    public static final String YYYY_MM_DD_1 = "yyyy/MM/dd";
    public static final String YYYYMMDDHHMMSS_1 = "yyyy/MM/dd HH:mm:ss";



    /**
     * 自定义取值，Date类型转为String类型
     *
     * @param date    日期
     * @param pattern 格式化常量
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static String dateToStr(Date date, String pattern) {
        SimpleDateFormat format = null;

        if (null == date) {
            return null;
        }
        format = new SimpleDateFormat(pattern, Locale.getDefault());

        return format.format(date);
    }
    public static String timestampToStr(long time, String pattern) {
        SimpleDateFormat format = null;

        if (time == 0) {
            return null;
        }
        format = new SimpleDateFormat(pattern, Locale.getDefault());

        return format.format(new Date(time));
    }

    /**
     * 将字符串转换成Date类型的时间
     * <hr>
     *
     * @param str 日期类型的字符串<br>
     *            datePattern :YYYY_MM_DD<br>
     * @return java.config.Date
     */
    public static Date strToDate(String str, String pattern) {
        if (str == null) {
            return null;
        }
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * datetime to date
     *
     * @param datetime
     * @return
     */
    public static Date datetime2Date(Date datetime) {
        if (null == datetime) {
            return null;
        }

        return strToDate(dateToStr(datetime, YYYY_MM_DDHHMMSS), YYYY_MM_DD);

    }

    


    /**
     * 日期相加减
     *
     * @param time 时间字符串 yyyy-MM-dd HH:mm:ss
     * @param num  加的数，-num就是减去
     * @return 减去相应的数量的年的日期
     * @throws ParseException
     */
    public static Date yearAddNum(Date time, Integer num) {
        
        

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        calendar.add(Calendar.YEAR, num);
        Date newTime = calendar.getTime();
        return newTime;
    }

    /**
     * @param time 时间
     * @param num  加的数，-num就是减去
     * @return 减去相应的数量的月份的日期
     * @throws ParseException Date
     */
    public static Date monthAddNum(Date time, Integer num) {
        
        

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        calendar.add(Calendar.MONTH, num);
        Date newTime = calendar.getTime();
        return newTime;
    }

    /**
     * @param time 时间
     * @param num  加的数，-num就是减去
     * @return 减去相应的数量的天的日期
     * @throws ParseException Date
     */
    public static Date dayAddNum(Date time, Integer num) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        calendar.add(Calendar.DATE, num);
        Date newTime = calendar.getTime();
        return newTime;
    }
    public static Date hourAddNum(Date time, Integer num) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        calendar.add(Calendar.HOUR, num);
        Date newTime = calendar.getTime();
        return newTime;
    }


    /**
     * 获取本月第一天时间
     */
    public static Date getMonthStartDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 获取本月最后一天
     */
    public static Date getMonthEndDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    /**
     * 获取本周的开始时间
     */
    public static Date getBeginWeekDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int dayofweek = cal.get(Calendar.DAY_OF_WEEK);

        if (dayofweek == 1) {
            dayofweek += 7;
        }
        cal.add(Calendar.DATE, 2 - dayofweek);
        return cal.getTime();
    }


    /**
     * 本周的结束时间
     * 开始时间 + 6天
     */
    public static Date getEndWeekDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayofweek == 1) {
            dayofweek += 7;
        }
        cal.add(Calendar.DATE, 8 - dayofweek);
        return cal.getTime();
    }

    /**
     * 判断两个时间范围是否有交集
     *
     * @param dynaStartTime  比较时间段开始时间
     * @param dynaEndTime    比较时间段结束时间
     * @param fixedStartTime 参考时间段开始时间
     * @param fixedEndTime   参考时间段结束时间
     * @return
     */
    public static Boolean checkTimesHasOverlap(Date dynaStartTime, Date dynaEndTime, Date fixedStartTime, Date fixedEndTime) {

        if (dynaStartTime.getTime() <= dynaEndTime.getTime()
                && dynaEndTime.getTime() <= fixedStartTime.getTime()
                && fixedStartTime.getTime() <= fixedEndTime.getTime()) {

            
            return false;
        }else {
            return true;
        }

    }

    public static String getNewDate(){

        return dateToStr(new Date(),YYYY_MM_DDHHMMSS);
    }

    /**
     * 年龄转日期
     *
     * @param o
     * @return
     */
    public static String ageToYear(Object o) {
        if (o == null) return null;
        Calendar cal = Calendar.getInstance();
        int yearNow = cal.get(Calendar.YEAR);
        String year = (yearNow - (Double.valueOf(o.toString())).intValue()) + "-00-00";
        return year;
    }


}
