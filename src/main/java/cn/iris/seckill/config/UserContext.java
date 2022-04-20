package cn.iris.seckill.config;

import cn.iris.seckill.pojo.User;

/**
 * @author Iris 2022/4/20
 */
public class UserContext {

    private static ThreadLocal<User> userHolder = new ThreadLocal<User>();

    public static void setUser(User user) {
        userHolder.set(user);
    }

    public static User getUser() {
        return userHolder.get();
    }
}
