package cn.iris.seckill.util;

import org.junit.jupiter.api.Test;

/**
 * @author Iris 2022/4/19
 */
public class MD5UtilTest {

    @Test
    public void test() {
//        bf715544dae7464a39ab3ba6f5ca3998
        System.out.println(MD5Util.inputPassToFormPass("foxiris"));
        System.out.println(MD5Util.formPassToDBPass("bf715544dae7464a39ab3ba6f5ca3998", "foxiris"));
        System.out.println(MD5Util.inputPassToDBPass("foxiris", "foxiris"));
    }
}
