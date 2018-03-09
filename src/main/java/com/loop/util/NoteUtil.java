package com.loop.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.apache.tomcat.util.codec.binary.Base64;

/**
 * author  loop
 * create  2018-01-22 22:00.
 */


public class NoteUtil {


    /**
     * MD5加密：摘要算法
     * 特点：任意长度字节处理成等长结果；不可逆
     * Base64: a-z A-Z 0-9 = +
     */
    public static String md5(String src) {
        try{
            MessageDigest md = MessageDigest.getInstance("md5");
            byte[] output = md.digest(src.getBytes());

            //返回成Base64字符
            String result = Base64.encodeBase64String(output);
            return result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return src;
    }

    /**
     * UUID算法生成主键
     */
    public static String generateId() {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString().replace("-", "");

        return id;
    }



}
