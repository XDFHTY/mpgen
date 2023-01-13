package com.cj.core.util;

import java.util.Stack;

public class Base64Util {
    /**
     * @author online zuozuo 于2017年2月18日下午12:12:39编辑 --- 10进制与64进制互转类
     */
    public static void main(String[] args) {
        System.out.println("10进制与64进制互转类");
        System.out.println(encodeNumber(1456));
        System.out.println(decode("Ww"));

    }

    // 打乱编码,必须使用本集合进行解码
    public static final char[] array = {
            '4', '5', '6', '7', '8', '9', '-', '*',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
            'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z', '0', '1', '2', '3',
    };

    /**
     * 编码,从10进制转换到64进制
     *
     * @param number long类型的10进制数,该数必须大于0
     * @return string类型的64进制数
     */
    public static String encodeNumber(long number) {
        Long rest = number;
// 创建栈
        Stack stack = new Stack();
        StringBuilder result = new StringBuilder(0);
        while (rest >= 1) {
// 进栈,
// 也可以使用(rest - (rest / 64) * 64)作为求余算法
            stack.add(array[new Long(rest % 64).intValue()]);
            rest = rest / 64;
        }
        for (; !stack.isEmpty(); ) {
// 出栈
            result.append(stack.pop());
        }
        return result.toString();
    }

    /**
     * 解码,从64进制解码到10进制
     *
     * @param str string类型的64进制数A-Z,a-z,0-9,+,-
     * @return long类型的10进制数
     */

    public static long decode(String str) {
// 倍数
        int multiple = 1;
        long result = 0;
        Character c;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(str.length() - i - 1);
            result += decodeChar(c) * multiple;
            multiple = multiple * 64;
        }
        return result;

    }

    /**
     * 比对数组,得到字符对应的值
     *
     * @param c 64位字符
     * @return
     */

    private static int decodeChar(Character c) {
        for (int i = 0; i < array.length; i++) {
            if (c == array[i]) {
                return i;
            }
        }
        return -1;
    }

}
