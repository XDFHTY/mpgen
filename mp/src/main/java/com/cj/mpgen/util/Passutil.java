package com.cj.mpgen.util;

import com.cj.mpgen.util.md5.Md5Utils;

import static com.cj.mpgen.util.md5.Md5Utils.MD5Encode;

public class Passutil {

    public static String enPass(long id, String saltval, String plPass) {
        return Md5Utils.MD5Encode(id + saltval + plPass, "UTF-8", true);
    }

    public static String enPass(String saltval, String plPass) {
        return Md5Utils.MD5Encode(saltval + plPass, "UTF-8", true);
    }

    public static boolean checkPass(Long id, String saltval, String plPass, String enPass) {
        if (enPass(id, saltval, plPass).equals(enPass) || enPass(saltval, plPass).equals(enPass)) {
            return true;
        }
        return false;
    }

    public static String getDefultPass(){
        return "12345678";
    }

    public static void main(String[] args) {
        System.out.println(Md5Utils.MD5Encode("superadmins"));
    }
}
