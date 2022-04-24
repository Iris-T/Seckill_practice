package cn.iris.seckill.service.impl;

import cn.iris.seckill.exception.GlobalException;
import cn.iris.seckill.mapper.UserMapper;
import cn.iris.seckill.pojo.User;
import cn.iris.seckill.service.IUserService;
import cn.iris.seckill.util.CookieUtil;
import cn.iris.seckill.util.MD5Util;
import cn.iris.seckill.util.UUIDUtil;
import cn.iris.seckill.vo.LoginVO;
import cn.iris.seckill.vo.RespBean;
import cn.iris.seckill.vo.RespBeanEnum;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Iris
 * @since 2022-04-19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 用户登录
     *
     * @param loginVO 登录信息对象
     * @param req
     * @param resp
     * @return 结果对象
     */
    @Override
    public RespBean doLogin(LoginVO loginVO, HttpServletRequest req, HttpServletResponse resp) {
        String mobile = loginVO.getMobile();
        String password = loginVO.getPassword();
        // 获取用户信息
        User user = userMapper.selectById(mobile);
        if (null == user) {
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
        }
        // 匹配密码
        if (!MD5Util.formPassToDBPass(password, user.getSlat()).equals(user.getPasword())) {
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
        }
        // 生成Cookie
        String ticket = UUIDUtil.uuid();
        // 将用户信息存入Redis
        redisTemplate.opsForValue().set("user:"+ticket, user);
        CookieUtil.setCookie(req, resp, "UserLoginTicket", ticket);
        return RespBean.success();
    }

    @Override
    public User getUserByCookie(String userTicket, HttpServletRequest req, HttpServletResponse resp) {
        if (ObjectUtils.isEmpty(userTicket)) {
            return null;
        }
        User user = (User) redisTemplate.opsForValue().get("user:" + userTicket);
        if (null != user) {
            CookieUtil.setCookie(req, resp, "UserLoginTicket", userTicket);
        }
        return user;
    }
}
