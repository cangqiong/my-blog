package com.cang.blog.util;

import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ConfigEncryptUtils {

    private String pass = "pass";

    @Test
    public void test() {

        BasicTextEncryptor encryptor = new BasicTextEncryptor();
        // 获取加密参数
        encryptor.setPassword(pass);

        System.out.println(encryptor.encrypt("test"));
        System.out.println(encryptor.encrypt("a123456"));
    }
}