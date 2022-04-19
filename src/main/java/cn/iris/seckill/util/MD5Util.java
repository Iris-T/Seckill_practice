package cn.iris.seckill.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

/**
 * MD5加解密工具类
 * @author Iris 2022/4/19
 */
@Component
public class MD5Util {

    public static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }

    private static final String SLAT = "foxiris";

    public static String inputPassToFormPass(String inputPass) {
        String str ="" + SLAT.charAt(2) + SLAT.charAt(3) + inputPass + SLAT.charAt(4) + SLAT.charAt(5);
        return md5(str);
    }

    public static String formPassToDBPass(String formPass, String salt) {
        String str = salt.charAt(2) + salt.charAt(3) + formPass + salt.charAt(4) + salt.charAt(5);
        return md5(str);
    }

    public static String inputPassToDBPass(String inputPass, String slatDB) {
        String formPass = inputPassToFormPass(inputPass);
        return formPassToDBPass(formPass, slatDB);
    }
}
