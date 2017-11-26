package com.chason.blog.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则测试类
 *
 * @author cang
 * @date 2017-10-18
 */
public class PattenTest {

    private static String phone = "12323333333";
    private static String idStr = "测试中国3df地方3df地方13725394697地方";
    private String phoneRegExp = "^[1]([3][0-9]{1}|59|58|88|89)[0-9]{8}$";

    public static void main(String[] args) {
        idPattern();

    }

    public static void strTest() {
        String s = "abc def".replaceAll("(\\w+)\\s+(\\w+)", "$2 $1"); //s 就是 "def abc"，replaceFirst 也可以用 $1, $2 的替换。
        System.out.println(s);
        s = "abc def".replace("(\\w+)\\s+(\\w+)", "$2 $1"); //s 就是 "def abc"，replaceFirst 也可以用 $1, $2 的替换。
        System.out.println(s);
        s = "abc def".replaceFirst("(\\w+)\\s+(\\w+)", "$2 $1"); //s 就是 "def abc"，replaceFirst 也可以用 $1, $2 的替换。
        System.out.println(s);

        String res = phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2888");
        System.out.println(res);

    }

    public static void idPattern() {
        Pattern p = Pattern.compile("([1-9]\\d{5})(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)(\\d{3}[0-9Xx])");

        Matcher result = p.matcher("362331199110115278");

        System.out.println(result.matches());


        Matcher m = p.matcher(idStr); // 操作的字符串
        StringBuffer sb = new StringBuffer();
        int i = 0;
        while (m.find()) {
            System.out.println("matched:" + sb);
            m.appendReplacement(sb, "$1***$9");
            i++;    //字符串出现次数
        }
        m.appendTail(sb);//从截取点将后面的字符串接上
        String s = sb.toString();

        System.out.println(s);

    }
}
