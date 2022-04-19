package cn.iris.seckill.service;

import cn.iris.seckill.pojo.User;
import cn.iris.seckill.vo.LoginVO;
import cn.iris.seckill.vo.RespBean;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Iris
 * @since 2022-04-19
 */
public interface IUserService extends IService<User> {

    /**
     * 用户登录
     * @param loginVO 登录信息对象
     * @param req
     * @param resp
     * @return 结果对象
     */
    RespBean doLogin(LoginVO loginVO, HttpServletRequest req, HttpServletResponse resp);
}
