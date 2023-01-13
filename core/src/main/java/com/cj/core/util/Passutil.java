package com.cj.core.util;

import static com.cj.core.util.md5.Md5Utils.MD5Encode;

public class Passutil {

    public static String enPass(long id, String saltval, String plPass) {
        return MD5Encode(id + saltval + plPass, "UTF-8", true);
    }

    public static String enPass(String saltval, String plPass) {
        return MD5Encode(saltval + plPass, "UTF-8", true);
    }

    public static boolean checkPass(Long id, String saltval, String enPass, String plPass) {
        if (enPass(id, saltval, plPass).equals(enPass) || enPass(saltval, plPass).equals(enPass)) {
            return true;
        }
        return false;
    }

    public static String getDefultPass(){
        return "12345678";
    }
}
