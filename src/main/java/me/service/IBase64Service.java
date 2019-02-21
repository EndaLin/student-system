package me.service;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;

/**
 * @Author: wt
 * @Date: 2019/2/18 14:41
 */
public interface IBase64Service {
    /**
     * 加密
     * @param str
     * @return
     */
    static String getBase64(String str){
        byte[] b=null;
        String s=null;
        try {
            b = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if(b!=null){
            s=new BASE64Encoder().encode(b);
        }
        return s;
    }

    /**
     * 解密
     * @param s
     * @return
     */
    static String getFromBase64(String s){
        byte[] b = null;
        String result = null;
        if (s != null) {
            BASE64Decoder decoder = new BASE64Decoder();
            try {
                b = decoder.decodeBuffer(s);
                result = new String(b, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
