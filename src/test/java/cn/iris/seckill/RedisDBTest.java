package cn.iris.seckill;

import cn.iris.seckill.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author Iris 2022/4/24
 */
@SpringBootTest
public class RedisDBTest {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void test() {
        User user = new User();
        user.setId(1555888855L);
        user.setNickname("Iris");
        redisTemplate.opsForValue().set("user:test", user);
    }
}
