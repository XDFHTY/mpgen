package com.cj.core.util;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class SqlUtil {


    /**
     * 备份
     */
    public static void backup(String string,String dir,String dbName) {
        try {
            string = string+dbName;
            Runtime rt = Runtime.getRuntime();



            Process child = rt
                    .exec(string);


            InputStream in = child.getInputStream();

            InputStreamReader xx = new InputStreamReader(in, "utf-8");


            String inStr;
            StringBuffer sb = new StringBuffer("");
            String outStr;

            BufferedReader br = new BufferedReader(xx);
            while ((inStr = br.readLine()) != null) {
                sb.append(inStr + "\r\n");
            }
            outStr = sb.toString();

            File file = new File(dir);
            if (!file.exists()) {
                file.mkdirs();

            }

            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
            String fileName = dbName+"@"+ InetAddress.getLocalHost().getHostAddress()+"_"+sdf.format(new Date())+"_备份.sql";


            FileOutputStream fout = new FileOutputStream(dir+fileName);
            OutputStreamWriter writer = new OutputStreamWriter(fout, "utf-8");
            writer.write(outStr);
            writer.flush();
            in.close();
            xx.close();
            br.close();
            writer.close();
            fout.close();

//            log.info("=====>>>>>"+dbName+"备份结束");

        } catch (Exception e) {
//            log.info("=====>>>>>"+dbName+"备份失败");
            e.printStackTrace();
        }

    }


    /**
     * 还原
     *
     * @param databaseName
     */
    public static void restore(String databaseName) {
        try {
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime
                    .exec("e:\\MySQL\\bin\\mysql.exe -hlocalhost -uroot -p123 --default-character-set=utf8 "
                            + databaseName);
            OutputStream outputStream = process.getOutputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream("C:\\test.sql"), "utf-8"));
            String str = null;
            StringBuffer sb = new StringBuffer();
            while ((str = br.readLine()) != null) {
                sb.append(str + "\r\n");
            }
            str = sb.toString();
            OutputStreamWriter writer = new OutputStreamWriter(outputStream,
                    "utf-8");
            writer.write(str);
            writer.flush();
            outputStream.close();
            br.close();
            writer.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
